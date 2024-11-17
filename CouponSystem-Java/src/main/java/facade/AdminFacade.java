package facade;

import beans.Company;
import beans.Coupon;
import beans.Customer;
import daoQuery.CouponDaoQuery;
import db.DBManager;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

//login
//add company
//update company
//delete company
//get all companies
//get company by ID
//add new client
//update client
//delete client
//get all clients
//get client by Id

public class AdminFacade extends ClientFacade{
    private final String email = DBManager.ADMIN_EMAIL;
    private final String password = DBManager.ADMIN_PASSWORD;

    private boolean isAdmin = false;

    public AdminFacade() throws SQLException {
        super();
    }

    @Override
    public boolean login(String email, String password) {
        if (Objects.equals(email, this.email) && Objects.equals(password, this.password)){
            isAdmin = true;
            return true;
        }
        isAdmin = false;
        return false;
    };
    //NEED TESTING
    public void addCompany(Company company) throws Exception {
        //if company name and email not in database?
        if(!getCompaniesDAO().isCompanyNameAndPasswordExist(
                company.getName(), company.getEmail())
        ){
            throw new Exception("FAILED: Company's name or email already exist");
        }else{
            getCompaniesDAO().addCompany(company);
        }
    }
    //NEED TESTING
    public void updateCompany(int companyId, Company company) throws Exception {
        //if name and id are equal update
        Company dbCompany = getCompaniesDAO().getCompanyByID(companyId);
        if (company.getName().equals(dbCompany.getName())
        && company.getId() == dbCompany.getId()){
            getCompaniesDAO().updateCompany(company,companyId);
        }else{
            throw new Exception("Companies name or id are un-updatable");
        }
    }
//NEED TESTING
    public void deleteCompany(int companyId) throws Exception {
        // only if Company exist
        // get all coupons
        // delete all purchases and coupons
        // delete company

        if(getCompaniesDAO().getCompanyByID(companyId) != null){
            Company company = getCompaniesDAO().getCompanyByID(companyId);
            List<Coupon> coupons = company.getCoupons();

            if (coupons != null){
                for (Coupon coupon:coupons){
                    //if purchased - delete coupon purchase
                    // delete coupons
                    if(getCouponsDAO().isPurchased(coupon.getId())){
                        getCouponsDAO().deleteCouponPurchaseByCouponId(coupon.getId());
                    }
                    getCouponsDAO().deleteCoupon(coupon.getId());
                }
            }

            getCompaniesDAO().deleteCompany(companyId);

        }else{
            throw new Exception("FAILED: Company ID not found");
        }
    }
//NEED TESTING

    public List<Company> getAllCompanies() throws SQLException {
        return getCompaniesDAO().getAllCompanies();
    }
//NEED TESTING

    public Company getCompanyById(int id) throws SQLException {
        return getCompaniesDAO().getCompanyByID(id);
    }
    //NEED TESTING

    public void addCustomer(Customer customer) throws Exception {
        if ( getCustomersDAO().isCustomerEmailExist(customer.getEmail())){
            throw new Exception("FAILED: email is unavailable");
        }
        getCustomersDAO().addCustomer(customer);
    }

    //NEED TESTING
    public void updateCustomer(Customer customer, int customerId) throws Exception {
        if (customerId == customer.getId()){
            getCustomersDAO().updateCustomer(customer,customerId);
        } else {
            throw new Exception("FAILED: customer ID is un-updatable");
        }
    }

    //NEED TESTING
    public void deleteCustomer(int customerId) throws Exception {
        //getCustomer //getCoupons
        //update coupon amount //delete coupons
        //delete customer
        Customer customer = getCustomersDAO().getCustomerByID(customerId);
        List<Coupon> coupons = customer.getCoupons();

        //update coupon amount
        //NOTE:  need to check if coupon exist? always exist?
    //PROBLEM NEED TO THINK ABOUT IT, amount in deleteCouponByCustomerId?
        for (Coupon coupon : coupons){
            Map<Integer, Object> map = Map.of(
                    1, coupon.getId()
            );
            DBManager.createQuery(CouponDaoQuery.UPDATE_AMOUNT_CANCEL, map, false);
        }

        //delete customer purchase
        getCouponsDAO().deleteCouponPurchaseByCustomerId(customerId);
        //delete customer
        getCustomersDAO().deleteCustomer(customerId);
    }

    public List<Customer> customersList() throws SQLException {
        return getCustomersDAO().getAllCustomers();
    }

    public Customer customer(int customerId) throws SQLException {
        return getCustomersDAO().getCustomerByID(customerId);
    }


}
