package core.log4j;

import org.apache.log4j.Logger;

import core.pojo.CtumFileCollectionConfig;

public class HelloExample {

    final static Logger logger = Logger.getLogger(CtumFileCollectionConfig.class);

    public static void main(String...args) {

        CtumFileCollectionConfig ctumFileCollectionConfig = new CtumFileCollectionConfig();
        if (logger.isDebugEnabled()) {
            logger.debug("This is debug : " + ctumFileCollectionConfig);
        }

        if (logger.isInfoEnabled()) {
            logger.info("This is info : " + ctumFileCollectionConfig);
        }
        logger.warn("This is warn : " + ctumFileCollectionConfig);
        logger.error("This is error : " + ctumFileCollectionConfig);
        logger.fatal("This is fatal : " + ctumFileCollectionConfig);
    }

}