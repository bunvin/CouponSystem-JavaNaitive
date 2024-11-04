package dbDao;

import beans.Company;
import beans.Customer;
import dao.CustomersDAO;
import daoQuery.CompanyDaoQuery;
import daoQuery.CustomerDaoQuery;
import db.DBManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomerDBDAO implements CustomersDAO {

    @Override
    public void addCustomer(Customer customer) throws SQLException {
        Map<Integer, Object> map = Map.of(
                1, customer.getFirstName(),
                2, customer.getLastName(),
                3, customer.getEmail(),
                4, customer.getPassword()
        );
        DBManager.createQuery(CustomerDaoQuery.ADD_CUSTOMER, map, false);
        DBManager.closeConnection();
    }

    @Override
    public void deleteCustomer(int customerID) throws SQLException {
        Map<Integer, Object> map = Map.of(
                1, customerID
        );
        DBManager.createQuery(CustomerDaoQuery.DELETE_CUSTOMER, map, false);
        DBManager.closeConnection();
    }

    @Override
    public void updateCustomer(Customer customer, int id) throws SQLException {
        Map<Integer, Object> map = Map.of(
                1, customer.getFirstName(),
                2, customer.getLastName(),
                3, customer.getEmail(),
                4, customer.getPassword(),
                5, id
        );
        DBManager.createQuery(CustomerDaoQuery.UPDATE_CUSTOMER, map, false);
        DBManager.closeConnection();
    }

    @Override
    public List<Customer> getAllCustomers() throws SQLException {
        ResultSet resultSet = DBManager.createQuery(CustomerDaoQuery.GET_ALL_CUSTOMER, null, true);
        List<Customer> customers = new ArrayList<>();
        while(resultSet.next()){
            customers.add(getCustomer(resultSet));
        }
        return customers;
    }

    @Override
    public Customer getCustomerByID(int customerID) throws SQLException {
        Map<Integer, Object> map = Map.of(
                1, customerID
        );
        ResultSet resultSet = DBManager.createQuery(CustomerDaoQuery.GET_ONE_CUSTOMER_BY_ID, map, true);
        Customer customer = null;
        if (resultSet.next()) {
            customer =  getCustomer(resultSet);
        }
        return customer;
    }

    @Override
    public boolean isCustomerExist(String email, String password) throws SQLException {
        Map<Integer, Object> map = Map.of(
                1, email,
                2, password
        );
        ResultSet resultSet = DBManager.createQuery(CustomerDaoQuery.IS_CUSTOMER_EXIST, map, true);
        if(resultSet.next()){
            return true;
        } else {
            return false;
        }
    }


    @Override
    public Customer getCustomer(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String firstName = resultSet.getString("firstName");
        String lastName = resultSet.getString("lastName");
        String email = resultSet.getString("email");
        String password = resultSet.getString("password");
        return Customer.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password);
    }


}

