package core.designpattern.behavioral.strategy;

public class PlasticCardStrategy implements PaymentStrategy {

    /*
     * (non-Javadoc)
     * 
     * @see PaymentStrategy#pay(int)
     */
    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public PlasticCardStrategy(String nm, String ccNum, String cvv, String expiryDate) {
        this.name = nm;
        this.cardNumber = ccNum;
        this.cvv = cvv;
        this.dateOfExpiry = expiryDate;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid with credit/debit card");
    }

}
