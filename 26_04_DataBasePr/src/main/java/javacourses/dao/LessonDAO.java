package javacourses.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javacourses.pool.ConnectionPooling;
import javacourses.entities.Lesson;
import org.apache.log4j.Logger;

public class LessonDAO {
    final static Logger logger = Logger.getLogger(LessonDAO.class);
    private ConnectionPooling pool;
    public LessonDAO(){
        this.pool=ConnectionPooling.getInstance();
    }
    public Lesson getLessonById(int id){
        Lesson res =null;
        Connection con = pool.connectionCheck();
        if (con ==null) return res;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement("select name " +
                    "from Lesson" +
                    " where id = ?");
            st.setInt(1,id);
            rs = st.executeQuery();
            List<Lesson> days = new ArrayList<>();
            while (rs.next()){
                days.add(new Lesson(id,rs.getString(1)));
            }
            res=days.get(0);
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
    public void addLesson(String lesson){
        Connection con = pool.connectionCheck();
        if (con ==null) return;
        PreparedStatement st = null;
        try {
            st = con.prepareStatement("insert into Lesson " +
                    "(name)" +
                    " values(?)");
            st.setString(1,lesson);
            st.executeUpdate();
            logger.info("Add lesson "+lesson+" to database.");
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
    public void setLesson(Lesson lesson){
        Connection con = pool.connectionCheck();
        if (con ==null) return;
        PreparedStatement st = null;
        try {
            st = con.prepareStatement("update Lesson " +
                    "set name=?" +
                    " where id=?");
            st.setString(1,lesson.getName());
            st.setInt(2,lesson.getId());
            st.executeUpdate();
            logger.info("Change lesson "+lesson.getId()+" in database.");
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
    public void removeLesson(int id){
        Connection con = pool.connectionCheck();
        if (con ==null) return;
        PreparedStatement st = null;
        try {
            st = con.prepareStatement("delete from Lesson " +
                    "where id=?");
            st.setInt(1,id);
            st.executeUpdate();
            logger.info("Remove lesson "+ id +" from database.");
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
