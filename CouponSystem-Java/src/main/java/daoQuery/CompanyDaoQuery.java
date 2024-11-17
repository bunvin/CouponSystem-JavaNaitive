package daoQuery;

import javax.swing.plaf.PanelUI;

public class CompanyDaoQuery {
    public static final String ADD_COMPANY = "INSERT INTO `db`.`company` (`name`, `email`, `password`) VALUES (?, ?, ?);\n";
    public static final String DELETE_COMPANY = "DELETE FROM `db`.`company` WHERE (`id` = ?);\n";
    public static final String UPDATE_COMPANY = "UPDATE `db`.`company` SET `name` = ?, `email` = ?, `password` = ? WHERE (`id` = ?);\n";;
    public static final String GET_ONE_COMPANY_BY_ID = "SELECT * FROM db.company WHERE id = ?";
    public static final String GET_ALL_COMPANIES = "SELECT * FROM db.company;";
    public static final String IS_COMPANY_EXIST = "SELECT * FROM db.company WHERE email = ? and password = ? ;\n";
    public static final String IS_COMPANY_NAME_AND_PASSWORD_EXIST ="SELECT * FROM db.company WHERE name = ? and email" +
            " = ? ;\n";
    public static final String GET_COMPANY_COUPONS_BY_ID = "SELECT * FROM db.coupon WHERE `companyId` = ?;";
}
