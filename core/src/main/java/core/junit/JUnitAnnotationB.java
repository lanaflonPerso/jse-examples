package core.junit;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class JUnitAnnotationB {
    private List<String> arrayList;

    @BeforeClass
    public static void initClass() {
        System.out.println("@BeforeClass - initClass");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("@AfterClass - afterClass");
    }

    @Before
    public void initTest() {
        arrayList = new ArrayList<String>();
        System.out.println("@Before - initTest");
    }

    @Test(expected = ArithmeticException.class)
    public void testException() {
        int i = 1 / 0;
    }

    @Ignore("testSkip() - Not Ready to Run")
    @Test
    public void testSkip() {
        System.out.println("Method is not ready yet");
    }

    @Test(timeout = 1000)
    public void infinity() {
        while (true) {
            System.out.println("TimeOut Test");
            ;
        }
    }

    @After
    public void cleanTest() {
        System.out.println("@After - cleanTest");
    }
}
