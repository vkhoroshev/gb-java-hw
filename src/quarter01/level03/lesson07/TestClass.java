package quarter01.level03.lesson07;

public class TestClass {

    @BeforeSuite
    public static void testMethod3() {
        System.out.println("Method 3 : @BeforeSuite");
    }

    @Test(priority = 5)
    public static void testMethod1() {
        System.out.println("Method 1 : priority = 5");
    }

    @Test
    public static void testMethod2() {
        System.out.println("Method 2");
    }

    @Test(priority = 3)
    public static void testMethod4() {
        System.out.println("Method 4 : priority = 3");
    }

    @Test(priority = 8)
    public static void testMethod5() {
        System.out.println("Method 5 : priority = 8");
    }

    @Test
    public static void testMethod6() {
        System.out.println("Method 6");
    }

    @AfterSuite
    public static void testMethod7() {
        System.out.println("Method 7 : @AfterSuite");
    }
}
