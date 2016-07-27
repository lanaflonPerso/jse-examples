/*
 * package com.core.ejb;
 * 
 * import java.util.Properties;
 * 
 * import javax.naming.*;
 * 
 * public class JNDILookup { private static PaymentContext initialContext;
 * 
 * private static final String PKG_INTERFACES = "org.jboss.ejb.client.naming";
 * 
 * public static Object contextLookup() { PaymentContext context = null; Object object = null; try { context =
 * getInitialContext(); String lookupName = getLookupName(); object = context.lookup(lookupName); } catch
 * (NamingException e) { e.printStackTrace(); } return object; }
 * 
 * private static PaymentContext getInitialContext() throws NamingException { if (initialContext == null) { Properties
 * properties = new Properties(); properties.put(PaymentContext.URL_PKG_PREFIXES, PKG_INTERFACES); initialContext = new
 * InitialContext(properties); } return initialContext; }
 * 
 * private static String getLookupName() {
 * 
 * The app name is the EAR name of the deployed EJB without .ear suffix. Since we haven't deployed the application as a
 * .ear, the app name for us will be an empty string
 * 
 * String appName = "";
 * 
 * 
 * The module name is the JAR name of the deployed EJB without the .jar suffix.
 * 
 * String moduleName = "applicationLayer";
 * 
 * 
 * AS7 allows each deployment to have an (optional) distinct name. This can be an empty string if distinct name is not
 * specified.
 * 
 * String distinctName = "";
 * 
 * // The EJB bean implementation class name String beanName = HelloWorldSessionBean.class.getSimpleName();
 * 
 * // Fully qualified remote interface name final String interfaceName = HelloWorldSessionBean.class.getName();
 * 
 * // Create a look up string name String name = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" +
 * beanName + "!" + interfaceName;
 * 
 * return name; } }
 */