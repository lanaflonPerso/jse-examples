package core.loader;

import java.util.ServiceLoader;

public class ServiceLoaderMain {

    /**
     * @param args
     */
    public static void main(String... main) {
        ServiceLoader<CPU> serviceLoader = ServiceLoader.load(CPU.class);
        for (CPU type : serviceLoader) {
            type.show();
        }
        System.out.println("Hi");
    }

}
