package ru.Giniyatov.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import ru.Giniyatov.ValidateExample.ValidateHandler;
import ru.Giniyatov.ValidateExample.ValidatedClass;
import ru.Giniyatov.annotations.Validate;

import java.lang.annotation.Annotation;

/**
 * Тесты для проверки корректности работы механизма валидации классов,
 * отмеченных аннотацией @Validate.
 */
public class ValidateTest {

    private Class<ValidatedClass> validatedClass;

    /**
     * Подготовка тестируемого класса перед каждым тестом.
     */
    @BeforeEach
    public void setUp() {
        validatedClass = ValidatedClass.class;
    }

    /**
     * Проверка, что аннотация @Validate присутствует на классе.
     */
    @Test
    public void testValidateAnnotationPresent() {
        assertTrue(validatedClass.isAnnotationPresent(Validate.class),
                "Класс должен быть помечен аннотацией @Validate");
    }

    /**
     * Проверка, что список классов, переданный в аннотации, корректно извлекается.
     */
    @Test
    public void testGetValidationClasses() {
        Class<?>[] classes = ValidateHandler.getValidationClasses(validatedClass);
        
        assertNotNull(classes, "Массив классов не должен быть null");
        assertEquals(3, classes.length, "Должно быть 3 класса для валидации");
        assertEquals(String.class, classes[0], "Первый класс должен быть String");
        assertEquals(Integer.class, classes[1], "Второй класс должен быть Integer");
        assertEquals(Double.class, classes[2], "Третий класс должен быть Double");
    }

    /**
     * Проверка, что Reflection корректно возвращает экземпляр аннотации.
     */
    @Test
    public void testReflectionReturnsAnnotation() {
        Annotation annotation = validatedClass.getAnnotation(Validate.class);
        
        assertNotNull(annotation, "Аннотация должна быть получена через Reflection");
        assertTrue(annotation instanceof Validate, "Аннотация должна быть типа Validate");
        
        Validate validateAnnotation = (Validate) annotation;
        Class<?>[] classes = validateAnnotation.value();
        assertEquals(3, classes.length, "Должно быть 3 класса в аннотации");
    }

    /**
     * Проверка, что при передаче пустого массива выбрасывается исключение.
     */
    @Test
    public void testEmptyArrayThrowsException() {
        // Создаем класс с пустым массивом для тестирования
        @Validate({})
        class EmptyValidatedClass {
        }
        
        assertThrows(IllegalArgumentException.class, () -> {
            ValidateHandler.getValidationClasses(EmptyValidatedClass.class);
        }, "Должно быть выброшено IllegalArgumentException для пустого массива");
    }

    /**
     * Проверка корректности вывода имен классов.
     */
    @Test
    public void testGetValidationClassNames() {
        String classNames = ValidateHandler.getValidationClassNames(validatedClass);
        
        assertNotNull(classNames, "Строка с именами классов не должна быть null");
        assertTrue(classNames.contains("String"), "Должно содержать String");
        assertTrue(classNames.contains("Integer"), "Должно содержать Integer");
        assertTrue(classNames.contains("Double"), "Должно содержать Double");
    }
}

