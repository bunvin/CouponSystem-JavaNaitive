package daoQuery;

import dao.CouponsDAO;

public class CouponDaoQuery {
    public static final String ADD_COUPON = "INSERT INTO `db`.`coupon` (`companyID`, `categoryID`, `title`, " +
            "`description`, `startDate`, `endDate`, `amount`, `price`, `image`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);\n";
    public static final String DELETE_COUPON = "DELETE FROM `db`.`coupon` WHERE (`id` = ?);\n";
    public static final String UPDATE_COUPON = "UPDATE `db`.`coupon` SET `companyID` = ?,`categoryID` = ?, `title` = " +
            "?, `description` = ?, `startDate` = ?, `endDate` = ?, `amount` = ?, `price` = ?, `image` = ? WHERE (`id` = ?);\n";
    public static final String GET_ALL_COUPONS = "SELECT * FROM db.coupon;";
    public static final String GET_COUPON_BY_ID = "SELECT * FROM db.coupon WHERE id = ?";

    //coupon amount -1, add customer vs coupons
    public static final String PURCHASE_COUPON = "INSERT INTO `db`.`customersvscoupons` (`customerId`, `couponId`) " +
            "VALUES (?, ?);\n";
    public static final String UPDATE_AMOUNT_PURCHASE =
            "UPDATE `db`.`coupon`\n" +
            "SET `amount` = `amount` - 1\n" +
            "WHERE `id` = ?;";

    public static final String CANCEL_PURCHASE_COUPON = "DELETE FROM `db`.`customersvscoupons` WHERE (`customerId` = " +
            "? AND `couponId` = ?);\n +" +
            "\"UPDATE `db`.`coupon`\\n\" +\n" +
            "            \"SET `amount` = `amount` + 1\\n\" +\n" +
            "            \"WHERE `id` = ?;\";";

    public static final String UPDATE_AMOUNT_CANCEL =
            "UPDATE `db`.`coupon`\n" +
                    "SET `amount` = `amount` + 1\n" +
                    "WHERE `id` = ?;";
}
