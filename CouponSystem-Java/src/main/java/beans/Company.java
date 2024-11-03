package beans;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private int id;
    private String name;
    private String email;
    private String password;
    private List<Coupon> coupons;

    public Company() {
    }

    public static Company builder()
    {return new Company();
    }
    public Company id (int id){
        this.id = id;
        return this;
    }

    public Company name (String name){
        this.name = name;
        return this;
    }

    public Company email (String email){
        this.email = email;
        return this;
    }

    public Company password (String password){
        this.password = password;
        return this;
    }

    public Company coupons (List<Coupon> coupons){
        this.coupons = coupons;
        return this;
    }

    //getter setter toString

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Coupon> getCoupons() {
        return this.coupons;
    }

    public void setCoupons(ArrayList<Coupon> coupons) {
        this.coupons = coupons;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", coupons=" + coupons +
                '}'+"\n";
    }
}
