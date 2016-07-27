package core.designpattern.structural.decorate;

public class LuxuryCar extends CarDecorator {

    public LuxuryCar(Car car) {
        super(car);
    }

    @Override
    public void assemble() {
        car.assemble();
        System.out.print(" Adding new fetures of Luxary Car");
    }
}