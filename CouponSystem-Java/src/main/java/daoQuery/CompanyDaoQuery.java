package daoQuery;

public class CompanyDaoQuery {
    public static final String ADD_COMPANY = "INSERT INTO `db`.`company` (`name`, `email`, `password`) VALUES (?, ?, ?);\n";
    public static final String IS_COMPANY_EXIST = "SELECT * FROM db.company WHERE email = ? AND password = ?;";

}
