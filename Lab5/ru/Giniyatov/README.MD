## Лабораторная работа №5. Тема: ШАБЛОНЫ ООП И КОЛЛЕКЦИИ

---

## **ЗАДАНИЕ 1: Класс Дробь с интерфейсом и кэшированием**

### **Цель задания:**
Реализовать класс для работы с дробями, добавить интерфейс и механизм кэширования вычислений.

### **Реализованные классы:**
- `FractionOperations` (интерфейс)
- `Fraction` (класс дроби)

### **Поля класса Fraction:**
```java
private int numerator;              // Числитель дроби
private int denominator;            // Знаменатель дроби (не может быть 0)
private Double cachedDecimalValue;  // Кэшированное вещественное значение
private boolean isCacheValid;       // Флаг валидности кэша
```

### **Ключевые методы:**

**Интерфейс FractionOperations:**
```java
double getDecimalValue();                           // Получение вещественного значения
void setNumeratorAndDenominator(int n, int d);     // Установка числителя и знаменателя
```

**Класс Fraction:**
```java
public Fraction(int numerator, int denominator)    // Конструктор
public double getDecimalValue()                    // Получение значения с кэшированием
public boolean equals(Object obj)                  // Сравнение дробей по состоянию
public String toString()                           // Строковое представление "x/y"
```

### **Тестирование:**

**Тест 1: Создание и базовые операции**
```java
Fraction frac = new Fraction(3, 4);
System.out.println(frac);              // Вывод: 3/4
System.out.println(frac.getDecimalValue()); // Вывод: 0.75
```

**Тест 2: Кэширование вычислений**
```java
Fraction frac = new Fraction(1, 3);
double val1 = frac.getDecimalValue();  // Вычисляется: 0.333...
double val2 = frac.getDecimalValue();  // Берется из кэша: 0.333...
// Оба значения идентичны, второе взято из кэша
```

**Тест 3: Обработка отрицательных значений**
```java
Fraction frac1 = new Fraction(2, -3);  // Автоматически нормализуется: -2/3
Fraction frac2 = new Fraction(-1, -2); // Нормализуется: 1/2
```

**Тест 4: Сравнение дробей**
```java
Fraction f1 = new Fraction(1, 2);
Fraction f2 = new Fraction(2, 4);
Fraction f3 = new Fraction(1, 3);

System.out.println(f1.equals(f2));     // false (разные числитель/знаменатель)
System.out.println(f1.equals(f3));     // false
```

---

## **ЗАДАНИЕ 2: Количество мяуканий**

### **Цель задания:**
Реализовать систему подсчета количества мяуканий кота без изменения исходного класса.

### **Реализованные классы:**
- `Meowable` (интерфейс)
- `Cat` (класс кота)
- `CountingCat` (класс-счетчик)
- `Funs` (утилиты)

### **Поля классов:**

**Класс Cat:**
```java
private String name;    // Имя кота
```

**Класс CountingCat:**
```java
private Meowable realCat;    // Ссылка на реального кота
private int meowCount;       // Счетчик мяуканий
```

### **Ключевые методы:**

```java
// Cat
public void meow()                     // Вывод "Имя: мяу!"
public void meow(int times)            // Многократное мяуканье

// CountingCat  
public void meow()                     // Увеличивает счетчик + вызывает мяуканье
public int getMeowCount()              // Возвращает количество мяуканий

// Funs
public static void meowsCare(Meowable m) // Вызывает мяуканье
```

### **Тестирование:**

**Тест 1: Базовое мяуканье**
```java
Cat cat = new Cat("Барсик");
cat.meow();  // Вывод: "Барсик: мяу!"
```

**Тест 2: Подсчет мяуканий через прокси**
```java
Cat realCat = new Cat("Мурзик");
CountingCat counter = new CountingCat(realCat);

Funs.meowsCare(counter);  // Мурзик: мяу!
Funs.meowsCare(counter);  // Мурзик: мяу!

System.out.println(counter.getMeowCount()); // Вывод: 2
```

**Тест 3: Многократное мяуканье**
```java
Cat cat = new Cat("Васька");
cat.meow(3); // Вывод: "Васька: мяу-мяу-мяу!"
```

---

## **ЗАДАНИЕ 3: Удаление элементов из списка**

### **Цель задания:**
Реализовать шаблонный метод для удаления всех вхождений элемента из списка.

### **Ключевые методы:**
```java
public static <T> void removeAllOccurrences(List<T> list, T element)
```

### **Тестирование:**

**Тест 1: Удаление чисел**
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 2, 5);
ListUtils.removeAllOccurrences(numbers, 2);
// Результат: [1, 3, 4, 5] - все двойки удалены
```

**Тест 2: Удаление строк**
```java
List<String> words = Arrays.asList("яблоко", "банан", "яблоко", "апельсин");
ListUtils.removeAllOccurrences(words, "яблоко");
// Результат: ["банан", "апельсин"] - все "яблоко" удалены
```

**Тест 3: Работа с любыми типами**
```java
List<Double> doubles = Arrays.asList(1.1, 2.2, 1.1, 3.3);
List<Boolean> booleans = Arrays.asList(true, false, true);

// Один метод работает с разными типами благодаря шаблонам
```

---

## **ЗАДАНИЕ 4: Генерация логинов из файла**

### **Цель задания:**
Обработать файл с именами учеников и сгенерировать уникальные логины по фамилиям.

### **Поля классов:**

**Класс Student:**
```java
private String lastName;    // Фамилия ученика
private String firstName;   // Имя ученика  
private String login;       // Сгенерированный логин
```

### **Ключевые методы:**
```java
public static List<Student> readStudentsFromFile(String filename)
public static List<Student> generateLogins(List<Student> students)
```

### **Тестирование:**

**Тест 1: Базовая генерация логинов**
```java
// Входные данные:
// Иванова Мария
// Петров Сергей  
// Бойцова Екатерина
// Петров Иван
// Иванова Наташа

// Результат:
// Иванова, Петров, Бойцова, Петров2, Иванова2
```

**Тест 2: Обработка файла**
```java
List<Student> students = LoginGenerator.readStudentsFromFile("students.txt");
List<Student> result = LoginGenerator.generateLogins(students);
// Автоматически читает из файла, генерирует логины
```

---

## **ЗАДАНИЕ 5: Звонкие согласные буквы**

### **Цель задания:**
Найти и отсортировать все уникальные звонкие согласные буквы из текста.

### **Поля класса ConsonantFinder:**
```java
private static final Set<Character> VOICED_CONSONANTS = Set.of(
    'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'л', 'м', 'н', 'р'
);  // Множество звонких согласных букв
```

### **Ключевые методы:**
```java
public static Set<Character> findVoicedConsonants(String text)
```

### **Тестирование:**

**Тест 1: Поиск в тексте**
```java
String text = "В саду растут высокие деревья";
Set<Character> consonants = ConsonantFinder.findVoicedConsonants(text);
// Результат: [б, в, г, д, ж, з, л, м, н, р] (отсортировано)
```

**Тест 2: Обработка файла**
```java
String text = ConsonantFinder.readTextFromFile("text.txt");
Set<Character> result = ConsonantFinder.findVoicedConsonants(text);
// Читает текст из файла, находит согласные
```

---

## **ЗАДАНИЕ 6: Обращение очереди**

### **Цель задания:**
Переписать элементы из одной очереди в другую в обратном порядке.

### **Ключевые методы:**
```java
public static <T> void reverseQueue(Queue<T> L1, Queue<T> L2)
```

### **Тестирование:**

**Тест 1: Обращение чисел**
```java
Queue<Integer> L1 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
Queue<Integer> L2 = new LinkedList<>();

QueueUtils.reverseQueue(L1, L2);
// L1 остается: [1, 2, 3, 4, 5]
// L2 становится: [5, 4, 3, 2, 1]
```

**Тест 2: Обращение строк**
```java
Queue<String> L1 = new LinkedList<>(Arrays.asList("A", "B", "C"));
Queue<String> L2 = new LinkedList<>();

QueueUtils.reverseQueue(L1, L2);
// L2: ["C", "B", "A"]
```

---

## **ЗАДАНИЕ 7: Обработка точек стримом**

### **Цель задания:**
Использовать стримы для обработки набора точек по заданным правилам.

### **Реализованные классы:**
- `Point` (точка)
- `Line` (линия) 
- `Polyline` (ломаная)

### **Поля классов:**

**Класс Point:**
```java
private double x;    // Координата X
private double y;    // Координата Y
```

**Класс Line:**
```java
private Point start;    // Начальная точка линии
private Point end;      // Конечная точка линии
```

**Класс Polyline:**
```java
private List<Point> points;    // Список точек ломаной линии
```

### **Стрим-обработка:**
```java
points.stream()
    .distinct()                      // Удалить дубликаты
    .sorted(Comparator.comparingDouble(Point::getX)) // Сортировать по X
    .map(point -> {                  // Отрицательные Y сделать положительными
        double newY = point.getY() < 0 ? -point.getY() : point.getY();
        return new Point(point.getX(), newY);
    })
    .collect(Collectors.toList());   // Собрать в список
```

### **Тестирование:**

**Тест 1: Полная обработка**
```java
List<Point> points = Arrays.asList(
    new Point(3, -4),    // Дубликат
    new Point(1, 2),     
    new Point(3, -4),    // Дубликат - удалится
    new Point(0, -5),    // Отрицательный Y
    new Point(2, 3)
);

Polyline result = GeometryStreamProcessor.processPoints(points);
// Результат: [{0.0;5.0}, {1.0;2.0}, {2.0;3.0}, {3.0;4.0}]
// - Удалены дубликаты
// - Отсортировано по X  
// - Отрицательные Y стали положительными
```

---

## **ЗАДАНИЕ 8: Группировка людей по номерам**

### **Цель задания:**
Обработать файл с именами и номерами с помощью стримов.

### **Поля класса Person:**
```java
private String name;      // Имя человека
private Integer number;   // Номер человека (может быть null)
```

### **Стрим-обработка:**
```java
people.stream()
    .filter(person -> person.getNumber() != null)  // Убрать без номеров
    .map(person -> {                              // Форматировать имена
        String formattedName = formatName(person.getName());
        return new Person(formattedName, person.getNumber());
    })
    .collect(Collectors.groupingBy(              // Группировать по номерам
        Person::getNumber,
        Collectors.mapping(Person::getName, Collectors.toList())
    ));
```

### **Тестирование:**

**Тест 1: Обработка данных из файла**
```java
// Файл people.txt:
// Вася:5
// Петя:3  
// Аня:5
// Маша:
// КОЛЯ:3
// анна:7

Map<Integer, List<String>> result = PersonProcessor.processPeople(people);
// Результат: [3:[Коля, Петя], 5:[Аня, Вася], 7:[Анна]]
// - Маша без номера удалена
// - Имена приведены к правильному регистру
// - Сгруппировано по номерам
```
