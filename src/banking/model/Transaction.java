// Immutable
// Stores type (DEPOSIT/WITHDRAWAL), amount, balanceAfter, timestamp
// Created inside deposit() and withdraw().

package banking.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Immutable record of a single transaction on a bank account.
 * <br><br>
 * Stores transaction details including type, amount, resulting balance,
 * and timestamp. Transactions are created within deposit() and withdraw()
 * methods and cannot be modified after creation.
 * <br><br>
 * Attributes:<br>
 * - type (Type enum: DEPOSIT or WITHDRAWAL)<br>
 * - amount (double)<br>
 * - balanceAfter (double)<br>
 * - timestamp (LocalDateTime)
 * <br><br>
 * Methods:<br>
 * - Transaction(Type, double, double)<br>
 * - getType()<br>
 * - getAmount()<br>
 * - getBalanceAfter()<br>
 * - getTimestamp()<br>
 * - toString()
 * 
 * @see Type
 * @see BankAccount
*/
public class Transaction {

    private final Type type;
    private final double amount;
    private final double balanceAfter;
    private final LocalDateTime timestamp;
    
    /**
     * Enumeration of transaction types.
    */
    public enum Type {
        DEPOSIT,
        WITHDRAWAL
    }
    
    /**
     * Constructs a Transaction with the specified details.
     * Timestamp is automatically set to the current date and time.
     * 
     * @param type the transaction type (DEPOSIT or WITHDRAWAL)
     * @param amount the transaction amount
     * @param balanceAfter the account balance after this transaction
    */
    public Transaction(Type type, double amount, double balanceAfter) {

        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        // set timestamp to current date and time when transaction is created
        this.timestamp = LocalDateTime.now();
    
    }
    
    /**
     * Gets the transaction type.
     * 
     * @return the transaction type
    */
    public Type getType() {
        return type;
    }

    /**
     * Gets the transaction amount.
     * 
     * @return the transaction amount
    */
    public double getAmount() {
        return amount;
    }

    /**
     * Gets the account balance after this transaction.
     * 
     * @return the account balance after this transaction
    */
    public double getBalanceAfter() {
        return balanceAfter;
    }

    /**
     * Gets the transaction timestamp.
     * 
     * @return the date and time of the transaction
    */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    /**
     * Returns a formatted string representation of the transaction.
     * <br><br>
     * Format: [yyyy-MM-dd HH:mm] TYPE R amount Balance: R balance
     * <br>
     * Example: [2024-03-15 14:32] DEPOSIT R 500.00 Balance: R 1500.00
     * 
     * @return formatted transaction string
     */
    public String toString() {

        // Format timestamp to "yyyy-MM-dd HH:mm"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDate = timestamp.format(formatter);

        // Return formatted string with date, type, amount, and balance after transaction
        return String.format(
            "[%s] %s R %.2f Balance: R %.2f",
            formattedDate,
            type,
            amount,
            balanceAfter
        );
    }

}