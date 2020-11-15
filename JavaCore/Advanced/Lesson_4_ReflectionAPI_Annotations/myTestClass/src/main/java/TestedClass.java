public class TestedClass {
    String message = "Simple method with ";

    @Test(priority = 9)
    public void methodInt(int x) {
        System.out.println(message + "int " + x);
    }

    @Test(priority = 1)
    public void methodBoolean(boolean x) {
        System.out.println(message + "boolean " + x);
    }

    @Test
    public void methodDouble(double x) {
        System.out.println(message + "double " + x);
    }

    @Test(priority = 10)
    public void methodFloat(float x) {
        System.out.println(message + "float " + x);
    }

    @Test(priority = 4)
    public void methodChar(char x) {
        System.out.println(message + "char " + x);
    }

    @Test(priority = 10)
    public void methodString(String x) {
        System.out.println(message + "String " + x);
    }

    @BeforeSuite
    public void methodBegin() {
        System.out.println("\nBegin our class methods\n");
    }

    @AfterSuite
    public void methodEnd() {
        System.out.println("\nEnd our class methods");
    }

}
