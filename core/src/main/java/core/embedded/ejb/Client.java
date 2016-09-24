package core.embedded.ejb;

import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

public class Client {
    public static void main(String...args) throws NamingException {
        EJBContainer container = null;
        try {
            final Properties props = new Properties();
            props.setProperty(EJBContainer.PROVIDER, "tomee-embedded");
            container = EJBContainer.createEJBContainer(props);
            Context namingContext = container.getContext();
            Bean testBean = (Bean) namingContext.lookup("java:global/com.core.embedded.ejb/Bean");
            String hi = testBean.hello("client");
            System.out.println("testBean.hello method returned: " + hi);
        } finally {
            if (container != null) {
                container.close();
            }
        }
    }
}