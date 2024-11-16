package facade;

import beans.Customer;
import dao.CompaniesDAO;
import dao.CouponsDAO;
import dao.CustomersDAO;

import java.sql.SQLException;

public class AdminFacade extends ClientFacade{


    public AdminFacade(CompaniesDAO companiesDao, CouponsDAO couponsDAO, CustomersDAO customersDAO) throws SQLException {
        super(companiesDao, couponsDAO, customersDAO);
    }

    @Override
    public boolean login(String email, String password) {
        // Logic for company login
        // e.g., validate company credentials against CompaniesDAO
        // Return true if valid, false otherwise
        return false;
    };

}
