// Extends BankAccount
// Has overdraftLimit
// withdraw() allows negative balance down to the limit

package banking.model;

/**
 * Child class of BankAccount representing a current bank account including a specified overdraft limit.
 * 
 * Defines the common structure and behavior for the account type.
 * <br><br>
 * Attributes:<br>
 * - accountNumber (String)<br>
 * - ownerName (String)<br>
 * - initialBalance (double)<br>
 * - overdraftLimit (positive double)
 * <br><br>
 * Methods:<br>
 * - CurrentAccount(String, String, double, double)<br>
 * - getOverdraftLimit(), setOverdraftLimit()<br>
 * - withdraw(double)<br>
 * - toString()
 * 
 * @see BankAccount
 * @see Transaction
 * @see InsufficientFundsException
 */
public class CurrentAccount extends BankAccount {

    private double overdraftLimit; // stored as positive

    /**
     * Constructs a CurrentAccount with the specified account details.
     * 
     * @param accountNumber the unique account number
     * @param ownerName the name of the account owner
     * @param initialBalance the initial balance of the account
     * @param overdraftLimit the allowed overdraft of the account
    */
    public CurrentAccount(String accountNumber, String ownerName, double initialBalance, double overdraftLimit) {
        super(accountNumber, ownerName, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    /**
     * Withdraws the specified amount from the account, allowing an overdraft relative to the account preference.
     * 
     * @param amount the amount to withdraw
     * 
     * @throws InsufficientFundsException if the balance is insufficient
     * @throws IllegalArgumentException if the amount specified is less than or equal to zero
    */
    @Override
    public void withdraw(double amount) throws InsufficientFundsException {

        // throws exception if amount is less than or equal to zero
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount cannot be less than or equal to zero.");
        }

        // overdraft rule
        if (getBalance() - amount < -overdraftLimit) {
            throw new InsufficientFundsException(amount, getBalance() + overdraftLimit);
        }

        // perform withdrawal
        deductFromBalance(amount);

        // log transaction
        addTransaction(new Transaction(Transaction.Type.WITHDRAWAL, amount, getBalance()));
    }

    /** 
     * Gets the account overdraft limit
     * 
     * @return the overdraft limit
    */
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    /** 
     * Sets the new overdraft limit of the account.
     * 
     * @param limit the new overdraft limit
    */ 
    public void setOverdraftLimit(double limit) {
        
        // check valid overdraft limit - allow 0 as account may not require overdraft
        if (limit < 0) {
            throw new IllegalArgumentException("Overdraft limit cannot be less than zero.");
        }

        // set limit
        this.overdraftLimit = limit;
    }

    /**
     * Gets the current account information as a formatted string representation.
     * 
     * @return the formatted account details
    */ 
    public String toString() {
        
        // format return
        return 
            """
            Account Type: Current Account
            Account Number: %s
            Account Owner: %s
            Balance: R%.2f
            Overdraft Limit: R%.2f
            """
            .formatted(
                getAccountNumber(),
                getOwnerName(),
                getBalance(),
                getOverdraftLimit()
            );

    }
}