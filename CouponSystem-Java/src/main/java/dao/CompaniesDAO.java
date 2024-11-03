package dao;

import beans.Company;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CompaniesDAO {
    void addCompany(Company company) throws SQLException, InterruptedException;
    void deleteCompany(int companyID) throws SQLException, InterruptedException;
    void updateCompany(Company company, int id) throws SQLException;
    Company getCompanyByID(Integer companyID) throws SQLException;
    List<Company> getAllCompanies() throws SQLException;
    boolean isCompanyExist(String email, String password) throws SQLException, InterruptedException;


    }
