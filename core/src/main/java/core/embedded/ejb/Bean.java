package core.embedded.ejb;

import javax.ejb.Stateless;

@Stateless
public class Bean {
    public String hello(String name) {
        return "Hello, " + name;
    }
}