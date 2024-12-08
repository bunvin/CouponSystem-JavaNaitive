package Testing;

import beans.Company;
import beans.Coupon;
import beans.Customer;
import db.DBManager;
import dbDao.CouponExpirationDailyJob;
import facade.AdminFacade;
import facade.ClientFacade;
import facade.CompanyFacade;
import facade.CustomerFacade;
import login.ClientType;
import login.LoginManager;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Test {
    public static void testAll() throws Exception {

//        CouponExpirationDailyJob.run();
        System.out.println("########## ADMIN FACADE ##########");

        AdminFacade adminFacade;
        ClientFacade admin = LoginManager.getInstance().login(DBManager.ADMIN_EMAIL,DBManager.ADMIN_PASSWORD, ClientType.ADMIN);

        //Maybe check if object is actually AdminFacade? >> if(admin instanceof AdminFacade) {
        //Casting to have the full adminFacade
        adminFacade = (AdminFacade) admin;

        System.out.println("Admin adding 5 new companies");
        System.out.println("    used: addCompany, getCompanyByEmail");
        //create 5 random companies
        List<Company> newCompanies = FactoryUtils.randomCompanies(5);
        for(Company company : newCompanies){
            adminFacade.addCompany(company);
            company = adminFacade.getCompanyByEmail(company.getEmail());
            System.out.print("new company added >> " + company);
        }
        System.out.println("##########");
        System.out.println("Admin update 2 companies (id = 1,2)");
        System.out.println("    used: updateCompany, getCompanyById, getAllCompanies");

        //create 2 random companies
        //update 2 companies
        List<Company> newCompaniesForUpdateTest = FactoryUtils.randomCompanies(2);
        //update names like in DB
        for(int i = 1 ; i <3 ; i++){
            Company company = newCompaniesForUpdateTest.get(i-1);
            Company companyDb = adminFacade.getCompanyById(i);
            //keep db name
            company.setName(companyDb.getName());
            //update
            adminFacade.updateCompany(company,i);
        }

        //print all companies
        //getAllCompanies
        List<Company> allCompanies = adminFacade.getAllCompanies();
        for(Company company : allCompanies){
            System.out.print(company);
        }

        System.out.println("##########");
        System.out.println("Admin delete company");
        System.out.println("    used: deleteCompany");

        System.out.println("Companies in db: "+allCompanies.size());
        adminFacade.deleteCompany(2);
        System.out.println("Deleted, id = 2");
        allCompanies = adminFacade.getAllCompanies();
        System.out.println("Companies in db: "+allCompanies.size());

        for(Company company : allCompanies){
            System.out.print(company);
        }
        System.out.println("##########");
        System.out.println("Admin adding 10 new customers");
        System.out.println("    used: addCustomer, getCustomerByEmail");
        List<Customer> newCustomers = FactoryUtils.randomCustomers(10);
        for(Customer customer : newCustomers){
            adminFacade.addCustomer(customer);
            System.out.print(adminFacade.getCustomerByEmail(customer.getEmail()));
        }
        System.out.println("##########");
        System.out.println("Admin update 2 customers (id = 1,2)");
        System.out.println("    used: updateCustomer, getCustomerById, getAllCustomers");
        List<Customer> newCustomersForUpdate = FactoryUtils.randomCustomers(2);
        for(int i = 1; i < 3; i++){
            Customer customer = newCustomersForUpdate.get(i-1);
            Customer customerDb = adminFacade.getCustomerByID(i);
            //keep db email
            customer.setEmail(customerDb.getEmail());
            //update
            adminFacade.updateCustomer(customer,i);
        }

        List<Customer> allCustomers = adminFacade.getAllCustomers();
        for(Customer customer: allCustomers){
            System.out.print(customer);
        }
        System.out.println("##########");
        System.out.println("Admin delete customer");
        System.out.println("    used: deleteCustomer");
        System.out.println("Customers in db: "+allCustomers.size());
        adminFacade.deleteCustomer(2);
        System.out.println("Deleted, id = 2");
        allCustomers = adminFacade.getAllCustomers();
        System.out.println("Customers in db: "+allCustomers.size());

        for(Customer customer: allCustomers){
            System.out.print(customer);
        }


        System.out.println("");
        System.out.println("########## COMPANY FACADE ##########");

        CompanyFacade companyFacade;
        Company company = adminFacade.getCompanyById(1);

        ClientFacade companyLogin = LoginManager.getInstance().login(company.getEmail(),company.getPassword(), ClientType.COMPANY);

        //Casting ClientFacade into CompanyFacade
        companyFacade = (CompanyFacade) companyLogin;

//        companyFacade.getCompanyDetails();

        System.out.println("CompanyId = 1 added 3 new coupons");
        System.out.println("    used: addCoupon, getAllCompanyCoupons");

        //addCoupon - exception if title exist in company coupons
        List<Coupon> newCouponsCompanyId1 = FactoryUtils.randomCoupons(3, company.getId());
        for(Coupon coupon : newCouponsCompanyId1){
            companyFacade.addCoupon(coupon);
        }

        List<Coupon> allCompanyCoupons = companyFacade.getCompanyCoupons();
        for(Coupon coupon: allCompanyCoupons){
            System.out.println(coupon);
        }

        System.out.println("##########");
        System.out.println("updated couponId = 3");
        System.out.println("    used: updateCoupon, getCouponById");

        //updateCoupon
        Coupon updatedCoupon = companyFacade.getCouponById(3);
        updatedCoupon.setTitle("Updated title");
        companyFacade.updateCoupon(updatedCoupon, 3);

        allCompanyCoupons = companyFacade.getCompanyCoupons();
        for(Coupon coupon: allCompanyCoupons){
            System.out.println(coupon);
        }

        //deleteCoupon
        System.out.println("##########");
        System.out.println("deleted couponId = 3");
        System.out.println("    used: deleteCouponById");
        System.out.println("Company Coupons: "+allCompanyCoupons.size());
        companyFacade.deleteCoupon(3);
        allCompanyCoupons = companyFacade.getCompanyCoupons();
        System.out.println("Company Coupons: "+allCompanyCoupons.size());
        for(Coupon coupon: allCompanyCoupons){
            System.out.println(coupon);
        }

        companyFacade.getCompanyDetails();

        System.out.println("Coupons count by category");
        System.out.println("    used: getCompanyCategoryCoupons");
        System.out.println("Food: "+companyFacade.getCompanyCategoryCoupons(1).size());
        System.out.println("Electricity: "+companyFacade.getCompanyCategoryCoupons(2).size());
        System.out.println("Restaurant: "+companyFacade.getCompanyCategoryCoupons(3).size());
        System.out.println("Vacation: "+companyFacade.getCompanyCategoryCoupons(4).size());

        System.out.println("##########");
        System.out.println("All coupons priced up to 20$ "); //in factoryUtils price 10-30
        System.out.println("    used: getCompanyCouponsMaxPrice");
        List<Coupon> upTo20 = companyFacade.getCompanyCouponsMaxPrice(20);
        for(Coupon coupon: upTo20){
            System.out.println(coupon);
        }

        System.out.println("########## CUSTOMER FACADE ##########");

        CustomerFacade customerFacade;
        Customer customerDb =
                adminFacade.getCustomerByID(allCustomers.get(ThreadLocalRandom.current()
                        .nextInt(allCustomers.size()))
                        .getId());

        ClientFacade customer = LoginManager.getInstance().login(customerDb.getEmail(), customerDb.getPassword(),
                ClientType.CUSTOMER);

        //casting into CustomerFacade from ClientFacade
        customerFacade = (CustomerFacade) customer;

        System.out.println("Customer purchase 5 coupons");
        System.out.println("    used: purchaseCoupon, getCustomerCoupons");

        //create more coupons
        List<Coupon> newCouponsCompanyId3 = FactoryUtils.randomCoupons(3, 3);
        for(Coupon coupon : newCouponsCompanyId3){
            companyFacade.addCoupon(coupon);}
        List<Coupon> newCouponsCompanyId4 = FactoryUtils.randomCoupons(3, 4);
        for(Coupon coupon : newCouponsCompanyId4){
            companyFacade.addCoupon(coupon);}
        //create expired coupons
        List<Coupon> newCouponsCompanyId5 = FactoryUtils.randomCoupons(3, 5);
        for(Coupon coupon : newCouponsCompanyId5){
            companyFacade.addCoupon(coupon);
        }

        //random pick 5 coupons out of all coupons
        //need Admin access
        List<Coupon> allCoupons = adminFacade.getCouponsDAO().getAllCoupons();
        List<Coupon> pickedCoupons = new ArrayList<>();
        boolean wasPurchased = false;



        while(pickedCoupons.size() < 5){
            Coupon randomCoupon = allCoupons.get(ThreadLocalRandom.current().nextInt(allCoupons.size()));
            //check if coupon was picked
            for( Coupon coupon : pickedCoupons){
                if (randomCoupon.getId() == coupon.getId()){
                    wasPurchased = true;
                    break;
                }
            }
            if (wasPurchased){
                wasPurchased = false;
            }else{
                customerFacade.purchaseCoupon(randomCoupon.getId());
                pickedCoupons.add(randomCoupon);
            }
        }

        //show
        List<Coupon> allCustomerCoupons = customerFacade.getCustomerCoupons();
        for(Coupon coupon : allCustomerCoupons){
            System.out.println(coupon);
        }

        System.out.println("##########");
        System.out.println("Customer coupons count by category");
        System.out.println("    used: getCustomerCouponsByCategory");
        System.out.println("Food: "+customerFacade.getCustomerCouponsByCategory(1).size());
        System.out.println("Electricity: "+customerFacade.getCustomerCouponsByCategory(2).size());
        System.out.println("Restaurant: "+customerFacade.getCustomerCouponsByCategory(3).size());
        System.out.println("Vacation: "+customerFacade.getCustomerCouponsByCategory(4).size());

        System.out.println("##########");
        System.out.println("Customer coupons up to 20$");
        System.out.println("    used: getCustomerCouponsByMaxPrice"); //not working
        List<Coupon> upTo20USD = customerFacade.getCustomerCouponsByMaxPrice(20);
        for(Coupon coupon: upTo20USD){
            System.out.println(coupon);
        }

        customerFacade.getCustomerDetails();
























//        CouponExpirationDailyJob.stop();
//        DBManager.closeConnection();

    }
};
