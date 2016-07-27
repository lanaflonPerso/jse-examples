package core.annotation;

import java.lang.reflect.Method;

public class CustomAnnotationParser {
    public void parse(Class<?> clazz) throws Exception {
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Annotated.class)) {
                Annotated test = method.getAnnotation(Annotated.class);
                String defaultValue = test.name();
                if ("Himansu".equals(defaultValue)) {
                    System.out.println("method is annoted... lets call the method");
                    method.invoke(AnnotatedImpl.class.newInstance(), defaultValue);
                }
            }
        }
    }
}
