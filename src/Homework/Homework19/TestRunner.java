package Homework19;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test {
    int priority() default 5;
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BeforeSuite {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface AfterSuite {
}

class TestRunner {
    public static void start(Class<?> testClass) {
        try {
            Object testObject = testClass.getDeclaredConstructor().newInstance();
            runTests(testObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void runTests(Object testObject) throws Exception {
        int beforeSuiteCount = 0;
        int afterSuiteCount = 0;
        int testCount = 0;

        // Get all methods in the class
        var methods = testObject.getClass().getDeclaredMethods();

        for (var method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                beforeSuiteCount++;
                if (beforeSuiteCount > 1) {
                    throw new RuntimeException("More than one @BeforeSuite method found");
                }
                method.invoke(testObject);
            } else if (method.isAnnotationPresent(AfterSuite.class)) {
                afterSuiteCount++;
                if (afterSuiteCount > 1) {
                    throw new RuntimeException("More than one @AfterSuite method found");
                }
            } else if (method.isAnnotationPresent(Test.class)) {
                testCount++;
            }
        }

        // Run methods with @Test annotation based on priority
        for (int priority = 1; priority <= 10; priority++) {
            for (var method : methods) {
                if (method.isAnnotationPresent(Test.class) && method.getAnnotation(Test.class).priority() == priority) {
                    method.invoke(testObject);
                }
            }
        }

        if (beforeSuiteCount == 0) {
            throw new RuntimeException("No @BeforeSuite method found");
        }

        if (afterSuiteCount == 0) {
            throw new RuntimeException("No @AfterSuite method found");
        }

        System.out.println("Total test methods executed: " + testCount);
    }
}
