package javacourses.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javacourses.pool.ConnectionPooling;
import javacourses.entities.WeekDay;
import org.apache.log4j.Logger;


public class WeekDayDAO {

    final static Logger logger = org.apache.log4j.Logger.getLogger(LessonDAO.class);
    private ConnectionPooling pool;
    public WeekDayDAO(){
        this.pool=ConnectionPooling.getInstance();
    }
    public List<Integer>  getWeekDayIds() {
         List<Integer> weekDayIds = new ArrayList<>();
         Connection con = pool.connectionCheck();
         if (con ==null) return weekDayIds;
         ResultSet rs = null;
         try {
             rs = con.createStatement().executeQuery("select number from WeekDay");
             while (rs.next()){
                 weekDayIds.add(rs.getInt(1));
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
         return weekDayIds;
     }
     public WeekDay getWeekDayById(int id){
         WeekDay res =null;
         Connection con = pool.connectionCheck();
         if (con ==null) return res;
         PreparedStatement st = null;
         ResultSet rs = null;
         try {
             st = con.prepareStatement("select name " +
                     "from WeekDay" +
                     " where number = ?");
             st.setInt(1,id);
             rs = st.executeQuery();
             List<WeekDay> days = new ArrayList<>();
             while (rs.next()){
             days.add(new WeekDay(id,rs.getString(1)));
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

}
