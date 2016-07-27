package core.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class JUnitAnnotationA {
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

    @Test
    public void testNullArrayList() {
        assertFalse("Pass", arrayList == null);
        System.out.println("@Test - testNullArrayList");
    }

    @Test
    public void testEmptyArrayList() {
        assertTrue("Pass", arrayList.isEmpty());
        System.out.println("@Test - testEmptyArrayList");
    }

    @Test
    public void testAddArrayList() {
        arrayList.add("Himansu");
        assertEquals("Pass", 1, arrayList.size());
        System.out.println("@Test - testAddArrayList");
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

    @Ignore()
    @Test(timeout = 1)
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
