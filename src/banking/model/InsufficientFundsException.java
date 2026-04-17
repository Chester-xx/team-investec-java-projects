// Custom checked exception
// Carries the shortfall amount
// getMessage() explains exactly what went wrong

package banking.model;

/**
 * Exception class defining shortfall
 * <br><br>
 * Allows throwing exception based on users unavailable balance to perform a withdrawal.
 * Carries exact shortfall amount to report precise amount needed.
 * <br><br>
 * Attributes:<br>
 * - shortfall
 * <br><br>
 * Methods:<br>
 * - InsufficientFundsException(double, double)<br>
 * - getShortfall()
 * 
 * @see BankAccount
*/
public class InsufficientFundsException extends Exception {

    private final double shortfall;

    /**
     * Constructs an InsufficientFundsException with a computed shortfall.
     * 
     * @param amountRequested the requested amount to withdraw
     * @param availableBalance the current balance of the account
    */
    public InsufficientFundsException(double amountRequested, double availableBalance){

        super(buildMessage(amountRequested, availableBalance));
        this.shortfall = amountRequested - availableBalance;
    
    }
    
    /**
     * Builds the user-facing message.
     * Extracted as a static helper so it can be passed to super() before {@code this.shortfall} is assigned.
     * 
     * @param amountRequested the requested amount to withdraw
     * @param availableBalance the current balance of the account
     * 
     * @return the value used by .getMessage()
    */
    private static String buildMessage(double amountRequested, double availableBalance){
        
        double shortfall = amountRequested - availableBalance;
        return String.format("Insufficient funds. You need R %.2f more to complete this withdrawal.", shortfall);
    
    }

    /**
     * Returns the exact amount by which the withdrawal exceeded the balance.
     * 
     * @return the shortfall amount
    */ 
    public double getShortfall(){
        return shortfall;
    }
    
}
