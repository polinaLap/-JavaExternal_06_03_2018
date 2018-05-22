package javacourses.pool;

public class ConnectionString {
    private static String instanceName = " POLLY//SQLEXPRESS ";
    private static String databaseName = "LessonsShedule";
    private static String userName = "coursesJava";
    private static String pass = "lapanya17";
    private static String connectionUrl = "jdbc:sqlserver://127.0.0.1:63852;databaseName=%2$s;user=%3$s;password=%4$s;";
    private static String connectionString = String.format(connectionUrl, instanceName, databaseName, userName, pass);
    public static String get()  {
        return connectionString;
    }
}
