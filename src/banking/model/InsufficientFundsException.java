// Custom checked exception
// Carries the shortfall amount
// getMessage() explains exactly what went wrong

package banking.model;

//Checked exception thrown when a withdrawal cannot be completed because the account has insufficient funds.
//Carries the exact shortfall so the catch block can report precisely how much more money the user needs.

public class InsufficientFundsException extends Exception {

    private final double shortfall;

    //Constructs an InsufficientFundsException with a computed shortfall.
    //@param amountRequested  the amount the caller tried to withdraw
    //@param availableBalance the current balance of the account
    public InsufficientFundsException(double amountRequested, double availableBalance){
        super(buildMessage(amountRequested, availableBalance));
        this.shortfall = amountRequested - availableBalance;
    }
    //Builds the user-facing error message
    //Extracted as a static helper so it can be passed to super() before {@code this.shortfall} is assigned.
    private static String buildMessage(double amountRequested, double availableBalance){
        double shortfall = amountRequested - availableBalance;
        return String.format(
            "Insufficient funds. You need R %.2f more to complete this withdrawal.", shortfall
        );
    
        
    }
    //Returns the exact amount by which the withdrawal exceeded the balance
    //Returns the shortfall (amountRequested - availableBalance)
    //getShortfall returns the raw double, whereas getMessage gives a human-readable string
    public double getShortfall(){
        return shortfall;
    }
    
}
