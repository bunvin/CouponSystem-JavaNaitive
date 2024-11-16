package facade;

import dao.CompaniesDAO;
import dao.CouponsDAO;
import dao.CustomersDAO;
import dbDao.CompanyDBDao;
import dbDao.CouponDBDAO;
import dbDao.CustomerDBDAO;

abstract class ClientFacade {
    private static final CompaniesDAO companiesDao = new CompanyDBDao();
    static final CustomersDAO customersDAO = new CustomerDBDAO();
    private static final CouponsDAO couponsDAO = new CouponDBDAO();

    public ClientFacade(CompaniesDAO companiesDao, CouponsDAO couponsDAO, CustomersDAO customersDAO) {
    }

    public boolean login(String email, String password) {
        return false;
    }
}
