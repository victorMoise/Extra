package Proxy_FinancialInformation;

public class Main {
    public static void main(String[] args) {
        FinancialInformation financialInformation = new FinancialInformationProxy("admin", "password");
        financialInformation.accessInformation();
    }
}
