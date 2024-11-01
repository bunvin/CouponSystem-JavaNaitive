import db.ConnectionPool;
import db.DBManager;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException, InterruptedException {
        //creating and removing- 5 tables

        //DBManager.init();
        ////drop all tables
        //DBManager.dropAllTable();

        //testing the connectionpool

//        for (int i = 0; i < 10; i++) {
//            Thread thread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    Connection connection = null;
//                    try {
//                        connection = ConnectionPool.getConnectionPool().getConnection();
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        Thread.sleep(2000);
//                        ConnectionPool.getConnectionPool().releaseConnection(connection);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    //ConnectionPool.getConnectionPool().releaseConnection(connection);
//                }
//            });
//            thread.start();
//        }


    }
}
