import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanUtils {
    /**
     *      * Scans object "from" for all getters. If object "to"
     *      * contains correspondent setter, it will invoke it
     *      * to set property value for "to" which equals to the property
     *      * of "from".
     *      * <p/>
     *      * The type in setter should be compatible to the value returned
     *      * by getter (if not, no invocation performed).
     *      * Compatible means that parameter type in setter should
     *      * be the same or be superclass of the return type of the getter.
     *      * <p/>
     *      * The method takes care only about public methods.
     *      *
     *      * @param to   Object which properties will be set.
     *      * @param from Object which properties will be used to get values.
     *      
     */

    public static void assign(Object to, Object from)  {

        Class classFrom = from.getClass();
        Class classTo = to.getClass();

        //получаем все public методы
        for (Method getMethod : classFrom.getMethods()) {

            if (getMethod.getName().startsWith("get")) { //Это getter
                System.out.println("\nНайден getter " + getMethod);

                //Генерируем имя сеттера-получателя
                String setterName = getMethod.getName().replace("get", "set");
                System.out.println("Поиск сеттера: " + setterName);

                //Ищем сеттер
                for (Method setMethod : classTo.getMethods()) {
                    if (setMethod.getName().equals(setterName)) { //Нашли нужное имя

                        if (getMethod.getReturnType().isAssignableFrom(setMethod.getParameterTypes()[0])) {
                            System.out.println("Найден сеттер: " + setMethod);

                            try {
                                setMethod.invoke(to, getMethod.invoke(from));
                                System.out.println("Значение установлено.");
                            } catch (IllegalAccessException e) {
                                System.out.println("Нет доступа к методу " + getMethod);
                            } catch (InvocationTargetException e) {
                                System.out.println("Возникли пробелемы с вызовом метода " + getMethod);
                            }
                        }
                    }
                }
            }
        }
    }
}


