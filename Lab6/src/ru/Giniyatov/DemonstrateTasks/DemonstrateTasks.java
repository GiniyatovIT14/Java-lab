package ru.Giniyatov.DemonstrateTasks;

import ru.Giniyatov.InvokeExample.*;
import ru.Giniyatov.DefaultExample.*;
import ru.Giniyatov.ToStringExample.*;
import ru.Giniyatov.ValidateExample.*;
import ru.Giniyatov.TwoExample.*;
import ru.Giniyatov.CacheExample.*;

/**
 * Класс для демонстрации работы всех заданий с готовыми данными.
 */
public class DemonstrateTasks {

    /**
     * Демонстрация задания 1: аннотация @Invoke.
     */
    public static void demonstrateTask1() {
        System.out.println("=== ДЕМОНСТРАЦИЯ ЗАДАНИЯ 1: @Invoke ===");
        System.out.println();

        System.out.println("1. СОЗДАНИЕ ТЕСТОВОГО КЛАССА:");
        System.out.println("-------------------------------");
        TestClass testObj = new TestClass();
        System.out.println("Создан объект TestClass");
        System.out.println("Состояние до вызова:");
        System.out.println("  • method1Called: " + testObj.isMethod1Called());
        System.out.println("  • method2Called: " + testObj.isMethod2Called());
        System.out.println("  • method3Called: " + testObj.isMethod3Called());
        System.out.println();

        System.out.println("2. АВТОМАТИЧЕСКИЙ ВЫЗОВ МЕТОДОВ С @Invoke:");
        System.out.println("-------------------------------------------");
        try {
            InvokeHandler.invokeAnnotatedMethods(testObj);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println();

        System.out.println("3. СОСТОЯНИЕ ПОСЛЕ ВЫЗОВА:");
        System.out.println("------------------------");
        System.out.println("  • method1Called: " + testObj.isMethod1Called() + " (должно быть true)");
        System.out.println("  • method2Called: " + testObj.isMethod2Called() + " (должно быть false - нет аннотации)");
        System.out.println("  • method3Called: " + testObj.isMethod3Called() + " (должно быть true)");
        System.out.println();

        System.out.println("=== ДЕМОНСТРАЦИЯ ЗАВЕРШЕНА ===");
        System.out.println();
    }

    /**
     * Демонстрация задания 2: аннотация @Default.
     */
    public static void demonstrateTask2() {
        System.out.println("=== ДЕМОНСТРАЦИЯ ЗАДАНИЯ 2: @Default ===");
        System.out.println();

        System.out.println("1. ПРОВЕРКА АННОТАЦИИ НА КЛАССЕ:");
        System.out.println("--------------------------------");
        String className = DefaultHandler.getDefaultClassName(DefaultClass.class);
        if (className != null) {
            System.out.println("Класс по умолчанию: " + className);
        } else {
            System.out.println("Аннотация @Default не найдена");
        }
        System.out.println();

        System.out.println("2. ПРОВЕРКА АННОТАЦИИ НА ПОЛЕ:");
        System.out.println("------------------------------");
        try {
            java.lang.reflect.Field field = DefaultClass.class.getDeclaredField("field1");
            String fieldClassName = DefaultHandler.getDefaultClassName(field);
            if (fieldClassName != null) {
                System.out.println("Класс по умолчанию для field1: " + fieldClassName);
            }
        } catch (NoSuchFieldException e) {
            System.out.println("Поле не найдено: " + e.getMessage());
        }
        System.out.println();

        System.out.println("=== ДЕМОНСТРАЦИЯ ЗАВЕРШЕНА ===");
        System.out.println();
    }

    /**
     * Демонстрация задания 3: аннотация @ToString.
     */
    public static void demonstrateTask3() {
        System.out.println("=== ДЕМОНСТРАЦИЯ ЗАДАНИЯ 3: @ToString ===");
        System.out.println();

        System.out.println("1. СОЗДАНИЕ ОБЪЕКТА:");
        System.out.println("--------------------");
        ToStringClass obj = new ToStringClass("Иван", 25, "secret123", "ivan@example.com");
        System.out.println("Создан объект с полями:");
        System.out.println("  • name: " + obj.getName());
        System.out.println("  • age: " + obj.getAge());
        System.out.println("  • password: " + obj.getPassword() + " (помечено @ToString(Mode.NO))");
        System.out.println("  • email: " + obj.getEmail());
        System.out.println();

        System.out.println("2. ФОРМИРОВАНИЕ СТРОКОВОГО ПРЕДСТАВЛЕНИЯ:");
        System.out.println("-----------------------------------------");
        String result = ToStringHandler.toString(obj);
        System.out.println("Результат: " + result);
        System.out.println();
        System.out.println("Проверка:");
        System.out.println("  ✓ name включен (по умолчанию YES)");
        System.out.println("  ✓ age включен (по умолчанию YES)");
        System.out.println("  ✗ password НЕ включен (@ToString(Mode.NO))");
        System.out.println("  ✓ email включен (по умолчанию YES)");
        System.out.println();

        System.out.println("=== ДЕМОНСТРАЦИЯ ЗАВЕРШЕНА ===");
        System.out.println();
    }

    /**
     * Демонстрация задания 4: аннотация @Validate.
     */
    public static void demonstrateTask4() {
        System.out.println("=== ДЕМОНСТРАЦИЯ ЗАДАНИЯ 4: @Validate ===");
        System.out.println();

        System.out.println("1. ПРОВЕРКА АННОТАЦИИ НА КЛАССЕ:");
        System.out.println("--------------------------------");
        Class<?>[] classes = ValidateHandler.getValidationClasses(ValidatedClass.class);
        if (classes != null) {
            System.out.println("Классы для валидации:");
            for (int i = 0; i < classes.length; i++) {
                System.out.println("  " + (i + 1) + ". " + classes[i].getName());
            }
        }
        System.out.println();

        System.out.println("2. ВЫВОД ИМЕН КЛАССОВ:");
        System.out.println("---------------------");
        String classNames = ValidateHandler.getValidationClassNames(ValidatedClass.class);
        System.out.println(classNames);
        System.out.println();

        System.out.println("=== ДЕМОНСТРАЦИЯ ЗАВЕРШЕНА ===");
        System.out.println();
    }

    /**
     * Демонстрация задания 5: аннотация @Two.
     */
    public static void demonstrateTask5() {
        System.out.println("=== ДЕМОНСТРАЦИЯ ЗАДАНИЯ 5: @Two ===");
        System.out.println();

        System.out.println("1. СЧИТЫВАНИЕ СВОЙСТВ АННОТАЦИИ:");
        System.out.println("--------------------------------");
        String properties = TwoHandler.getTwoProperties(TwoClass.class);
        if (properties != null) {
            System.out.println("Свойства аннотации @Two:");
            System.out.println("  " + properties);
        } else {
            System.out.println("Аннотация @Two не найдена");
        }
        System.out.println();

        System.out.println("2. ПОЛУЧЕНИЕ ОТДЕЛЬНЫХ СВОЙСТВ:");
        System.out.println("-------------------------------");
        String first = TwoHandler.getFirst(TwoClass.class);
        int second = TwoHandler.getSecond(TwoClass.class);
        System.out.println("  • first: " + first);
        System.out.println("  • second: " + second);
        System.out.println();

        System.out.println("=== ДЕМОНСТРАЦИЯ ЗАВЕРШЕНА ===");
        System.out.println();
    }

    /**
     * Демонстрация задания 6: аннотация @Cache.
     */
    public static void demonstrateTask6() {
        System.out.println("=== ДЕМОНСТРАЦИЯ ЗАДАНИЯ 6: @Cache ===");
        System.out.println();

        System.out.println("1. КЛАСС С КЕШИРУЕМЫМИ ОБЛАСТЯМИ:");
        System.out.println("----------------------------------");
        String[] cacheAreas = CacheHandler.getCacheAreas(CachedClass.class);
        if (cacheAreas != null && cacheAreas.length > 0) {
            System.out.println("Кешируемые области:");
            for (int i = 0; i < cacheAreas.length; i++) {
                System.out.println("  " + (i + 1) + ". " + cacheAreas[i]);
            }
        } else {
            System.out.println("Список кешируемых областей пуст");
        }
        System.out.println();

        System.out.println("2. ИНФОРМАЦИЯ О КЕШЕ:");
        System.out.println("---------------------");
        String cacheInfo = CacheHandler.getCacheInfo(CachedClass.class);
        System.out.println(cacheInfo);
        System.out.println();

        System.out.println("3. КЛАСС С ПУСТЫМ МАССИВОМ:");
        System.out.println("--------------------------");
        String emptyCacheInfo = CacheHandler.getCacheInfo(EmptyCacheClass.class);
        System.out.println(emptyCacheInfo);
        System.out.println();

        System.out.println("=== ДЕМОНСТРАЦИЯ ЗАВЕРШЕНА ===");
        System.out.println();
    }
}

