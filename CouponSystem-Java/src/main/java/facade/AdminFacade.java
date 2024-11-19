package facade;

import beans.Company;
import beans.Coupon;
import beans.Customer;
import db.DBManager;

import java.sql.SQLException;
import java.util.List;
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

    public void addCompany(Company company) throws Exception {
        //if company name and email not in database?
        if(getCompaniesDAO().isCompanyNameOREmailExist(company.getName(), company.getEmail())){
            throw new Exception("FAILED: Company's name or email already exist");
        }else{
            getCompaniesDAO().addCompany(company);
        }
    }

    public void updateCompany(Company company, int companyId) throws Exception {
        //if name and id are equal update
        Company dbCompany = getCompaniesDAO().getCompanyByID(companyId);
        if (company.getName().equals(dbCompany.getName())
        && company.getId() == dbCompany.getId()
        || company.getName().equals(dbCompany.getName())
                && company.getId() == 0){
            getCompaniesDAO().updateCompany(company,companyId);
        }else{
            throw new Exception("FAILED: Companies name or id are un-updatable");
        }
    }

    public void deleteCompany(int companyId) throws Exception {
        // only if Company exist
        // get all coupons
        // delete all purchases and coupons
        // delete company
        Company company = getCompaniesDAO().getCompanyByID(companyId);
        if (company != null){
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


    public List<Company> getAllCompanies() throws SQLException {
        return getCompaniesDAO().getAllCompanies();
    }

    public Company getCompanyById(int id) throws SQLException {
        return getCompaniesDAO().getCompanyByID(id);
    }

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

    public void deleteCustomer(int customerId) throws Exception {
        // get
        Customer customer = getCustomersDAO().getCustomerByID(customerId);
        List<Coupon> coupons = customer.getCoupons();
        //delete
        getCouponsDAO().deleteCouponPurchaseByCustomerId(customerId);
        getCustomersDAO().deleteCustomer(customerId);
    }

    public List<Customer> getAllCustomers() throws SQLException {
        return getCustomersDAO().getAllCustomers();
    }

    public Customer getCustomerByID(int customerId) throws SQLException {
        return getCustomersDAO().getCustomerByID(customerId);
    }


}
