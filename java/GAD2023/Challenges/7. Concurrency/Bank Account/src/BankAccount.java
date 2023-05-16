public class BankAccount {
    private String name;
    private double debit;

    public BankAccount(String name, int debit) {
        this.name = name;
        this.debit = debit;
    }

    public synchronized void withdraw(double amount) {
        if (debit >= amount) {
            longDatabaseCall();
            debit -= amount;
            System.out.println(name + " withdrew " + amount + " and now has " + debit + " in the account.");
        } else {
            System.out.println(name + " cannot withdraw " + amount + " because the account only has " + debit + ".");
        }
    }

    public synchronized void deposit(double amount) {
        longDatabaseCall();
        debit += amount;
        System.out.println(name + " deposited " + amount + " and now has " + debit + " in the account.");
    }

    private void longDatabaseCall() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
