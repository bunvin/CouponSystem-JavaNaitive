import beans.Company;
import db.ConnectionPool;
import db.DBManager;
import dbDao.CompanyDBDao;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException, InterruptedException {
//DB DAO TESTING
        CompanyDBDao companyDBDao = new CompanyDBDao();

        //
        //COMPANYDBDAO
//        Company company = new Company();
//        company.setName("Storash");
//        company.setEmail("Storash@gmail.com");
//        company.setPassword("1234!");

       // DBManager.dropAllTable();
       // DBManager.init();
        //companyDBDao.addCompany(company);
        //companyDBDao.addCompany(company);
        //companyDBDao.addCompany(company);
//        System.out.println(companyDBDao.getAllCompanies());
//        System.out.println(companyDBDao.isCompanyExist("Store@email.com", "1212"));
//        System.out.println(companyDBDao.isCompanyExist("Store@email.om", "1212"));



//      //ADD
//        System.out.println(companyDBDao.getOneCompany(2));
//       // companyDBDao.addCompany(Company.builder().name("newStore").password("121").email("12@email.com"));
//        System.out.println(companyDBDao.getOneCompany(5));
//        //DELETE
//        companyDBDao.deleteCompany(5);
//        System.out.println(companyDBDao.getOneCompany(5));
//        //UPDATE
//        System.out.println(companyDBDao.getOneCompany(4));
//        companyDBDao.updateCompany(company,4);
//        System.out.println(companyDBDao.getOneCompany(4));

//CONNECTION TESTING
        //creating and removing- 5 tables
//        DBManager.dropAllTable();
//        DBManager.init();



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
