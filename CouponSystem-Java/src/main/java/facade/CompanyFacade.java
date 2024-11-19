package facade;

import dao.CompaniesDAO;
import dao.CouponsDAO;
import dao.CustomersDAO;

public class CompanyFacade extends ClientFacade{
    public CompanyFacade() {
        super();
    }

    @Override
    public boolean login(String email, String password) {
        // Logic for company login
        // e.g., validate company credentials against CompaniesDAO
        // Return true if valid, false otherwise
        return false;
    };
}
