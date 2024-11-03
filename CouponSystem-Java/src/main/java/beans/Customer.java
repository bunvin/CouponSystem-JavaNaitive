package beans;

import java.util.ArrayList;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private ArrayList<Coupon> coupons;

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

    public ArrayList<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(ArrayList<Coupon> coupons) {
        this.coupons = coupons;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", coupons=" + coupons +
                '}'+"\n";

    }
}
