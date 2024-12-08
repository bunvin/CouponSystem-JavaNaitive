package dbDao;

import beans.Category;
import beans.Coupon;

import beans.Customer;
import dao.CouponsDAO;
import daoQuery.CouponDaoQuery;
import db.DBManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class CouponDBDAO  implements CouponsDAO  {

    @Override
    public void addCoupon(Coupon coupon) throws SQLException {
        //MapOf() didn't worked with some null values, changes to map for testing
        Map<Integer, Object> map = new HashMap<>();
        map.put(1, coupon.getCompanyID());
        map.put(2, coupon.getCategory().getCategoryId());
        map.put(3, coupon.getTitle());
        map.put(4, coupon.getDescription());
        map.put(5, coupon.getStartDate());
        map.put(6, coupon.getEndDate());
        map.put(7, coupon.getAmount());
        map.put(8, coupon.getPrice());
        map.put(9, coupon.getImage());
        DBManager.createQuery(CouponDaoQuery.ADD_COUPON, map, false);
        DBManager.closeConnection();
    }

    @Override
    public void deleteCoupon(int couponID) throws SQLException {
        Map<Integer, Object> map = Map.of(
                1, couponID
        );
        DBManager.createQuery(CouponDaoQuery.DELETE_COUPON, map, false);
        DBManager.closeConnection();
    }

    @Override
    public void updateCoupon(Coupon coupon, int id) throws SQLException {
        Map<Integer, Object> map = new HashMap<>();
        map.put(1, coupon.getCompanyID());
        map.put(2, coupon.getCategory().getCategoryId());
        map.put(3, coupon.getTitle());
        map.put(4, coupon.getDescription());
        map.put(5, coupon.getStartDate());
        map.put(6, coupon.getEndDate());
        map.put(7, coupon.getAmount());
        map.put(8, coupon.getPrice());
        map.put(9, coupon.getImage());
        map.put(10, id);
        DBManager.createQuery(CouponDaoQuery.UPDATE_COUPON, map, false);
        DBManager.closeConnection();
    }

    @Override
    public List<Coupon> getAllCoupons() throws SQLException {
        ResultSet resultSet = DBManager.createQuery(CouponDaoQuery.GET_ALL_COUPONS,null,true);
        List<Coupon> coupons = new ArrayList<>();
        while (resultSet.next()){
            coupons.add(getCoupon(resultSet));
        }
        return coupons;
    }

    @Override
    public List<Coupon> getCompanyCoupons(int companyId) throws SQLException {
        Map<Integer, Object> map = Map.of(
                1, companyId
        );
        ResultSet resultSet = DBManager.createQuery(CouponDaoQuery.GET_COUPON_BY_COMPANY_ID,map,true);
        List<Coupon> coupons = new ArrayList<>();
        while (resultSet.next()){
            coupons.add(getCoupon(resultSet));
        }
        return coupons;
    }

    @Override
    public List<Coupon> getCompanyCategoryCoupons(int companyId, int categoryId) throws SQLException {
        List<Coupon> coupons = this.getCompanyCoupons(companyId);
        List<Coupon> filteredList = new ArrayList<>();
        if(coupons != null) {
            for (Coupon coupon : coupons) {
                if (coupon.getCategory().getCategoryId() == categoryId) {
                    filteredList.add(coupon);
                }
            }
        }
        return filteredList;
    }

    @Override
    public List<Coupon> getCompanyCouponsMaxPrice(int companyId, double maxPrice) throws SQLException {
        List<Coupon> coupons = this.getCompanyCoupons(companyId);
        List<Coupon> filteredList = new ArrayList<>();
        for (Coupon coupon : coupons){
            if (coupon.getPrice() <= maxPrice){
                filteredList.add(coupon);
            }
        }
        return filteredList;
    }


    @Override
    public Coupon getCoupon(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int companyID = resultSet.getInt("companyId");
        int categoryID = resultSet.getInt("categoryId");
        String title = resultSet.getString("title");
        String description = resultSet.getString("description");
        Date startDate = resultSet.getDate("startDate");
        Date endDate = resultSet.getDate("endDate");
        int amount = resultSet.getInt("amount");
        double price = resultSet.getDouble("price");
        String image = resultSet.getString("image");
        return Coupon.builder()
                .id(id)
                .companyID(companyID)
                .category(Category.fromNumericalCategory(categoryID))
                .title(title)
                .description(description)
                .startDate(startDate)
                .endDate(endDate)
                .amount(amount)
                .price(price)
                .image(image);
    }

    @Override
    public Coupon getCouponByID(int couponID) throws SQLException {
        Map<Integer, Object> map = Map.of(
                1, couponID
        );
        ResultSet resultSet = DBManager.createQuery(CouponDaoQuery.GET_COUPON_BY_ID,map,true);
        Coupon coupon = null;
        if (resultSet.next()) {
            coupon = getCoupon(resultSet);
        }
        DBManager.closeConnection();
        return coupon;
        }

    @Override
    //add pair to customer vs coupon table and change amount in coupon
    public void addCouponPurchase(int customerID, int couponID) throws SQLException {
        Map<Integer, Object> map = Map.of(
                1, customerID,
                2, couponID
        );
        DBManager.createQuery(CouponDaoQuery.PURCHASE_COUPON, map, false);
        Map<Integer, Object> map2 = Map.of(
                1, couponID
        );
        DBManager.createQuery(CouponDaoQuery.UPDATE_AMOUNT_PURCHASE, map2, false);
        DBManager.closeConnection();
    }

    @Override
    //delete pair from customer vs coupon table and change amount in coupon
    public void deleteCouponPurchase(int customerID, int couponID) throws SQLException {
        Map<Integer, Object> map = Map.of(
                1, customerID,
                2, couponID
        );
        DBManager.createQuery(CouponDaoQuery.CANCEL_PURCHASE_COUPON, map, false);
        DBManager.closeConnection();
    }

    @Override
    public void deleteCouponPurchaseByCouponId(int couponID) throws SQLException {
        Map<Integer, Object> map = Map.of(
                1, couponID
        );
        DBManager.createQuery(CouponDaoQuery.CANCEL_PURCHASE_COUPON_BY_ID, map, false);
        DBManager.closeConnection();
    }

    @Override
    public void deleteCouponPurchaseByCustomerId(int customerID) throws SQLException {
        Map<Integer, Object> map2 = Map.of(
                1, customerID
        );
        DBManager.createQuery(CouponDaoQuery.CANCEL_PURCHASE_COUPON_BY_CUSTOMER_ID, map2, false);
        DBManager.closeConnection();
    }

    @Override
    public boolean isPurchased(int couponId) throws SQLException {
        Map<Integer, Object> map = Map.of(
                1, couponId
        );
        ResultSet resultSet = DBManager.createQuery(CouponDaoQuery.isPurchased,map,true);

        if(resultSet.next()){
            return true;
        } else {
            return false;
        }
    }
}
