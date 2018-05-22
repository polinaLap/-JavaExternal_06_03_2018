package javacourses.pool;

import java.util.*;
import java.sql.Connection;

public class ConnectionPooling extends CanGetConnection {
    private static ConnectionPooling instance;
    public static synchronized ConnectionPooling getInstance() {
        if (instance == null) {
            instance = new ConnectionPooling();
        }
        return instance;
    }
    int initialConnections = 5;
        Vector connectionsAvailable = new Vector();
        Vector connectionsUsed = new Vector();
    public ConnectionPooling() {
        registerDriver();
        for (int count = 0; count < initialConnections; count++)
            connectionsAvailable.addElement(getConnection());
    }

    public synchronized Connection connectionCheck(){
            Connection newConnection = null;
            if (connectionsAvailable.size() == 0) {
                // creating a new Connection
                newConnection = getConnection();
                // adding Connection to used list
                connectionsUsed.addElement(newConnection);
            } else {
                newConnection = (Connection) connectionsAvailable.lastElement();

                connectionsAvailable.removeElement(newConnection);

                connectionsUsed.addElement(newConnection);
            }
            return newConnection;
        }

        public int availableCount() {
            return connectionsAvailable.size();
        }



}
