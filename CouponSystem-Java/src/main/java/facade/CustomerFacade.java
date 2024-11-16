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


    public CustomerFacade(CompaniesDAO companiesDao, CouponsDAO couponsDAO, CustomersDAO customersDAO) {
        super(companiesDao, couponsDAO, customersDAO);
    }

    public void addCustomer(Customer customer) throws SQLException {
        //add validation here
        ClientFacade.customersDAO.addCustomer(customer);
    }

    @Override
    public boolean login(String email, String password) {
        // Logic for company login
        // e.g., validate company credentials against CompaniesDAO
        // Return true if valid, false otherwise
        return false;
    };

}
