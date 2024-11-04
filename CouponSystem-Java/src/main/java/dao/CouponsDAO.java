package dao;

import beans.Coupon;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface CouponsDAO {
    void addCoupon(Coupon coupon) throws SQLException;
    void deleteCoupon(int couponID) throws SQLException;
    void updateCoupon(Coupon coupon, int id) throws SQLException;
    List<Coupon> getAllCoupons() throws SQLException;
    Coupon getCoupon(ResultSet resultSet) throws SQLException;
    Coupon getCouponByID(int couponID) throws SQLException;
    void addCouponPurchase(int customerID, int couponID) throws SQLException;
    void deleteCouponPurchase(int customerID, int couponID) throws SQLException;
}
