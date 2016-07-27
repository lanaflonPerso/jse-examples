package core.designpattern.creation.prototype;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PrototypeTest {

    @Test
    public void prototypeTest() {
        PrototypeFactory pf = new PrototypeFactory();
        assertEquals(new Flowers(), pf.getInstance(Constant.FLOWERS));
    }

}
