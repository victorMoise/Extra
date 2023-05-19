package Proxy_FinancialInformation;

public class FinancialInformationImpl implements FinancialInformation {
    private String username;
    private String password;

    public FinancialInformationImpl(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void accessInformation() {
        // Implementation for accessing the financial information
        System.out.println("Accessing financial information...");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Displaying sensitive financial data...");
        System.out.println("------------------------");
    }
}
