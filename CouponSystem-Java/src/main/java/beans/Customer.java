package beans;

import dbDao.CustomerDBDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<Coupon> coupons;

    CustomerDBDAO customerDBDAO = new CustomerDBDAO();

    //builder

    public Customer() {}

    public static Customer builder(){
        return new Customer();
    }

    public Customer id(int id){
        this.id = id;
        return this;
    }

    public Customer firstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public Customer lastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public Customer email(String email){
        this.email = email;
        return this;
    }

    public Customer password(String password){
        this.password = password;
        return this;
    }

    //getter setter toString

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Coupon> getCoupons() throws SQLException {
        List<Coupon> updatedCoupons = this.customerDBDAO.getCustomerCoupons(this.id);
        if (this.coupons == null || this.coupons.size() < updatedCoupons.size() ){
            this.coupons = updatedCoupons;
        }
        return this.coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }

    @Override
    public String toString() {
        return STR."""
Customer{id=\{id}, firstName='\{firstName}', lastName='\{lastName}', email='\{email}', password='\{password}', coupons=\{coupons}}
""";

    }

}
