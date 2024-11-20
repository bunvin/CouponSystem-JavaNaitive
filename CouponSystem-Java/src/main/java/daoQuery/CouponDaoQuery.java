package daoQuery;

import dao.CouponsDAO;

public class CouponDaoQuery {

    public static final String ADD_COUPON = "INSERT INTO `db`.`coupon` (`companyID`, `title`, " + "`categoryID`," +
            "`description`, `startDate`, `endDate`, `amount`, `price`, `image`) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?);\n";


    public static final String DELETE_COUPON = "DELETE FROM `db`.`coupon` WHERE (`id` = ?);\n";
    public static final String UPDATE_COUPON = "UPDATE `db`.`coupon` SET `companyID` = ?,`categoryID` = ?, `title` = " +
            "?, `description` = ?, `startDate` = ?, `endDate` = ?, `amount` = ?, `price` = ?, `image` = ? WHERE (`id` = ?);\n";
    public static final String GET_ALL_COUPONS = "SELECT * FROM db.coupon;";
    public static final String GET_COUPON_BY_ID = "SELECT * FROM db.coupon WHERE id = ?";
    public static final String GET_COUPON_BY_COMPANY_ID = "SELECT * FROM db.coupon WHERE companyId = ?";
    //coupon amount -1, add customer vs coupons
    public static final String PURCHASE_COUPON = "INSERT INTO `db`.`customersvscoupons` (`customerId`, `couponId`) " +
            "VALUES (?, ?);\n";

    public static final String UPDATE_AMOUNT_PURCHASE =
            "UPDATE `db`.`coupon`\n" +
            "SET `amount` = `amount` - 1\n" +
            "WHERE `id` = ?;";

    public static final String CANCEL_PURCHASE_COUPON = "DELETE FROM `db`.`customersvscoupons` WHERE (`customerId` = " +
            "? AND `couponId` = ?);\n";

    public static final String CANCEL_PURCHASE_COUPON_BY_CUSTOMER_ID = "DELETE FROM `db`.`customersvscoupons` WHERE " +
            "(`customerId` = ? );";

    public static final String CANCEL_PURCHASE_COUPON_BY_ID = "DELETE FROM `db`.`customersvscoupons` WHERE " +
            "(`couponId` = ?);\n;";


        public static final String GET_CUSTOMER_COUPONS_BY_ID = "SELECT * \n" +
                "FROM db.customersvscoupons\n" +
                "INNER JOIN db.coupon\n" +
                "ON customersvscoupons.couponId = coupon.id\n" +
                "WHERE customerId = ? ;";

        public static final String isPurchased = "SELECT * \n" +
                "FROM db.customersvscoupons\n" +
                "WHERE couponId = ?;";


}
