package core.designpattern.behavioral.strategy;

public class StrategyMain {

    /**
     * @param args
     */
    public static void main(String...args) {
        PaymentContext cart = new PaymentContext();

        Item item1 = new Item("1234", 10);
        Item item2 = new Item("5678", 40);

        cart.addItem(item1);
        cart.addItem(item2);

        cart.pay(new PayPalStrategy("himansuxnayak@gmail.com", "123"));
        cart.pay(new PlasticCardStrategy("Himansu Nayak", "1234567890123456", "786", "12/15"));

    }

}
