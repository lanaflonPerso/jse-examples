package core.testng;

import static org.junit.Assert.assertEquals;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class UnitTest {
    @Test()
    public void function() {
        Assertion softAssert = new SoftAssert();
        System.out.println("Inside function Test Method");
        softAssert.assertEquals("Hi", "HI");
        assertEquals("Hi", "Hi");
    }

    @Test(enabled = true)
    public void function2() {
        System.out.println("Inside function 2 Test Method");
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testException() {
        int i = 2 / 0;
    }

}
