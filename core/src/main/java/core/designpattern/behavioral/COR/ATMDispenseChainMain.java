package core.designpattern.behavioral.COR;

import java.util.Scanner;

public class ATMDispenseChainMain {

    private DispenseChain c1 = new Dollar50Dispenser();
    private DispenseChain c2 = new Dollar20Dispenser();
    private DispenseChain c3 = new Dollar10Dispenser();

    public ATMDispenseChainMain() {
        c1.setNextChain(c2);
        c2.setNextChain(c3);
    }

    public static void main(String...args) {
        ATMDispenseChainMain atmDispenser = new ATMDispenseChainMain();
        while (true) {
            int amount = 0;
            System.out.println("Enter amount to dispense");
            Scanner input = new Scanner(System.in);
            amount = input.nextInt();
            if (amount % 10 != 0) {
                System.out.println("Amount should be in multiple of 10s.");
                return;
            }
            atmDispenser.c1.dispense(new Currency(amount));
        }

    }

}