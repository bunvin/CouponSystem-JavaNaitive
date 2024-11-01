package daoQuery;

public class CouponDaoQuery {

    public static final String ADD_COMPANY_ID_TO_COUPON = "ALTER TABLE `db`.`coupon` \n" +
            "ADD INDEX `comapnyId_idx` (`companyId` ASC) VISIBLE;\n" +
            ";\n" +
            "ALTER TABLE `db`.`coupon` \n" +
            "ADD CONSTRAINT `comapnyId`\n" +
            "  FOREIGN KEY (`companyId`)\n" +
            "  REFERENCES `db`.`company` (`id`)\n" +
            "  ON DELETE NO ACTION\n" +
            "  ON UPDATE NO ACTION;";

    public static final String ADD_CATEGORY_ID_TO_COUPON = "ALTER TABLE `db`.`coupon` \n" +
            "ADD INDEX `CATEGORYiD_idx` (`categoryId` ASC) VISIBLE;\n" +
            ";\n" +
            "ALTER TABLE `db`.`coupon` \n" +
            "ADD CONSTRAINT `CATEGORYiD`\n" +
            "  FOREIGN KEY (`categoryId`)\n" +
            "  REFERENCES `db`.`category` (`id`)\n" +
            "  ON DELETE NO ACTION\n" +
            "  ON UPDATE NO ACTION;";

}
