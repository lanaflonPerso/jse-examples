package core.slf4jlog4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.pojo.CtumFileCollectionConfig;

public class HelloExample {
    private static Logger slf4jLogger = LoggerFactory.getLogger(CtumFileCollectionConfig.class);

    /**
     * @param args
     */
    public static void main(String...args) {
        CtumFileCollectionConfig ctumFileCollectionConfig = new CtumFileCollectionConfig();
        slf4jLogger.info("Welcome to the HelloWorld example of Log4j using SLF4J");
        slf4jLogger.info("HeloWorld {}", ctumFileCollectionConfig);
    }
}