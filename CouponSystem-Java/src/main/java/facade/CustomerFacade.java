package facade;

import beans.Customer;
import dao.CompaniesDAO;
import dao.CouponsDAO;
import dao.CustomersDAO;
import dbDao.CompanyDBDao;
import dbDao.CouponDBDAO;
import dbDao.CustomerDBDAO;

import java.sql.SQLException;

public class CustomerFacade extends ClientFacade{
//    private final CompaniesDAO companiesDAO;
//    private final CustomersDAO customersDAO;
//    private final CouponsDAO couponsDAODAO;

    public CustomerFacade() {
        super();
    }


    public void addCustomer(Customer customer) throws SQLException {
        //add validation here
//        getCustomersDAO().addCustomer();

        ;
    }

    @Override
    public boolean login(String email, String password) {
        // Logic for company login
        // e.g., validate company credentials against CompaniesDAO
        // Return true if valid, false otherwise
        return false;
    };

}
