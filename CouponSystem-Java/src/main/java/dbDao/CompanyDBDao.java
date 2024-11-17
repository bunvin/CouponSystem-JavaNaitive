package dbDao;

import beans.Company;
import beans.Coupon;
import dao.CompaniesDAO;
import daoQuery.CompanyDaoQuery;
import db.DBManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CompanyDBDao implements CompaniesDAO {

    @Override
    public void addCompany(Company company) throws SQLException, InterruptedException {
        Map<Integer, Object> map = Map.of(
                1, company.getName(),
                2, company.getEmail(),
                3, company.getPassword()
        );
        DBManager.createQuery(CompanyDaoQuery.ADD_COMPANY, map, false);
        DBManager.closeConnection();
    }

    @Override
    public void deleteCompany(int companyID) throws SQLException, InterruptedException {
        Map<Integer, Object> map = Map.of(
                1, companyID
        );
        DBManager.createQuery(CompanyDaoQuery.DELETE_COMPANY, map, false);
        DBManager.closeConnection();
    }

    @Override
    public void updateCompany(Company company, int id) throws SQLException {
        Map<Integer, Object> map = Map.of(
                1, company.getName(),
                2, company.getEmail(),
                3, company.getPassword(),
                4, id
        );
        DBManager.createQuery(CompanyDaoQuery.UPDATE_COMPANY, map, false);
        DBManager.closeConnection();
    }

    @Override
    public Company getCompanyByID(Integer companyID) throws SQLException {
        Map<Integer, Object> map = Map.of(
                1, companyID
        );
        ResultSet resultSet = DBManager.createQuery(CompanyDaoQuery.GET_ONE_COMPANY_BY_ID, map, true);
        Company company = null;
        if (resultSet.next()) {
            company = getCompany(resultSet);
        }
        DBManager.closeConnection();
        return company;
    }

    @Override
    public List<Company> getAllCompanies() throws SQLException {
        ResultSet resultSet = DBManager.createQuery(CompanyDaoQuery.GET_ALL_COMPANIES, null, true);
        List<Company> companies = new ArrayList<>();
        while(resultSet.next()){
            companies.add(getCompany(resultSet));
        }
        return companies;
    }

    @Override
    public boolean isCompanyExist(String email, String password) throws SQLException, InterruptedException {
        Map<Integer, Object> map = Map.of(
                1, email,
                2, password
        );
        ResultSet resultSet = DBManager.createQuery(CompanyDaoQuery.IS_COMPANY_EXIST, map, true);
        if(resultSet.next()){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Company getCompany(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String email = resultSet.getString("email");
        String password = resultSet.getString("password");
            return Company.builder()
                    .id(id)
                    .name(name)
                    .email(email)
                    .password(password);
        }

    @Override
    public List<Coupon> getCompanyCoupons(int id) throws SQLException {
        Map<Integer, Object> map = Map.of(
                1, id
        );
        ResultSet resultSet = DBManager.createQuery(CompanyDaoQuery.GET_COMPANY_COUPONS_BY_ID, map, true);
        ArrayList<Coupon> coupons = new ArrayList<>();
        CouponDBDAO couponDBDAO = new CouponDBDAO();
        while(resultSet.next()){
           coupons.add(couponDBDAO.getCoupon(resultSet));
        }
        CompanyDBDao companyDBDao = new CompanyDBDao();
        Company company = companyDBDao.getCompanyByID(id);
        company.setCoupons(coupons);

        return coupons;
    }

    @Override
    public boolean isCompanyNameAndPasswordExist(String name, String email) throws SQLException, InterruptedException {
        Map<Integer, Object> map = Map.of(
                1, name,
                2, email
        );
        ResultSet resultSet = DBManager.createQuery(CompanyDaoQuery.IS_COMPANY_NAME_AND_PASSWORD_EXIST, map, true);
        if(resultSet.next()){
            return true;
        } else {
            return false;
        }
    }


}


