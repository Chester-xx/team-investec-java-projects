package banking;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    // Public enum defined inside the class
    public enum Type {
        DEPOSIT, WITHDRAWAL
    }

    private Type type;
    private final double amount;
    private final double balanceAfter;
    private final LocalDateTime timestamp;
    
    public Transaction(Type type, double amount, double balanceAfter) {
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        this.timestamp = LocalDateTime.now();
    }
    
    // Getters for the fields
    public Type getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalanceAfter() {
        return balanceAfter;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    /**
     * the return format of date is [yyy-mm-dd HH:mm] type R amount balance
     * example: [2024-06-01 14:30] type DEPOSIT amount 100.0 balance 1100.0
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDate = timestamp.format(formatter);
        return String.format("[%s] %-10s R %8.2f Balance: R %.2f",
                formattedDate, type, amount, balanceAfter);
            }


}