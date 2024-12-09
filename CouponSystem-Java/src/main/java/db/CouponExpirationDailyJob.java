package db;

import beans.Coupon;
import dao.CouponsDAO;
import dbDao.CouponDBDAO;

import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class CouponExpirationDailyJob {
    private static CouponsDAO couponDBDAO = new CouponDBDAO();
    private static boolean quit = false;

    public CouponExpirationDailyJob() {}

    public static void stop(Thread thread){
        quit = true;
        thread.interrupt();
        System.out.println("stopped");
    }

    public static Thread run(){
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                boolean isFirstRun = true;

                while (!quit) {
                    System.out.println("Job started");
                    //get all coupons
                    List<Coupon> coupons;
                    try {
                        coupons = couponDBDAO.getAllCoupons();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    //if endDate is date before now

                    for (Coupon coupon : coupons) {
                        if (coupon.getEndDate().before(new Date())) {
                            //delete purchase by couponId
                            try {
                                couponDBDAO.deleteCouponPurchaseByCouponId(coupon.getId());
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                            //delete coupon
                            try {
                                couponDBDAO.deleteCoupon(coupon.getId());
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }

                    System.out.println("FINISHED: Job is done, expired coupons are deleted");


                    //TESTING- SHORT SLEEP
//                    try {
//                        Thread.sleep(30000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }

                   // activate job at midnight
                    if (isFirstRun) {
                        //calculate time between now and 00:00
                        LocalTime now = LocalTime.now();
                        LocalTime midnight = LocalTime.MIDNIGHT.minusMinutes(1); //23:59
                        long duration = Duration.between(now, midnight).toMillis()+60000; //00:00
                        //sleep in milliseconds until then
                        isFirstRun = false;
                        System.out.println("Bye bye, see you in " + duration/3600000 +"hr");
                        try {
                            Thread.sleep(duration);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    } else {
                        System.out.println("Bye bye, see you in 24hr");
                        //sleep 24hours
                        try {
                            Thread.sleep(86400000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                System.out.println("out of the while loop");
            }
        };
    //running the thread
        Thread thread = new Thread(runnable);
        thread.start();
        return thread;
    }

}
