package dao;

import beans.Company;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CompaniesDAO {
    boolean isCompanyExist(String email, String password) throws SQLException, InterruptedException;
    void addCompany(Company company) throws SQLException, InterruptedException;
    void updateCompany(Company company);
    void deleteCompany(int companyID);
    ArrayList<Company> getAllCompanies();
    Company getOneCompany(int companyID);
}
