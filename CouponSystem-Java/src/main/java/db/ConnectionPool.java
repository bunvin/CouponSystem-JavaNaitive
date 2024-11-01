package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ConnectionPool {
    private final static ConnectionPool connectionPool;

    static {
        try {
            connectionPool = new ConnectionPool();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Connection> connectionList = new ArrayList<>();

    public static final String USER_NAME = DBManager.USER_NAME;
    public static final String PASSWORD = DBManager.PASSWORD;
    public static final String URL = DBManager.URL;

    private ConnectionPool() throws SQLException {
        for (int i = 0; i < 10; i++) {
            connectionList.add(DriverManager.getConnection(URL, USER_NAME, PASSWORD));
        }
    }

    public static ConnectionPool getConnectionPool() {
        return connectionPool;
    }

    public List<Connection> getConnectionList() {
        return connectionList;
    }

    public synchronized Connection getConnection() throws InterruptedException {
        while (this.connectionList.isEmpty()) {
            wait();
        }
        return this.connectionList.removeLast();
    }

    public synchronized void releaseConnection(Connection connection) {
        this.connectionList.add(connection);
        notify();
    }
}
