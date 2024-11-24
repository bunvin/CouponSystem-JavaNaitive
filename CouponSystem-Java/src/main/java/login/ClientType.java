package login;

public class ClientType {
    public static final int ADMIN = 1;
    public static final int COMPANY = 2;
    public static final int CUSTOMER = 3;

    private int clientType;

    private ClientType(){
    };

    public void setClientType(int clientType) {
        this.clientType = clientType;
    }

    public int getClientType(){
        return this.clientType;
    }
}
