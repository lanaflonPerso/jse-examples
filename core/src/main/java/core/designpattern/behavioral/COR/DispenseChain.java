package core.designpattern.behavioral.COR;

public interface DispenseChain {
    void setNextChain(DispenseChain dispenseChain);

    void dispense(Currency currency);
}