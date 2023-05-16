public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Matei", 1000);
        BankAccount account2 = new BankAccount("Andrei", 500);

        TransactionThread transaction1 = new TransactionThread("Transaction 1", account1, account2, 200);
        TransactionThread transaction2 = new TransactionThread("Transaction 2", account2, account1, 300);

        transaction1.start();
        transaction2.start();
    }
}