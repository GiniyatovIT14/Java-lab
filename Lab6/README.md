## Лабораторная работа №6. Тема: ИНСТРУМЕНТИРОВАНИЕ КОДА

---

## **ЗАДАНИЕ 1: Аннотации**

### **Задача 1: Аннотация @Invoke**

#### **Цель задания:**
Разработать аннотацию для автоматического вызова методов через Reflection API.

#### **Реализованные классы:**
- `Invoke` (аннотация)
- `InvokeHandler` (обработчик)
- `TestClass` (класс-пример)

#### **Характеристики аннотации:**
```java
@Target(ElementType.METHOD)        // Только для методов
@Retention(RetentionPolicy.RUNTIME) // Доступна во время выполнения
public @interface Invoke {
}
```

#### **Ключевые методы:**

**InvokeHandler:**
```java
public static void invokeAnnotatedMethods(Object obj)  // Находит и вызывает методы с @Invoke
```

**TestClass:**
```java
@Invoke
public void method1()              // Метод с аннотацией - будет вызван автоматически
public void method2()              // Метод без аннотации - не будет вызван
@Invoke
private void method3()            // Приватный метод с аннотацией - также будет вызван
```

#### **Тестирование:**

**Тест 1: Автоматический вызов методов**
```java
TestClass testObj = new TestClass();
InvokeHandler.invokeAnnotatedMethods(testObj);
// Автоматически вызываются: method1() и method3()
// method2() не вызывается (нет аннотации)
```

**Тест 2: Проверка состояния**
```java
testObj.isMethod1Called();  // true - был вызван
testObj.isMethod2Called();  // false - не был вызван
testObj.isMethod3Called();  // true - был вызван
```

---

### **Задача 2: Аннотация @Default**

#### **Цель задания:**
Разработать аннотацию для указания типа по умолчанию.

#### **Реализованные классы:**
- `Default` (аннотация)
- `DefaultHandler` (обработчик)
- `DefaultClass` (класс-пример)

#### **Характеристики аннотации:**
```java
@Target({ElementType.TYPE, ElementType.FIELD})  // Для классов и полей
@Retention(RetentionPolicy.RUNTIME)
public @interface Default {
    Class<?> value();  // Обязательное свойство - класс по умолчанию
}
```

#### **Ключевые методы:**
```java
public static String getDefaultClassName(Class<?> clazz)  // Получить класс по умолчанию из класса
public static String getDefaultClassName(Field field)    // Получить класс по умолчанию из поля
```

#### **Тестирование:**

**Тест 1: Проверка аннотации на классе**
```java
@Default(String.class)
public class DefaultClass { }

String className = DefaultHandler.getDefaultClassName(DefaultClass.class);
// Результат: "java.lang.String"
```

**Тест 2: Проверка аннотации на поле**
```java
@Default(Integer.class)
private Object field1;

Field field = DefaultClass.class.getDeclaredField("field1");
String fieldClassName = DefaultHandler.getDefaultClassName(field);
// Результат: "java.lang.Integer"
```

---

### **Задача 3: Аннотация @ToString**

#### **Цель задания:**
Разработать аннотацию для управления включением полей в строковое представление объекта.

#### **Реализованные классы:**
- `ToString` (аннотация)
- `ToStringHandler` (обработчик)
- `ToStringClass` (класс-пример)

#### **Характеристики аннотации:**
```java
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ToString {
    Mode value() default Mode.YES;  // По умолчанию YES
    enum Mode { YES, NO }
}
```

#### **Ключевые методы:**
```java
public static String toString(Object obj)  // Формирует строку, учитывая только поля с Mode.YES
```

#### **Тестирование:**

**Тест 1: Формирование строкового представления**
```java
ToStringClass obj = new ToStringClass("Иван", 25, "secret123", "ivan@example.com");
// Поля: name, age, password (@ToString(Mode.NO)), email

String result = ToStringHandler.toString(obj);
// Результат: "ToStringClass{name=Иван, age=25, email=ivan@example.com}"
// password не включен (помечен Mode.NO)
```

---

### **Задача 4: Аннотация @Validate**

#### **Цель задания:**
Разработать аннотацию для указания списка типов для валидации.

#### **Реализованные классы:**
- `Validate` (аннотация)
- `ValidateHandler` (обработчик)
- `ValidatedClass` (класс-пример)

#### **Характеристики аннотации:**
```java
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {
    Class<?>[] value();  // Обязательное свойство - массив классов
}
```

#### **Ключевые методы:**
```java
public static Class<?>[] getValidationClasses(Class<?> clazz)  // Получить массив классов
public static String getValidationClassNames(Class<?> clazz)    // Получить строку с именами
```

#### **Тестирование:**

**Тест 1: Извлечение классов из аннотации**
```java
@Validate({String.class, Integer.class, Double.class})
public class ValidatedClass { }

Class<?>[] classes = ValidateHandler.getValidationClasses(ValidatedClass.class);
// Результат: [String.class, Integer.class, Double.class]
```

**Тест 2: Обработка пустого массива**
```java
@Validate({})
class EmptyClass { }

// Выбрасывается IllegalArgumentException: "Массив классов для валидации не может быть пустым"
```

---

### **Задача 5: Аннотация @Two**

#### **Цель задания:**
Разработать аннотацию с двумя обязательными свойствами.

#### **Реализованные классы:**
- `Two` (аннотация)
- `TwoHandler` (обработчик)
- `TwoClass` (класс-пример)

#### **Характеристики аннотации:**
```java
@Target(ElementType.TYPE)  // Только для классов
@Retention(RetentionPolicy.RUNTIME)
public @interface Two {
    String first();   // Обязательное свойство (строковое)
    int second();     // Обязательное свойство (числовое)
}
```

#### **Ключевые методы:**
```java
public static String getTwoProperties(Class<?> clazz)  // Получить оба свойства
public static String getFirst(Class<?> clazz)          // Получить first
public static int getSecond(Class<?> clazz)            // Получить second
```

#### **Тестирование:**

**Тест 1: Считывание свойств**
```java
@Two(first = "Hello", second = 42)
public class TwoClass { }

String properties = TwoHandler.getTwoProperties(TwoClass.class);
// Результат: "first=Hello, second=42"

String first = TwoHandler.getFirst(TwoClass.class);   // "Hello"
int second = TwoHandler.getSecond(TwoClass.class);     // 42
```

---

### **Задача 6: Аннотация @Cache**

#### **Цель задания:**
Разработать аннотацию для указания кешируемых областей.

#### **Реализованные классы:**
- `Cache` (аннотация)
- `CacheHandler` (обработчик)
- `CachedClass` (класс с областями)
- `EmptyCacheClass` (класс с пустым массивом)

#### **Характеристики аннотации:**
```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {
    String[] value() default {};  // По умолчанию пустой массив
}
```

#### **Ключевые методы:**
```java
public static String[] getCacheAreas(Class<?> clazz)  // Получить массив областей
public static String getCacheInfo(Class<?> clazz)      // Получить строку с информацией
```

#### **Тестирование:**

**Тест 1: Класс с кешируемыми областями**
```java
@Cache({"users", "orders", "products"})
public class CachedClass { }

String[] areas = CacheHandler.getCacheAreas(CachedClass.class);
// Результат: ["users", "orders", "products"]
```

**Тест 2: Класс с пустым массивом**
```java
@Cache
public class EmptyCacheClass { }

String info = CacheHandler.getCacheInfo(EmptyCacheClass.class);
// Результат: "Список кешируемых областей пуст"
```

---

## **ЗАДАНИЕ 2: Тестирование**

### **Задача 4: Тест для @Validate**

#### **Цель задания:**
Написать JUnit тест для проверки корректности работы механизма валидации классов с аннотацией @Validate.

#### **Реализованные тесты:**

**ValidateTest:**
```java
@Test
public void testValidateAnnotationPresent()           // Проверка наличия аннотации
@Test
public void testGetValidationClasses()                // Проверка извлечения классов
@Test
public void testReflectionReturnsAnnotation()         // Проверка Reflection API
@Test
public void testEmptyArrayThrowsException()           // Проверка исключения для пустого массива
@Test
public void testGetValidationClassNames()             // Проверка вывода имен классов
```

#### **Тестирование:**

**Тест 1: Проверка наличия аннотации**
```java
assertTrue(validatedClass.isAnnotationPresent(Validate.class));
// Проверяет, что класс помечен аннотацией @Validate
```

**Тест 2: Проверка извлечения классов**
```java
Class<?>[] classes = ValidateHandler.getValidationClasses(ValidatedClass.class);
assertEquals(3, classes.length);
assertEquals(String.class, classes[0]);
assertEquals(Integer.class, classes[1]);
assertEquals(Double.class, classes[2]);
```

**Тест 3: Проверка исключения**
```java
@Validate({})
class EmptyClass { }

assertThrows(IllegalArgumentException.class, () -> {
    ValidateHandler.getValidationClasses(EmptyClass.class);
});
```

---

### **Задача 2: Тест для @Invoke**

#### **Цель задания:**
Создать JUnit тест для проверки корректности вызова методов, отмеченных аннотацией @Invoke.

#### **Реализованные тесты:**

**InvokeTest:**
```java
@BeforeEach
public void setUp()                                   // Подготовка перед каждым тестом
@Test
public void testFindAnnotatedMethods()                // Поиск методов через Reflection
@Test
public void testMethodExecutesWithoutException()      // Выполнение без исключений
@Test
public void testAnnotatedMethodsAreInvoked()          // Проверка вызова методов
@Test
public void testNonAnnotatedMethodNotInvoked()       // Метод без аннотации не вызывается
@Test
public void testSideEffect()                          // Проверка побочных эффектов
@Test
public void testNullObjectThrowsException()           // Обработка null объекта
```

#### **Тестирование:**

**Тест 1: Поиск методов через Reflection**
```java
Method[] methods = TestClass.class.getDeclaredMethods();
int annotatedCount = 0;
for (Method method : methods) {
    if (method.isAnnotationPresent(Invoke.class)) {
        annotatedCount++;
    }
}
assertEquals(2, annotatedCount);  // Должно быть 2 метода с @Invoke
```

**Тест 2: Проверка вызова методов**
```java
TestClass testObj = new TestClass();
testObj.reset();

InvokeHandler.invokeAnnotatedMethods(testObj);

assertTrue(testObj.isMethod1Called());   // method1 вызван
assertTrue(testObj.isMethod3Called());   // method3 вызван
assertFalse(testObj.isMethod2Called());   // method2 не вызван (нет аннотации)
```

**Тест 3: Проверка побочных эффектов**
```java
testObj.reset();
assertFalse(testObj.isMethod1Called());

InvokeHandler.invokeAnnotatedMethods(testObj);

assertTrue(testObj.isMethod1Called());  // Флаг установлен после вызова
```

---

## **СТРУКТУРА ПРОЕКТА**

```
src/
├── ru/Giniyatov/
│   ├── annotations/          # 6 аннотаций
│   │   ├── Invoke.java
│   │   ├── Default.java
│   │   ├── ToString.java
│   │   ├── Validate.java
│   │   ├── Two.java
│   │   └── Cache.java
│   ├── InvokeExample/        # Примеры для @Invoke
│   ├── DefaultExample/       # Примеры для @Default
│   ├── ToStringExample/      # Примеры для @ToString
│   ├── ValidateExample/      # Примеры для @Validate
│   ├── TwoExample/           # Примеры для @Two
│   ├── CacheExample/         # Примеры для @Cache
│   ├── DemonstrateTasks/     # Демонстрация всех заданий
│   ├── tests/                # JUnit тесты
│   │   ├── ValidateTest.java
│   │   └── InvokeTest.java
│   └── main/                 # Главный класс
│       └── Main.java
```
mvn test
```

Или через IntelliJ IDEA: правой кнопкой на тестовый класс → Run


