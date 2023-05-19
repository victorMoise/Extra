package Proxy_FinancialInformation;

public class FinancialInformationProxy implements FinancialInformation {
    private String username;
    private String password;
    private FinancialInformationImpl financialInformation;

    public FinancialInformationProxy(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void accessInformation() {
        if (authenticateUser()) {
            financialInformation = new FinancialInformationImpl(username, password);
            financialInformation.accessInformation();
            logAccess();
        } else {
            System.out.println("Access denied. Invalid credentials.");
        }
    }

    private boolean authenticateUser() {
        // Perform authentication logic here
        return username.equals("admin") && password.equals("password");
    }

    private void logAccess() {
        System.out.println("Logged access to financial information.");
    }
}

