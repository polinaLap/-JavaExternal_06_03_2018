package javacourses.pool;

import javacourses.dao.LessonDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class CanGetConnection {

    final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(LessonDAO.class);
    public void registerDriver(){
        try{Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();}
        catch(ClassNotFoundException e){
            logger.error(e.getMessage());
        }
        catch (IllegalAccessException e){
            logger.error(e.getMessage());
        }
        catch (InstantiationException e){
            logger.error(e.getMessage());
        }
    }

    public Connection getConnection() {

        String connectionString = ConnectionString.get();
        Connection con = null;
        try {
            con = DriverManager.getConnection(connectionString);
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
        return con;
    }
}
