package core.designpattern.behavioral.strategy;

public class PayPalStrategy implements PaymentStrategy {

    /*
     * (non-Javadoc)
     * 
     * @see PaymentStrategy#pay(int)
     */
    private String emailId;
    private String password;

    public PayPalStrategy(String email, String pwd) {
        this.emailId = email;
        this.password = pwd;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using Paypal.");
    }

}
