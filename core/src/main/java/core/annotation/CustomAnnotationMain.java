package core.annotation;

public class CustomAnnotationMain {

    /**
     * @param args
     */
    public static void main(String...args) throws Exception {
        CustomAnnotationParser parser = new CustomAnnotationParser();
        parser.parse(AnnotatedImpl.class);
    }
}