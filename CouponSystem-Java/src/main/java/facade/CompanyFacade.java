package facade;


import beans.Company;
import beans.Coupon;

import java.sql.SQLException;
import java.util.List;

public class CompanyFacade extends ClientFacade{

    int companyId;
    List<Coupon> companyCoupons;

    public CompanyFacade() {
        super();
    }

    @Override
    public boolean login(String email, String password) throws SQLException, InterruptedException {
        if (getCompaniesDAO().isCompanyExist(email,password)) {
            Company company = getCompaniesDAO().getCompanyByEmail(email);
            this.companyId = company.getId();
            this.companyCoupons = getCompaniesDAO().getCompanyCoupons(this.companyId);
            return true;
        } else {
            System.out.println("FAILED: email or password are incorrect");
            return false;
        }
    };

    public void addCoupon(Coupon coupon) throws Exception {
        //not same title in company coupons
        for (Coupon companyCoupon : this.companyCoupons){
            if(coupon.getTitle().equals(companyCoupon.getTitle())){
                throw new Exception("FAILED: Coupon title already exist in Company Coupon's");
            }
        }
        getCouponsDAO().addCoupon(coupon);
    }

    public void updateCoupon(Coupon coupon, int id) throws Exception {
        //coupon id not updatable, company id not updatable
        Coupon dbCoupon = getCouponsDAO().getCouponByID(id);
        System.out.println(coupon.getId());

        if (coupon.getId() != 0 && coupon.getId() != id){
            throw new Exception("FAILED: couponID or companyID cannot be updated");
        }
        if(coupon.getCompanyID() != dbCoupon.getCompanyID()){
            throw new Exception("FAILED: coupon's companyID cannot be updated");
        }

        getCouponsDAO().updateCoupon(coupon,id);
    }

    public void deleteCoupon(int id) throws Exception {
        //check if exist
        //check if purchased
        //delete
        Coupon coupon = getCouponsDAO().getCouponByID(id);
        if(coupon == null){
            throw new Exception("FAILED: no coupon with this id");
        }
        if (getCouponsDAO().isPurchased(id)){
            getCouponsDAO().deleteCouponPurchaseByCouponId(id);
        }
        getCouponsDAO().deleteCoupon(id);
    }

    public int getCompanyId() {
        return companyId;
    }

    public Coupon getCouponById(int id) throws SQLException {
        return getCouponsDAO().getCouponByID(id);
    }

    public List<Coupon> getCompanyCoupons() throws SQLException {
        return getCouponsDAO().getCompanyCoupons(this.companyId);
    }

    public List<Coupon> getCompanyCategoryCoupons(int categoryId) throws SQLException {
        return getCouponsDAO().getCompanyCategoryCoupons(this.companyId, categoryId);
    }

    public List<Coupon> getCompanyCouponsMaxPrice(int maxPrice) throws SQLException {
        return getCouponsDAO().getCompanyCouponsMaxPrice(this.companyId, maxPrice);
    }

    public void getCompanyDetails() throws SQLException {
        Company company = getCompaniesDAO().getCompanyByID(this.companyId);
        System.out.println("##### Company Details #####");
        System.out.println("CompanyId: "+company.getId());
        System.out.println("Company Name: "+ company.getName());
        System.out.println("Company Email: "+ company.getEmail());
        System.out.println("Company coupons: ");
        for(Coupon coupon : this.getCompanyCoupons()){
            System.out.println(coupon);
        }
        System.out.println("##########");
    }


}
