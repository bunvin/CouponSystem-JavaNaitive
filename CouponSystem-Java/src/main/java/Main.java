import Testing.Test;
import db.DBManager;
import dbDao.CompanyDBDao;
import dbDao.CouponDBDAO;
import dbDao.CouponExpirationDailyJob;
import dbDao.CustomerDBDAO;

public class Main {
    public static void main(String[] args) throws Exception {
        DBManager.dropAllTable();
        DBManager.init();
        Test.testAll();

//DB DAO TESTING
//        CompanyDBDao companyDBDao = new CompanyDBDao();
//        CustomerDBDAO customerDBDAO = new CustomerDBDAO();
//        CouponDBDAO couponDBDAO = new CouponDBDAO();
//
//        //Coupon Job testing
//        CouponExpirationDailyJob.run();
//        CouponExpirationDailyJob.stop();




//        //TESTING login
//        Customer customer = customerDBDAO.getCustomerByID(6);
//        Company company = companyDBDao.getCompanyByID(4);
//
//        LoginManager.getInstance().login(DBManager.ADMIN_EMAIL,DBManager.ADMIN_PASSWORD, ClientType.ADMIN);
//
//        LoginManager.getInstance().login(DBManager.ADMIN_EMAIL,"12132", ClientType.ADMIN);
//        System.out.println("##");
//        LoginManager.getInstance().login(company.getEmail(),company.getPassword(),ClientType.COMPANY);
//        LoginManager.getInstance().login("fakeemail@email.com",company.getPassword(),ClientType.COMPANY);
//        System.out.println("##");
//        LoginManager.getInstance().login(customer.getEmail(), customer.getPassword(), ClientType.CUSTOMER);
//        LoginManager.getInstance().login("customer.getEmail()", customer.getPassword(), ClientType.CUSTOMER);


        //TESTING CUSTOMER FACADE
//
//        CustomerFacade customerFacade = new CustomerFacade();
//        Customer customer = customerDBDAO.getCustomerByID(6);
//        String password = customer.getPassword();//"1234";
//        String email = customer.getEmail();
//        System.out.println(
//        customerFacade.login(email,password)
//        );
//        customerFacade.getCustomerDetails();
//
//        System.out.println(customerFacade.getCustomerCouponsByCategory(1));
//        System.out.println("#######");
////        customerFacade.purchaseCoupon(1); //(amount = 0) //date expired
//
////        List<Coupon> couponsMax = customerFacade.getCustomerCouponsByMaxPrice(30);
////        for(Coupon coupon : couponsMax){
////            System.out.println("couponId: " + coupon.getId()+ " price: " + coupon.getPrice());
////        }
//
//        System.out.println("#######");


//TESTING CompanyFacade
//        CompanyFacade companyFace = new CompanyFacade();
//        companyFace.login("Sto@email.com","1212");
//        System.out.println("Company Id: "+ (companyFace.getCompanyId()));
//
////        Coupon coupon = Coupon.builder()
////                .companyID(companyFace.getCompanyId())
////                .title("coupon")
////                .amount(5)
////                .category(Category.Food);
////        System.out.println(coupon);
//
////        couponDBDAO.addCouponPurchase(3,10);
////        companyFace.deleteCoupon(11);
//
//companyFace.getCompanyDetails();
//
//List<Coupon> catCoupons = companyFace.getCompanyCategoryCoupons(2);
//        System.out.println(catCoupons.size());
//        for(Coupon coupon : catCoupons){
//            System.out.println(coupon);
//        }
//        System.out.println("####");
//        List<Coupon> catCoupons2 = companyFace.getCompanyCategoryCoupons(1);
//        for(Coupon coupon : catCoupons2){
//            System.out.println(coupon);
//        }

//Testing AdminFacade
//        AdminFacade adminFace = new AdminFacade();
//        //login
//        System.out.println(adminFace.login("admin@admin.com","admin"));
//        System.out.println(adminFace.login("admin@admin.com","admi"));

//        //add company
//        Company company = Company.builder()
//                .name("Storash") //same name
//                .email("newnew@email") //new email
//                .password("1234!"); //same password
//
//       // adminFace.addCompany(company);
//        company.setEmail("newnewEmail@gmail.com");
//        company.setName("newnew Name");
//        adminFace.addCompany(company);

        //update company
//        Company company = Company.builder()
//                //.id(1)//new id >> exception
//                .name("Storashi") //
//                .email("real@email.com") //new email
//                .password("1234!"); //same password
//        Company company = companyDBDao.getCompanyByID(7);
//        company.setEmail("true@email.com");
//        company.setPassword("1212");
//        adminFace.updateCompany(company,7);

        //Delete company
//        System.out.println(companyDBDao.getCompanyByID(7));
//        adminFace.deleteCompany(7);
//        System.out.println(companyDBDao.getCompanyByID(7));
//        adminFace.deleteCompany(8);

        //get all companies
//        List<Company> companies = adminFace.getAllCompanies();
//        for (Company company : companies){
//            System.out.println(company);
//        }
//get company by ID
//        System.out.println(adminFace.getCompanyById(5));

//add new client
//        Customer customer = Customer.builder()
//                .firstName("first")
//                .lastName("last")
//                .email("private@email.com")
//                .password("12123"); //existing exception
//        //adminFace.addCustomer(customer);
//        customer.setEmail("new@email.com");
//        adminFace.addCustomer(customer);

//update client


//delete client
        //getCustomer //getCoupons
        //delete purchase
        //delete customer
       // adminFace.deleteCustomer(1);

//        adminFace.deleteCustomer(4);
//        List<Coupon> coupons = customerDBDAO.getCustomerCoupons(1);
//        for(Coupon coupon : coupons){
//            System.out.println(coupon);
//        }

//get all clients
//        List<Customer> customers = adminFace.getAllCustomers();
//        for (Customer client : customers){
//            System.out.println(client);
//        }
//get client by Id
//        System.out.println(adminFace.getCustomerByID(3));



//        //CUSTUMERDBDAO
//        Customer customer = Customer.builder()
//                .firstName("Jane")
//                .lastName("Doe")
//                .email("private@email.com")
//                .password("123");

//        customerDBDAO.addCustomer(customer);
//        customerDBDAO.addCustomer(customer);
//        System.out.println(customerDBDAO.getAllCustomers());
//        customerDBDAO.deleteCustomer(2);
//        System.out.println(customerDBDAO.getAllCustomers());
//        customerDBDAO.addCustomer(customer);
//        customer.setFirstName("Joe");
//        customerDBDAO.updateCustomer(customer,3);
//        System.out.println(customerDBDAO.getAllCustomers());
//        System.out.println(customerDBDAO.getCustomerByID(1));
//        System.out.println(customerDBDAO.isCustomerExist("private@email.com", "123"));
//        System.out.println(customerDBDAO.isCustomerExist("private@email.com", "12"));

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
