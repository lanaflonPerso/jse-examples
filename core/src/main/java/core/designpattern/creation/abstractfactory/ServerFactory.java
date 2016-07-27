package core.designpattern.creation.abstractfactory;

public class ServerFactory implements ComputerAbstractFactory {

    private String ram;
    private String hdd;
    private String cpu;

    // factory need to initialized from the super factory
    public ServerFactory(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override
    public Computer createComputer() {
        return new Server(ram, hdd, cpu);
    }

}