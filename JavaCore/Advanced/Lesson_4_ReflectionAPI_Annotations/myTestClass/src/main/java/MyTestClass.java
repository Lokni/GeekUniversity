import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class MyTestClass {
    private static Method methodBefore;
    private static Method methodAfter;
    private static HashMap<Method, Integer> classMethodsHM = new HashMap<>();

    public static void start(Class testClass) {
        methodCollection(testClass);
        testProcessing(testClass);

    }

    private static void methodCollection(Class testClass) {
        System.out.println("Full name of the testing class: " + testClass.getName());
        List<Method> beforeSuiteList = new LinkedList<>();
        List<Method> afterSuiteList = new LinkedList<>();
        Method[] methods = testClass.getDeclaredMethods();

        for (Method m : methods) {
            m.setAccessible(true);
            if (m.getAnnotation(BeforeSuite.class) != null) {
                beforeSuiteList.add(m);
            } else if (m.getAnnotation(AfterSuite.class) != null) {
                afterSuiteList.add(m);
            } else if (m.getAnnotation(Test.class) != null) {
                classMethodsHM.put(m, m.getAnnotation(Test.class).priority());
            }
        }
        if (beforeSuiteList.size() > 1 || afterSuiteList.size() > 1) {
            throw new RuntimeException();
        } else {
            methodBefore = beforeSuiteList.get(0);
            methodAfter = afterSuiteList.get(0);
        }
    }

    public static void testProcessing(Class testClass) {
        int i = 10;
        float fl = (float) i;
        char ch = 'i';
        String str = "i";
        boolean bool = true;

        try {
            Object testInstance = testClass.newInstance();
            methodBefore.invoke(testInstance);
            classMethodsHM.entrySet().stream().sorted(
                    Map.Entry.<Method, Integer>comparingByValue().reversed()
            ).forEach(methodIntegerEntry -> {
                Class[] type = methodIntegerEntry.getKey().getParameterTypes();

                System.out.printf("Priority: %d\nAction: ",
                        methodIntegerEntry.getKey().getAnnotation(Test.class).priority());

                try {
                    if (type[0] == int.class) {
                        methodIntegerEntry.getKey().invoke(testInstance, i);
                    }
                    if (type[0] == double.class) {
                        methodIntegerEntry.getKey().invoke(testInstance, i);
                    }
                    if (type[0] == float.class) {
                        methodIntegerEntry.getKey().invoke(testInstance, fl);
                    }
                    if (type[0] == char.class) {
                        methodIntegerEntry.getKey().invoke(testInstance, ch);
                    }
                    if (type[0] == String.class) {
                        methodIntegerEntry.getKey().invoke(testInstance, str);
                    }
                    if (type[0] == boolean.class) {
                        methodIntegerEntry.getKey().invoke(testInstance, true);
                    }

                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            });
            methodAfter.invoke(testInstance);

        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }

    }

    public static void start(String className) {
        try {
            start(Class.forName(className));
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage() + " Class not found.");
        }
    }

}
