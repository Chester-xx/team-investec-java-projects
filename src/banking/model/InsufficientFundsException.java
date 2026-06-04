// Custom checked exception
// Carries the shortfall amount
// getMessage() explains exactly what went wrong

package banking.model;

public class InsufficientFundsException extends Exception {
    private final double shortfall;

    public InsufficientFundsException(double amountRequested, double availableBalance) {
        super(String.format(
            "Insufficient funds. You need R %.2f more to complete this withdrawal.",
            amountRequested - availableBalance
        ));
        this.shortfall = amountRequested - availableBalance;
    }

    public double getShortfall() {
        return shortfall;
    }
}
