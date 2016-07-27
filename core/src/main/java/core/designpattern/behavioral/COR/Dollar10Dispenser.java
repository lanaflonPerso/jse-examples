package core.designpattern.behavioral.COR;

public class Dollar10Dispenser implements DispenseChain {

    private DispenseChain dispenseChain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.dispenseChain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if (cur.getAmount() >= 10) {
            int num = cur.getAmount() / 10;
            int remainder = cur.getAmount() % 10;
            System.out.println("Dispensing " + num + " 10$ note");
            if (remainder != 0)
                this.dispenseChain.dispense(new Currency(remainder));
        } else {
            this.dispenseChain.dispense(cur);
        }
    }

}