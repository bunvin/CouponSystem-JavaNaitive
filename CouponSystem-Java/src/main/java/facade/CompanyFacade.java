package facade;


import beans.Company;
import beans.Coupon;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyFacade extends ClientFacade{

    int companyId;

    public CompanyFacade() {
        super();
    }

    @Override
    public boolean login(String email, String password) throws SQLException, InterruptedException {
        if (getCompaniesDAO().isCompanyExist(email,password)) {
            Company company = getCompaniesDAO().getCompanyByEmail(email);
            this.companyId = company.getId();
            return true;
        } else {
            return false;
        }
    };

    public int getCompanyId() {
        return companyId;
    }

    //NEED TO BE TESTED
    public void addCoupon(Coupon coupon) throws Exception {
        //not same title in company coupons
        List<Coupon> companyCouponList = getCompaniesDAO().getCompanyCoupons(this.companyId);

        for (Coupon companyCoupon : companyCouponList){
            System.out.println(companyCoupon);
            System.out.println("+++++++++++++");
            if(coupon.getTitle().equals(companyCoupon.getTitle())){
                throw new Exception("FAILED: Coupon title already exist in Company Coupon's");
            }
        }
        getCouponsDAO().addCoupon(coupon);
    }

}
