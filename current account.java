package banking.model;

import banking.Transaction;

public class CurrentAccount extends BankAccount {

    private double overdraftLimit; // stored as positive

    public CurrentAccount(String accountNumber, String owner, double initialBalance, double overdraftLimit) {
        super(accountNumber, owner, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {

        // validate amount
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }

        // overdraft rule
        if (getBalance() - amount < -overdraftLimit) {
            throw new InsufficientFundsException("Overdraft limit exceeded");
        }

        // perform withdrawal
        deductFromBalance(amount);

        // log transaction
        Transaction t = new Transaction(Transaction.Type.WITHDRAWAL, amount, getBalance());
        addTransaction(t);
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("Limit must be positive");
        }
        this.overdraftLimit = limit;
    }

    @Override
    public String toString() {
        return "CurrentAccount{" +
                "accountNumber='" + getAccountNumber() + '\'' +
                ", owner='" + getOwner() + '\'' +
                ", balance=R " + getBalance() +
                ", overdraftLimit=R " + overdraftLimit +
                '}';
    }
}