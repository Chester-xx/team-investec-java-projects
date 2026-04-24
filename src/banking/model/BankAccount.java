// Abstract base
// Holds accountNumber, ownerName, balance, List<Transaction> 
// Defines abstract withdraw() 
// Provides concrete deposit() 

package banking.model;

import java.util.ArrayList;

// Relies on Transaction Type definition
import banking.model.Transaction.Type;

/**
 * Abstract base class representing a bank account.
 * 
 * Defines the common structure and behavior for all bank account types.
 * Subclasses must implement their own withdrawal rules via the abstract
 * withdraw() method.
 * <br><br>
 * Attributes:<br>
 * - accountNumber (String)<br>
 * - ownerName (String)<br>
 * - balance (double)<br>
 * - transactions (ArrayList&lt;Transaction&gt;)
 * <br><br>
 * Methods:<br>
 * - BankAccount(String, String, double)<br>
 * - getAccountNumber(), getOwnerName(), getBalance(), getTransactions()<br>
 * - deductFromBalance(double)<br>
 * - deposit(double)<br>
 * - withdraw(double) [abstract]<br>
 * - printStatement()
 * 
 * @see Transaction
 * @see InsufficientFundsException
 */
public abstract class BankAccount {
    
    private String accountNumber;
    private String ownerName;
    private double balance;
    private ArrayList<Transaction> transactions;

    /**
     * Constructs a BankAccount with the specified account details.
     * 
     * @param accountNumber the unique account number
     * @param ownerName the name of the account owner
     * @param initialBalance the initial balance of the account
    */
    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
     
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
    
    }

    /**
     * Gets the account number.
     * 
     * @return the account number
    */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Gets the owner's name.
     * 
     * @return the owner's name
    */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Gets the current balance.
     * 
     * @return the current balance
    */
    public double getBalance() {
        return balance;
    }

    /**
     * Gets the list of transactions.
     * 
     * @return the list of transactions
    */
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * Deducts the specified amount from the balance.
     * 
     * @param amount the amount to deduct
    */
    protected void deductFromBalance(double amount) {
        balance -= amount;
    }

    /**
     * Withdraws the specified amount from the account.
     * 
     * @param amount the amount to withdraw
     * @throws InsufficientFundsException if the balance is insufficient
    */
    public abstract void withdraw(double amount) throws InsufficientFundsException;

    /**
     * Deposits the specified amount into the account.
     * Validates that the amount is greater than zero, updates the balance,
     * and creates a transaction record.
     * 
     * @param amount the amount to deposit
     * @throws IllegalArgumentException if amount is less than or equal to zero
    */
    public void deposit(double amount) {
        
        // throws exception if amount is less than or equal to zero
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount cannot be less than or equal to zero.");
        }
        
        // Update balance
        balance += amount;
    
        // create new transaction and add to transactions list
        addTransaction(new Transaction(Type.DEPOSIT, amount, balance));
    
    }

    /**
     * Logs a new transaction to the transaction list.
     * 
     * @param transaction the new transaction object to be added
    */ 
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    /**
     * Prints the account statement showing the last 5 transactions,
     * or all transactions if fewer than 5 exist.
    */
    public void printStatement() {
        
        // Prints message if transactions is empty
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        // Prints all transactions if its size is less than 6
        if (transactions.size() <= 5) {
            for (Transaction t : transactions) {
                System.out.println(t);
            }
            return;
        }

        // Prints the LAST 5 transactions if its size is greater than 5
        for (int i = transactions.size() - 5; i < transactions.size(); i++) {
            System.out.println(transactions.get(i));
        }

    }

}
