package dao;

import beans.Coupon;
import beans.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface CustomersDAO {
    void addCustomer(Customer customer) throws SQLException;
    void deleteCustomer(int customerID) throws SQLException;
    void updateCustomer(Customer customer, int id) throws SQLException;
    List<Customer> getAllCustomers() throws SQLException;
    Customer getCustomerByID(int customerID) throws SQLException;
    boolean isCustomerExist(String email, String password) throws SQLException;
    Customer getCustomer(ResultSet resultSet) throws SQLException;
    List<Coupon> getCustomerCoupons(int customerId);
}
