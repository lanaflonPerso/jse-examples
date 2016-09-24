package core.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ehimnay on 01/12/2015.
 */
public class GenericMethodMain {
    public static void main(String...args) throws InstantiationException, IllegalAccessException {

        String string = genericMethod(String.class);

        List<?> unknowObjects = new ArrayList<String>() {
            {
                add("Himansu");
            }
        };
        unknowGeneric(unknowObjects);
        unknowObjects = new ArrayList<Integer>() {
            {
                add(1);
            }
        };
        unknowGeneric(unknowObjects);
    }

    /**
     * Generic Method - Return
     * 
     * @param <T>
     * @return
     */
    public static <T> T genericReturnMethod() {
        T object = (T) new String();
        return object;
    }

    /**
     * Generic Method - Argument
     */
    public static <T> void genericArgument(Class<T> clazz) {
    }

    /**
     * Generic Method - Argument and Return type
     */
    public static <T> T genericMethod(Class<T> theClass) throws IllegalAccessException, InstantiationException {
        return theClass.newInstance();
    }

    /**
     * wildcard
     */
    public static void unknowGeneric(List<?> unknowObjects) {
        for (Object obj : unknowObjects) {
            System.out.println("obj = " + obj);
        }
    }

    /**
     * lower bound
     */
    public static void extendsBoundaryGeneric(List<? extends String> unknowObjects) {
        for (String str : unknowObjects) {
            System.out.println("str = " + str);
        }
    }

    /**
     * upper bound
     */
    public static void superBoundaryGeneric(List<? super String> unknowObjects) {
        for (Object obj : unknowObjects) {
            System.out.println("obj = " + obj);
        }
    }

}