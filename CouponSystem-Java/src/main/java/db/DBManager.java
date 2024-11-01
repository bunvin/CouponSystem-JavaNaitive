package db;



//in file
//connection to db
//functions - createQuery, init(), dropAllTable()

import java.sql.*;
import java.util.Map;

public class DBManager {
    public static final String URL = "jdbc:mysql://localhost:3306/db";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "1234";


    ///SQL queries for init tables
    public static final String ADD_COMPANY_TABLE = "CREATE TABLE `db`.`company` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `name` VARCHAR(45) NULL,\n" +
            "  `email` VARCHAR(45) NULL,\n" +
            "  `password` VARCHAR(45) NULL,\n" +
            "  PRIMARY KEY (`id`));";

    public static final String ADD_CUSTOMER_TABLE = "CREATE TABLE `db`.`customer` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `firstName` VARCHAR(45) NULL,\n" +
            "  `lastName` VARCHAR(45) NULL,\n" +
            "  `email` VARCHAR(45) NULL,\n" +
            "  `password` VARCHAR(45) NULL,\n" +
            "  PRIMARY KEY (`id`));";

    public static final String ADD_CATEGORY_TABLE = "CREATE TABLE `db`.`category` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `name` VARCHAR(45) NULL,\n" +
            "  PRIMARY KEY (`id`));";

    public static final String ADD_COUPON_TABLE = "CREATE TABLE `db`.`coupon` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `companyId` INT NULL,\n" +
            "  `categoryId` INT NULL,\n" +
            "  `title` VARCHAR(45) NULL,\n" +
            "  `description` VARCHAR(45) NULL,\n" +
            "  `startDate` DATE NULL,\n" +
            "  `endDate` DATE NULL,\n" +
            "  `amount` INT NULL,\n" +
            "  `price` DOUBLE NULL,\n" +
            "  `image` VARCHAR(45) NULL,\n" +
            "  PRIMARY KEY (`id`));\n";

    public static final String ADD_CUSTOMERS_VS_COUPONS_TABLE = "CREATE TABLE `db`.`customersvscoupons` (\n" +
            "  `customerId` INT NOT NULL,\n" +
            "  `couponId` INT NOT NULL,\n" +
            "  INDEX `customerId_idx` (`customerId` ASC) VISIBLE,\n" +
            "  INDEX `couponId_idx` (`couponId` ASC) VISIBLE,\n" +
            "  CONSTRAINT `customerId1`\n" +
            "    FOREIGN KEY (`customerId`)\n" +
            "    REFERENCES `db`.`customer` (`id`)\n" +
            "    ON DELETE CASCADE\n" +
            "    ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `couponId1`\n" +
            "    FOREIGN KEY (`couponId`)\n" +
            "    REFERENCES `db`.`coupon` (`id`)\n" +
            "    ON DELETE CASCADE\n" +
            "    ON UPDATE NO ACTION);";

    //
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

    public static final String DROP_ALL = "DROP TABLE `db`.`company`, `db`.`coupon`, `db`.`category`, `db`.`customer`, `db`.`customersvscoupons`;";

    public static ResultSet createQuery(String query, Map<Integer, Object> map, boolean isResultSet) throws SQLException, InterruptedException {
        Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        if (map != null) {
            for (Map.Entry<Integer, Object> entry : map.entrySet()) {
                preparedStatement.setObject(entry.getKey(), entry.getValue());
            }
        }

        if (isResultSet) {
            return preparedStatement.executeQuery();
        }
        preparedStatement.execute();
        return null;
    }

    public static void init() throws SQLException, InterruptedException {

        createQuery(ADD_COMPANY_TABLE, null, false);
        createQuery(ADD_CUSTOMER_TABLE, null, false);
        createQuery(ADD_CATEGORY_TABLE, null, false);
        createQuery(ADD_COUPON_TABLE, null, false);
        createQuery(ADD_CUSTOMERS_VS_COUPONS_TABLE, null, false);
    }

    public static void dropAllTable() throws SQLException, InterruptedException {
        createQuery(DROP_ALL, null, false);
    }
}
