package core.serviceloader;

import java.util.ServiceLoader;

import com.org.serviceloader.Greeting;

public class GreetingServiceLoader {

    public static final Greeting myService = loadService(Greeting.class);

    public static <T> T loadService(Class<T> api) {
        T result = null;
        ServiceLoader<T> services = ServiceLoader.load(api);

        for (T service : services) {
            result = service;
            if (result != null)
                break;
        }

        if (result == null) {
            throw new RuntimeException("Cannot find implementation for: " + api);
        }
        return result;

    }

    public static void main(String...args) {

        System.out.println(myService.greeting());

    }
}
