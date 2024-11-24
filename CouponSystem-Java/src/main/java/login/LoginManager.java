package login;

import facade.AdminFacade;
import facade.ClientFacade;
import facade.CompanyFacade;
import facade.CustomerFacade;

import java.sql.SQLException;

public class LoginManager {


    private final static LoginManager loginManager = new LoginManager();

    private LoginManager(){};

    public static LoginManager getInstance(){
        return loginManager;
    }

    public ClientFacade login(String email, String password, int clientType) throws Exception {
        //validate clientType exist
        if (clientType <= 0 || clientType >= 4) {
            System.out.println("FAILED: client type is not valid");
            return null;
        }

        switch (clientType) {

            case ClientType.ADMIN:
                ClientFacade adminFacade = new AdminFacade();
                if (!adminFacade.login(email, password)) {
                    return null;
                }
                System.out.println("Login successful >> ClientType Admin");
                return adminFacade;

            case ClientType.COMPANY:
                ClientFacade companyFacade = new CompanyFacade();
                if (!companyFacade.login(email, password)) {
                    return null;
                }
                System.out.println("Login successful >> ClientType Company");
                return companyFacade;

            case ClientType.CUSTOMER:
                ClientFacade customerFacade = new CustomerFacade();
                if (!customerFacade.login(email, password)) {
                    return null;
                }
                System.out.println("Login successful >> ClientType Customer");
                return customerFacade;
        }
        return null;
    }



}
