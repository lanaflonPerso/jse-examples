package core.java8.staticdefaultfi;

/**
 * static method inside interface in java 8
 */
public interface DiamondProblemInterface {
    static DiamondProblemInterface getInstance(){
        return new DiamondOperator();
    }
}
