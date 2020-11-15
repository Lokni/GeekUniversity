 Create a class that can run "tests".
 Classes with sets of methods with @Test annotations are used as tests.
 To do this, it must have a static method start (),
 to which either an object of type Class or a class name is passed as a parameter.
 A method with the @BeforeSuite annotation, if any, must be launched from the "test class" first.
 Next, methods with @Test annotations are launched,
 and upon completion of all tests - a method with @AfterSuite annotation.
 Priorities must be added to each test (int numbers from 1 to 10),
 according to which the order of their execution will be selected.
 If the priority is the same, then the order does not matter.
 Methods with @BeforeSuite and @AfterSuite annotations must be present in a single instance,
 otherwise, a RuntimeException must be thrown when the "test" starts.