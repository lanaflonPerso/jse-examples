package core.designpattern.structural.bridge;

public class BridgePatternMain {
    public static void main(String...args) {
        Shape tri = new Triangle(new RedColor());
        tri.applyColor();

        Shape pent = new Pentagon(new GreenColor());
        pent.applyColor();
    }
}
