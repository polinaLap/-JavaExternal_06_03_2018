package javacourses.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javacourses.pool.ConnectionPooling;
import javacourses.entities.Lesson;
import javacourses.entities.Shedule;
import javacourses.entities.WeekDay;
import org.apache.log4j.Logger;

import static java.sql.Connection.*;

public class SheduleDAO {
    final static Logger logger = org.apache.log4j.Logger.getLogger(LessonDAO.class);
    private ConnectionPooling pool;
    public SheduleDAO(){
        this.pool=ConnectionPooling.getInstance();
    }
    public List<String> getShedule(){
        List<String> res =new ArrayList<String>();
        Connection con = pool.connectionCheck();
        if (con ==null) return res;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement("select WeekDay.name, Lesson.name " +
                    "from (Lesson join Shedule on Lesson.id=Shedule.lessonId) " +
                    "join WeekDay on WeekDay.number=Shedule.dayNumber");
            rs = st.executeQuery();
            while (rs.next()){
                res.add(rs.getString(1)+ rs.getString(2));
            }
        }
        catch (SQLException e){
            logger.error(e.getMessage());
        }
        finally {
            try{
                rs.close();
                con.close();
            }
            catch (SQLException e){
                logger.error(e.getMessage());
            }
        }
        return res;
    }
    public List<Lesson> getLessonsByDay(String day){
        List<Lesson> res =new ArrayList<>();
        Connection con = pool.connectionCheck();
        if (con ==null) return res;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement("select Lesson.id, Lesson.name " +
                    "from (Lesson join Shedule on Lesson.id=Shedule.lessonId) " +
                    "join WeekDay on WeekDay.number=Shedule.dayNumber" +
                    " where WeekDay.name = ?");
            st.setString(1,day);
            rs = st.executeQuery();
            while (rs.next()){
                res.add(new Lesson(rs.getInt(1),rs.getString(2)));
            }
        }
        catch (SQLException e){
            logger.error(e.getMessage());
        }
        finally {
            try{
                rs.close();
                con.close();
            }
            catch (SQLException e){
                logger.error(e.getMessage());
            }
        }
        return res;
    }
    public List<WeekDay> getDaysByLesson(String lesson){
        List<WeekDay> res =new ArrayList<>();
        Connection con = pool.connectionCheck();
        if (con ==null) return res;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement("select WeekDay.number, WeekDay.name " +
                    "from (Lesson join Shedule on Lesson.id=Shedule.lessonId) " +
                    "join WeekDay on WeekDay.number=Shedule.dayNumber" +
                    " where Lesson.name = ?");
            st.setString(1,lesson);
            rs = st.executeQuery();
            while (rs.next()){
                res.add(new WeekDay(rs.getInt(1),rs.getString(2)));
            }
        }
        catch (SQLException e){
            logger.error(e.getMessage());
        }
        finally {
            try{
                rs.close();
                con.close();
            }
            catch (SQLException e){
                logger.error(e.getMessage());
            }
        }
        return res;
    }
    public String addLessonAndReturnMessage(WeekDay day, Lesson lesson){
        String res ="";
        Connection con = pool.connectionCheck();
        if (con ==null) return res;

        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            con.setAutoCommit(false);
            con.setTransactionIsolation(TRANSACTION_READ_COMMITTED);
            String query="select WeekDay.name, Lesson.name " +
                    "from (Lesson join Shedule on Lesson.id=Shedule.lessonId) " +
                    "join WeekDay on WeekDay.number=Shedule.dayNumber " +
                    "where WeekDay.number= ?";
            st = con.prepareStatement(query);
            st.setInt(1,day.getId());
            rs = st.executeQuery();
            while (rs.next()){
                res+=(rs.getString(1)+ " "+ rs.getString(2))+"\n";
            }
            Savepoint savepointOne = con.setSavepoint("SavepointOne");
            try {
                st = con.prepareStatement("inset into Shedule " +
                        "(dayNumber, lessonId)" +
                        " values(?,?)");
                st.setInt(1,day.getId());
                st.setInt(2,lesson.getId());
                st.executeUpdate();
                con.commit();
                logger.info("Add lesson "+lesson.getName()+" to shedule on "+day.getName());
            }
            catch (SQLException e){
                logger.error(e.getMessage()+".  Executing rollback to savepoint.");
                con.rollback(savepointOne);
            }
            res+="Result of adding:\n";
            st = con.prepareStatement(query);
            st.setInt(1,day.getId());
            rs = st.executeQuery();
            while (rs.next()){
                res+=(rs.getString(1)+ " "+ rs.getString(2))+"\n";
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        finally {
            try{
                con.close();
            }
            catch (SQLException e){
                logger.error(e.getMessage());
            }
        }
        return res;
    }
    public void setSheduleLine(WeekDay day, Lesson lesson, int lineNumber){
        Connection con = pool.connectionCheck();
        if (con ==null) return;
        PreparedStatement st = null;
        try {
            st = con.prepareStatement("update Shedule " +
                    "set dayNumber=?, lessonId=?" +
                    " where id=?");
            st.setInt(1,day.getId());
            st.setInt(2,lesson.getId());
            st.setInt(3,lineNumber);
            st.executeUpdate();
            logger.info("Set shedule line "+ lineNumber +" with "+ lesson.getName()+ " on "+ day.getName());
        }
        catch (SQLException e){
            logger.error(e.getMessage());
        }
        finally {
            try{
                con.close();
            }
            catch (SQLException e){
                logger.error(e.getMessage());
            }
        }
    }
    public void removeSheduleLine(int lineNumber){
        Connection con = pool.connectionCheck();
        if (con ==null) return;
        PreparedStatement st = null;
        try {
            st = con.prepareStatement("delete from Shedule " +
                    "where id=?");
            st.setInt(1,lineNumber);
            st.executeUpdate();
            logger.info("Remove shedule line " + lineNumber);
        }
        catch (SQLException e){
            logger.error(e.getMessage());
        }
        finally {
            try{
                con.close();
            }
            catch (SQLException e){
                logger.error(e.getMessage());
            }
        }
    }
    public void removeSheduleLines(List<Shedule> lines){
        Connection con = pool.connectionCheck();
        if (con ==null) return;
        PreparedStatement st = null;

        try {
            con.setAutoCommit(false);
            con.setTransactionIsolation(TRANSACTION_REPEATABLE_READ);
            for (int i = 0; i < lines.size(); i++) {
                try{
                    Savepoint savepoint = con.setSavepoint("savaPoint"+i);
                    st = con.prepareStatement("delete from Shedule " +
                            "where dayNumber=? and lessonId=?");
                    st.setInt(1,lines.get(i).getDayId());
                    st.setInt(2,lines.get(i).getLessonId());
                    st.executeUpdate();
                    con.commit();
                    con.releaseSavepoint(savepoint);
                    logger.info("Remove shedule line with dayNumber="+lines.get(i).getDayId()+" and lessonId=" +lines.get(i).getLessonId());
                }
                catch (SQLException e){
                    logger.error(e.getMessage()+"  Executing rollback to savepoint.");
                }
            }

        }
        catch (SQLException e){
            logger.error(e.getMessage());
        }
        finally {
            try{
                con.close();
            }
            catch (SQLException e){
                logger.error(e.getMessage());
            }
        }
    }
}
