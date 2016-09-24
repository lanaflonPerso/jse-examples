package core.classloader;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaderTypeTest {
    public static void main(String...args) throws Exception {
        urlClassLoader();
        systemClassLoader();
    }

    public static void urlClassLoader() throws MalformedURLException, ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        // Getting the jar URL which contains target class
        URL[] classLoaderUrls = new URL[] {
                new URL("file:///C://Mercury/github/jse-examples/target/jse-examples-0.0.1-SNAPSHOT.jar") };

        // Create a new URLClassLoader
        URLClassLoader urlClassLoader = new URLClassLoader(classLoaderUrls);

        // Load the target class
        Class<?> beanClass = urlClassLoader.loadClass("ClassLoaderTypeTest");

        // Create a new instance from the loaded class
        Constructor<?> constructor = beanClass.getConstructor();
        Object obj = constructor.newInstance();

        // Getting a method from the loaded class and invoke it
        Method method = beanClass.getMethod("helloWorld");
        Method privateMethod = beanClass.getDeclaredMethod("goodByeWorld");

        // make this for calling private method
        privateMethod.setAccessible(true);

        method.invoke(obj);
        privateMethod.invoke(obj);
    }

    public static void systemClassLoader()
            throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class classObject = ClassLoader.getSystemClassLoader().loadClass("ClassLoaderTypeTest");
        ClassLoaderTypeTest object = (ClassLoaderTypeTest) classObject.newInstance();
        object.helloWorld();
    }

    public static ClassLoader getClassLoaderFromThreadContext() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return classLoader;
    }

    public ClassLoader getClassLoader() {
        return ClassLoader.class.getClassLoader();
    }

    public ClassLoader getClassLoaderFromCurrentClass() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        return classLoader;
    }

    public void helloWorld() {
        System.out.println("Hello World");
    }

    private void goodByeWorld() {
        System.out.println("goodByeWorld");
    }
}
