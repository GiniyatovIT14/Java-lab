package ru.Giniyatov.InvokeExample;

import ru.Giniyatov.annotations.Invoke;

/**
 * Тестовый класс для демонстрации работы аннотации @Invoke.
 */
public class TestClass {
    private boolean method1Called = false;
    private boolean method2Called = false;
    private boolean method3Called = false;

    /**
     * Метод, помеченный аннотацией @Invoke - будет вызван автоматически.
     */
    @Invoke
    public void method1() {
        method1Called = true;
        System.out.println("Метод method1() вызван!");
    }

    /**
     * Обычный метод без аннотации - не будет вызван автоматически.
     */
    public void method2() {
        method2Called = true;
        System.out.println("Метод method2() вызван (без аннотации)");
    }

    /**
     * Еще один метод с аннотацией @Invoke.
     */
    @Invoke
    private void method3() {
        method3Called = true;
        System.out.println("Метод method3() вызван (приватный)!");
    }

    /**
     * Проверка, был ли вызван method1.
     *
     * @return true, если method1 был вызван
     */
    public boolean isMethod1Called() {
        return method1Called;
    }

    /**
     * Проверка, был ли вызван method2.
     *
     * @return true, если method2 был вызван
     */
    public boolean isMethod2Called() {
        return method2Called;
    }

    /**
     * Проверка, был ли вызван method3.
     *
     * @return true, если method3 был вызван
     */
    public boolean isMethod3Called() {
        return method3Called;
    }

    /**
     * Сброс состояния всех флагов.
     */
    public void reset() {
        method1Called = false;
        method2Called = false;
        method3Called = false;
    }
}

