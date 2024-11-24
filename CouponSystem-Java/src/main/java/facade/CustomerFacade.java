package facade;

import beans.Coupon;
import beans.Customer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerFacade extends ClientFacade {

    int customerId;
    List<Coupon> customerCoupons;

    public CustomerFacade() {
        super();
    }

    @Override
    public boolean login(String email, String password) throws Exception {
        if (getCustomersDAO().isCustomerExist(email, password)) {
            Customer customer = getCustomersDAO().getCustomerByEmail(email);
            this.customerId = customer.getId();
            this.customerCoupons = getCustomerCoupons();

            return true;
        } else {
            System.out.println("FAILED: email or password are incorrect");
            return false;
        }
    }

    public void purchaseCoupon(int couponId) throws Exception {
        Coupon dbCoupon = getCouponsDAO().getCouponByID(couponId);

        Customer customer = getCustomersDAO().getCustomerByID(customerId);
        List<Coupon> coupons = this.customerCoupons;

        if (dbCoupon.getAmount() <= 0) {
            throw new Exception("FAILED: no available coupons to purchase");
        }
        if (dbCoupon.getEndDate().before(new Date())) {
            throw new Exception("FAILED: coupon is expired");
        }
        for (Coupon coupon : coupons) {
            if (coupon.getId() == couponId) {
                throw new Exception("FAILED: coupon already purchased by customer");
            }
        }
        getCouponsDAO().addCouponPurchase(this.customerId, couponId);

    }

    public List<Coupon> getCustomerCoupons() throws SQLException {
        Customer customer = getCustomersDAO().getCustomerByID(this.customerId);
        return customer.getCoupons();
    }

    public List<Coupon> getCustomerCouponsByCategory(int categoryId) throws SQLException {
        List<Coupon> filteredList = new ArrayList<>();
        for (Coupon coupon : this.customerCoupons) {
            if (coupon.getCategory().getCategoryId() == categoryId) {
                filteredList.add(coupon);
            }
        }
        return filteredList;
    }

    public List<Coupon> getCustomerCouponsByMaxPrice(double maxPrice) throws SQLException {
        List<Coupon> filteredList = new ArrayList<>();
        for (Coupon coupon : this.customerCoupons) {
            if (coupon.getPrice() <= maxPrice) {
                filteredList.add(coupon);
            }
        }
        return filteredList;
    }

    public void getCustomerDetails() throws Exception {
        Customer customer = getCustomersDAO().getCustomerByID(this.customerId);

        if(customer == null){
            throw new Exception("FAILED: no customer is logged-in");
        }


        System.out.println("#############");
        System.out.println("CustomerId: "+customer.getId());
        System.out.println("First Name: "+ customer.getFirstName());
        System.out.println("Last Name: "+customer.getLastName());
        System.out.println("Customer Email: "+customer.getEmail());
        System.out.println("Purchase coupons: ");
        for(Coupon coupon : this.customerCoupons){
            System.out.println(coupon);
        }
        System.out.println("#############");
    }


}



