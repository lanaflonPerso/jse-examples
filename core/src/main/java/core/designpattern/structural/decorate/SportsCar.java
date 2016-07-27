package core.designpattern.structural.decorate;

public class SportsCar extends CarDecorator {

    public SportsCar(Car c) {
        super(c);
    }

    @Override
    public void assemble() {
        car.assemble();
        System.out.print(" Adding new features of Sports Car.");
    }
}