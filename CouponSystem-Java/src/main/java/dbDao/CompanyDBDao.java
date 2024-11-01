package dbDao;

import beans.Company;
import dao.CompaniesDAO;
import daoQuery.CompanyDaoQuery;
import db.DBManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class CompanyDBDao implements CompaniesDAO {
    @Override
    public boolean isCompanyExist(String email, String password) throws SQLException, InterruptedException {
        Map<Integer, Object> map = Map.of(
                1, email,
                2, password
        );
        ResultSet resultSet = DBManager.createQuery(CompanyDaoQuery.IS_COMPANY_EXIST, map, true);
        return resultSet != null;
    }

    @Override
    public void addCompany(Company company) throws SQLException, InterruptedException {
        Map<Integer, Object> map = Map.of(
                1, company.getName(),
                2, company.getEmail(),
                3, company.getPassword()
        );
        DBManager.createQuery(CompanyDaoQuery.ADD_COMPANY, map, false);
    }

    @Override
    public void updateCompany(Company company) {

    }

    @Override
    public void deleteCompany(int companyID) {

    }

    @Override
    public ArrayList<Company> getAllCompanies() {
        return null;
    }

    @Override
    public Company getOneCompany(int companyID) {
        return null;
    }
}
