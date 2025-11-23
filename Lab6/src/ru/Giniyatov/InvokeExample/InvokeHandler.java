package ru.Giniyatov.InvokeExample;

import ru.Giniyatov.annotations.Invoke;

import java.lang.reflect.Method;

/**
 * Обработчик для автоматического вызова методов, помеченных аннотацией @Invoke.
 */
public class InvokeHandler {

    /**
     * Находит и вызывает все методы, помеченные аннотацией @Invoke, в указанном объекте.
     *
     * @param obj объект, методы которого нужно вызвать
     * @throws Exception если произошла ошибка при вызове метода
     */
    public static void invokeAnnotatedMethods(Object obj) throws Exception {
        if (obj == null) {
            throw new IllegalArgumentException("Объект не может быть null");
        }

        Class<?> clazz = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Invoke.class)) {

                method.setAccessible(true);

                method.invoke(obj);
            }
        }
    }
}

