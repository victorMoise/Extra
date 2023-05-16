public class TransactionThread extends Thread {
    private String name;
    private BankAccount from;
    private BankAccount to;
    private double amount;

    public TransactionThread(String name, BankAccount from, BankAccount to, double amount) {
        this.name = name;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public void run() {
        System.out.println(name + " started transaction.");
        transfer(from, to, amount);
        System.out.println(name + " finished transaction.");
    }

    private void transfer(BankAccount from, BankAccount to, double amount) {
        from.withdraw(amount);
        to.deposit(amount);
    }
}