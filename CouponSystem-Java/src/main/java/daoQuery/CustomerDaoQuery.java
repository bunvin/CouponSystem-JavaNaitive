package daoQuery;

public class CustomerDaoQuery {
    public static final String ADD_CUSTOMER = "INSERT INTO `db`.`customer` (`firstName`, `lastName`, `email`, `password`) VALUES (?, ?, ?, ?);\n";
    public static final String DELETE_CUSTOMER = "DELETE FROM `db`.`customer` WHERE (`id` = ?);\n";
    public static final String UPDATE_CUSTOMER = "UPDATE `db`.`customer` SET `firstName` = ?,`lastName` = ?, `email` = ?, `password` = ? WHERE (`id` = ?);\n";
    ;
    public static final String GET_ONE_CUSTOMER_BY_ID = "SELECT * FROM db.customer WHERE id = ?";
    public static final String GET_ALL_CUSTOMER = "SELECT * FROM db.customer;";
    public static final String IS_CUSTOMER_EXIST = "SELECT * FROM db.customer WHERE email = ? and password = ? ;\n";
}
