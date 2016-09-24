package core.designpattern.structural.composite;

/*
 * http://www.javaworld.com/article/2074564/learn-java/a-look-at-the-composite-design-pattern.html
 */
public class CompositeMain {
    public static void main(String...args) {
        Shape triangle = new Triangle();
        Shape triangle2 = new Triangle();
        Shape circle = new Circle();

        Drawing drawing = new Drawing();
        drawing.add(triangle2);
        drawing.add(triangle2);
        drawing.add(circle);
        drawing.draw("Red");

        drawing.clear();

        drawing.add(triangle);
        drawing.add(circle);
        drawing.draw("Green");
    }
}
