package ru.Giniyatov.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import ru.Giniyatov.InvokeExample.InvokeHandler;
import ru.Giniyatov.InvokeExample.TestClass;
import ru.Giniyatov.annotations.Invoke;

import java.lang.reflect.Method;

/**
 * Тесты для проверки корректности вызова методов, отмеченных аннотацией @Invoke.
 */
public class InvokeTest {

    private TestClass testObject;

    /**
     * Подготовка тестируемого экземпляра класса перед каждым тестом.
     */
    @BeforeEach
    public void setUp() {
        testObject = new TestClass();
    }

    /**
     * Проверка, что методы с аннотацией @Invoke находятся через Reflection API.
     */
    @Test
    public void testFindAnnotatedMethods() {
        Class<?> clazz = TestClass.class;
        Method[] methods = clazz.getDeclaredMethods();
        
        int annotatedMethodsCount = 0;
        for (Method method : methods) {
            if (method.isAnnotationPresent(Invoke.class)) {
                annotatedMethodsCount++;
            }
        }
        
        assertEquals(2, annotatedMethodsCount, 
                "Должно быть найдено 2 метода с аннотацией @Invoke");
    }

    /**
     * Проверка, что метод действительно выполняется без исключений.
     */
    @Test
    public void testMethodExecutesWithoutException() {
        assertDoesNotThrow(() -> {
            InvokeHandler.invokeAnnotatedMethods(testObject);
        }, "Методы должны вызываться без исключений");
    }

    /**
     * Проверка, что методы с аннотацией @Invoke действительно вызываются.
     */
    @Test
    public void testAnnotatedMethodsAreInvoked() throws Exception {
        testObject.reset();
        
        // Проверяем, что методы еще не вызваны
        assertFalse(testObject.isMethod1Called(), "method1 не должен быть вызван до обработки");
        assertFalse(testObject.isMethod3Called(), "method3 не должен быть вызван до обработки");
        
        // Вызываем обработчик
        InvokeHandler.invokeAnnotatedMethods(testObject);
        
        // Проверяем, что методы с аннотацией были вызваны
        assertTrue(testObject.isMethod1Called(), "method1 должен быть вызван");
        assertTrue(testObject.isMethod3Called(), "method3 должен быть вызван");
    }

    /**
     * Проверка, что метод без аннотации не вызывается.
     */
    @Test
    public void testNonAnnotatedMethodNotInvoked() throws Exception {
        testObject.reset();
        
        InvokeHandler.invokeAnnotatedMethods(testObject);
        
        // Метод без аннотации не должен быть вызван
        assertFalse(testObject.isMethod2Called(), 
                "method2 без аннотации не должен быть вызван");
    }

    /**
     * Проверка побочного эффекта - установка флагов.
     */
    @Test
    public void testSideEffect() throws Exception {
        testObject.reset();
        
        // До вызова все флаги должны быть false
        assertFalse(testObject.isMethod1Called());
        assertFalse(testObject.isMethod3Called());
        
        InvokeHandler.invokeAnnotatedMethods(testObject);
        
        // После вызова флаги должны быть true
        assertTrue(testObject.isMethod1Called(), 
                "Флаг method1Called должен быть установлен в true");
        assertTrue(testObject.isMethod3Called(), 
                "Флаг method3Called должен быть установлен в true");
    }

    /**
     * Проверка обработки null объекта.
     */
    @Test
    public void testNullObjectThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            InvokeHandler.invokeAnnotatedMethods(null);
        }, "Должно быть выброшено IllegalArgumentException для null объекта");
    }
}

