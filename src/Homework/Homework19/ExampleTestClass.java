package Homework19;
class ExampleTestClass {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("BeforeSuite method executed");
    }

    @Test(priority = 5)
    public void testMethod1() {
        System.out.println("Test method 1 executed");
    }

    @Test(priority = 1)
    public void testMethod2() {
        System.out.println("Test method 2 executed");
    }

    @Test(priority = 3)
    public void testMethod3() {
        System.out.println("Test method 3 executed");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("AfterSuite method executed");
    }
}