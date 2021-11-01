package quarter01.level03.lesson07;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Tester {
    public static void start(Class testClass) {
        List<Method> methods = new ArrayList<>();
        Method[] classMethods = testClass.getDeclaredMethods();

        for (Method method : classMethods) {
            if (method.isAnnotationPresent(Test.class)) {
                methods.add(method);
            }
        }

        methods.sort(Comparator
                .comparingInt((Method m) -> m.getAnnotation(Test.class).priority())
                .reversed());

        for (Method method : classMethods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (methods.size() > 0 && methods.get(0).isAnnotationPresent(BeforeSuite.class)) {
                    throw new RuntimeException("@BeforeSuite annotation method > 1");
                }
                methods.add(0, method);
            }
        }

        for (Method method : classMethods) {
            if (method.isAnnotationPresent(AfterSuite.class)) {
                if (methods.size() > 0 && methods.get(methods.size() - 1).isAnnotationPresent(AfterSuite.class)) {
                    throw new RuntimeException("@AfterSuite annotation method > 1");
                }
                methods.add(method);
            }
        }

        for (Method method : methods) {
            try {
                method.invoke(null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
