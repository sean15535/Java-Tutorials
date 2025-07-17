public class BankAccount {
    private String accountHolderName;     // Instance variable
    private double balance;               // Instance variable
    private static double interestRate = 0.05; // Static variable shared by all accounts

    public BankAccount(String name, double initialBalance) {
        this.accountHolderName = name;
        this.balance = initialBalance;
    }
    public void deposit(double amount) {    // Instance method
        balance += amount;
    }

    public void withdraw(double amount) {   // Instance method
        if (amount <= balance) {
            balance -= amount;
        }
    }

    public double getBalance() {             // Instance method
        return balance;
    }

    public static double getInterestRate() { // Static method
        return interestRate;
    }

    public static void setInterestRate(double newRate) { // Static method
        interestRate = newRate;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
}