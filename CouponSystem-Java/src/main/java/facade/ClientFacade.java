package facade;

import dao.CompaniesDAO;
import dao.CouponsDAO;
import dao.CustomersDAO;
import dbDao.CompanyDBDao;
import dbDao.CouponDBDAO;
import dbDao.CustomerDBDAO;

import java.sql.SQLException;

public abstract class ClientFacade {
    private static final CompaniesDAO companiesDAO = new CompanyDBDao();
    private static final CustomersDAO customersDAO = new CustomerDBDAO();
    private static final CouponsDAO couponsDAO = new CouponDBDAO();

    public ClientFacade() {
    }

    public boolean login(String email, String password) throws Exception {
        return false;
    }

    //getters
    public CompaniesDAO getCompaniesDAO() {
        return companiesDAO;
    }

    public CustomersDAO getCustomersDAO() {
        return customersDAO;
    }

    public CouponsDAO getCouponsDAO() {
        return couponsDAO;
    }
}
