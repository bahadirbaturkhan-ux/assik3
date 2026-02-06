package utils;

import java.lang.reflect.Method;

public class ReflectionUtils {

    public static void inspect(Object obj) {
        Class<?> c = obj.getClass();
        System.out.println("Class: " + c.getName());

        for (Method m : c.getDeclaredMethods()) {
            System.out.println("Method: " + m.getName());
        }
    }
}
