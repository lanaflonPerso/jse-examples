package core.testng;

import org.testng.annotations.*;

/*
 * any annotation can be repeated more than once
 */
public abstract class LifeCycle {
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("before method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("after method");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("before class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("after class");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("before test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("after test");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("before suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("after suite");
    }

}
