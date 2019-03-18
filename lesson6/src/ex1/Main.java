package ex1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("testName", 30);

        Class c = person.getClass();
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println();

        System.out.println();
        c = c.getSuperclass();
        Method[] supMethods = c.getDeclaredMethods();
        for (Method method : supMethods) {
            System.out.println(method);
        }
        System.out.println();

        for (Method method : methods) {
            if (method.getName().startsWith("get")) {
                System.out.println(method);
            }
        }
        System.out.println();

        System.out.println(isValid(Person.class));
    }

    public static boolean isValid(Class clazz) {
        //Проверить что все String константы имеют значение = их имени
        final boolean[] result = new boolean[]{true};

        for (Field field : clazz.getDeclaredFields()) {
            int modifiers = field.getModifiers();
            if (Modifier.isFinal(modifiers) && Modifier.isStatic(modifiers) && field.getType().equals(String.class)) {

                try {
                    if (!field.getName().equals(field.get(clazz).toString())) {

                        System.out.println("Поле " + field.getName() + " имеет значение " + field.get(clazz).toString());
                        result[0] = false;
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }


            }
        }

        return result[0];
    }
}