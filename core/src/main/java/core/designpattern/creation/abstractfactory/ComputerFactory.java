package core.designpattern.creation.abstractfactory;

public class ComputerFactory {

    // Factory dont need to be initialized
    public static Computer getComputer(ComputerAbstractFactory factory) {
        return factory.createComputer();
    }
}