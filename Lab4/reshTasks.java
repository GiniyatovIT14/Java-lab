import java.util.*;

// Класс для интерактивного решения задач (пользовательский ввод)
class reshTasks {
    private static Scanner scanner = new Scanner(System.in);

    // Метод для ввода целого числа
    private static int getIntInput() {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Ошибка! Введите целое число: ");
            }
        }
    }

    // Метод для ввода целого числа в диапазоне
    private static int getIntInput(int min, int max) {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                int number = Integer.parseInt(input);
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.printf("Ошибка! Введите число от %d до %d: ", min, max);
                }
            } catch (NumberFormatException e) {
                System.out.printf("Ошибка! Введите целое число от %d до %d: ", min, max);
            }
        }
    }

    // Метод для ввода дробного числа
    private static double getDoubleInput() {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                input = input.replace(',', '.');
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.print("Ошибка! Введите число (например: 3.14 или 3,14): ");
            }
        }
    }

    // Метод для ввода float
    private static float getFloatInput() {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                input = input.replace(',', '.');
                return Float.parseFloat(input);
            } catch (NumberFormatException e) {
                System.out.print("Ошибка! Введите число (например: 3.14 или 3,14): ");
            }
        }
    }

    // Метод для ввода long
    private static long getLongInput() {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                return Long.parseLong(input);
            } catch (NumberFormatException e) {
                System.out.print("Ошибка! Введите целое число: ");
            }
        }
    }

    // Метод для ввода boolean
    private static boolean getBooleanInput() {
        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("true") || input.equals("false")) {
                return Boolean.parseBoolean(input);
            }
            System.out.print("Ошибка! Введите true или false: ");
        }
    }

    // Интерактивное решение задачи с коробкой через Generics
    public static void reshBox() {
        System.out.println("=== Обобщенная коробка ===");

        // Создаем коробку для выбранного типа
        System.out.print("Введите любой объект для коробки (число, текст, true/false): ");
        String input = scanner.nextLine();

        // Определяем тип данных и обрабатываем через обобщенный метод
        Object value = determineType(input);
        processWithBox(value);
    }

    // Определяем тип введенных данных
    private static Object determineType(String input) {
        // Пробуем определить Integer
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e1) {
            // Не integer - продолжаем
        }

        // Пробуем определить Double
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e2) {
            // Не double - продолжаем
        }

        // Пробуем определить Boolean
        if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
            return Boolean.parseBoolean(input);
        }

        // Если ничего не подошло - возвращаем как String
        return input;
    }

    // Обобщенный метод для работы с коробкой любого типа
    private static <T> void processWithBox(T value) {
        Box<T> box = new Box<>();

        try {
            // Кладем значение в коробку
            box.put(value);
            System.out.println("Значение '" + value + "' типа " + value.getClass().getSimpleName() +
                    " успешно размещено в коробке");
            System.out.println("Состояние коробки: " + box);

            // Извлекаем значение
            System.out.println("\nИзвлекаем значение из коробки...");
            T extractedValue = box.get();
            System.out.println("Извлеченное значение: " + extractedValue);
            System.out.println("Состояние коробки после извлечения: " + box);

            // Демонстрация ошибки при попытке положить второй объект
            System.out.print("\nПопробуем положить второе значение... ");
            try {
                box.put(value);
            } catch (IllegalStateException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }

        } catch (IllegalStateException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    // Интерактивная работа с Comparable
    public static void reshComparable() {
        System.out.println("=== РЕШЕНИЕ: Интерфейс Comparable ===");

        System.out.println("Создадим два числовых значения для сравнения:");

        // Первое число
        System.out.println("\nПервое число:");
        System.out.print("Введите значение: ");
        int value1 = getIntInput();

        NumberValue num1 = new NumberValue(value1);

        // Второе число
        System.out.println("\nВторое число:");
        System.out.print("Введите значение: ");
        int value2 = getIntInput();

        NumberValue num2 = new NumberValue(value2);

        // Сравниваем
        System.out.println("\n" + "=".repeat(40));
        System.out.println("Результаты сравнения:");
        System.out.println("Число 1: " + num1);
        System.out.println("Число 2: " + num2);

        int result = num1.compare(num2);

        if (result < 0) {
            System.out.println("Число " + value1 + " МЕНЬШЕ чем " + value2);
        } else if (result > 0) {
            System.out.println("Число " + value1 + " БОЛЬШЕ чем " + value2);
        } else {
            System.out.println("Число " + value1 + " РАВНО " + value2);
        }

        System.out.println("Результат сравнения: " + result);
    }

    // Интерактивный поиск максимума в коробках
    public static void reshMaxSearch() {
        System.out.println("=== РЕШЕНИЕ: Поиск максимума в коробках ===");

        System.out.print("Сколько коробок с числами создать? ");
        int count = getIntInput(1, 10);

        Box<? extends Number>[] boxes = new Box[count];

        System.out.println("\nЗаполните коробки числами:");
        for (int i = 0; i < count; i++) {
            System.out.println("\nКоробка " + (i + 1) + ":");
            System.out.print("Введите число: ");
            double number = getDoubleInput();
            boxes[i] = new Box<>(number);
        }

        System.out.println("\nСозданные коробки:");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + boxes[i]);
        }

        try {
            double max = MathUtils.findMax(boxes);
            System.out.println("\nМаксимальное значение среди всех коробок: " + max);
        } catch (IllegalArgumentException e) {
            System.out.println("\nОшибка: " + e.getMessage());
        }
    }

    public static void reshFunction() {
        System.out.println("=== РЕШЕНИЕ: Функциональное преобразование списков ===");

        System.out.println("Выберите тип преобразования:");
        System.out.println("1. Строки - Длины строк");
        System.out.println("2. Числа - Абсолютные значения");
        System.out.println("3. Массивы - Максимумы массивов");
        System.out.print("Ваш выбор: ");

        int choice = getIntInput(1, 3);

        switch (choice) {
            case 1:
                transformStrings();
                break;
            case 2:
                transformNumbers();
                break;
            case 3:
                transformArrays();
                break;
        }
    }

    private static void transformStrings() {
        System.out.println("\n--- Строки - Длины строк ---");
        System.out.print("Введите строки через запятую: ");
        String input = scanner.nextLine();

        String[] stringArray = input.split(",");
        List<String> strings = new ArrayList<>();
        for (String str : stringArray) {
            strings.add(str.trim());
        }

        System.out.println("Исходный список: " + strings);

        List<Integer> lengths = ListUtils.map(strings, new Function<String, Integer>() {
            @Override
            public Integer apply(String value) {
                return value.length();
            }
        });

        System.out.println("Длины строк: " + lengths);
    }

    private static void transformNumbers() {
        System.out.println("\n--- Числа - Абсолютные значения ---");
        System.out.print("Введите числа через запятую: ");
        String input = scanner.nextLine();

        String[] numberStrings = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String numStr : numberStrings) {
            numbers.add(Integer.parseInt(numStr.trim()));
        }

        System.out.println("Исходный список: " + numbers);

        List<Integer> absoluteValues = ListUtils.map(numbers, new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer value) {
                return Math.abs(value);
            }
        });

        System.out.println("Абсолютные значения: " + absoluteValues);
    }

    private static void transformArrays() {
        System.out.println("\n--- Массивы - Максимумы массивов ---");
        System.out.print("Сколько массивов создать? ");
        int arrayCount = getIntInput(1, 5);

        List<int[]> arrays = new ArrayList<>();

        for (int i = 0; i < arrayCount; i++) {
            System.out.print("Введите числа для массива " + (i + 1) + " через запятую: ");
            String input = scanner.nextLine();

            String[] numberStrings = input.split(",");
            int[] array = new int[numberStrings.length];
            for (int j = 0; j < numberStrings.length; j++) {
                array[j] = Integer.parseInt(numberStrings[j].trim());
            }
            arrays.add(array);
        }

        System.out.print("Исходные массивы: ");
        for (int[] arr : arrays) {
            System.out.print(Arrays.toString(arr) + " ");
        }
        System.out.println();

        List<Integer> maxValues = ListUtils.map(arrays, new Function<int[], Integer>() {
            @Override
            public Integer apply(int[] value) {
                int max = value[0];
                for (int num : value) {
                    if (num > max) max = num;
                }
                return max;
            }
        });

        System.out.println("Максимумы массивов: " + maxValues);
    }

    // Интерактивная работа с фильтром
    public static void reshFilter() {
        System.out.println("=== РЕШЕНИЕ: Фильтрация списков ===");

        System.out.println("Выберите тип фильтрации:");
        System.out.println("1. Строки - Длина >= 3 символов");
        System.out.println("2. Числа - Только положительные");
        System.out.println("3. Массивы - Без положительных элементов");
        System.out.print("Ваш выбор: ");

        int choice = getIntInput(1, 3);

        switch (choice) {
            case 1:
                filterStrings();
                break;
            case 2:
                filterNumbers();
                break;
            case 3:
                filterArrays();
                break;
        }
    }

    private static void filterStrings() {
        System.out.println("\n--- Фильтрация строк по длине ---");
        System.out.print("Введите строки через запятую: ");
        String input = scanner.nextLine();

        String[] stringArray = input.split(",");
        List<String> strings = new ArrayList<>();
        for (String str : stringArray) {
            strings.add(str.trim());
        }

        System.out.println("Исходный список: " + strings);

        List<String> filteredStrings = ListUtils.filter(strings, new Predicate<String>() {
            @Override
            public boolean test(String value) {
                return value.length() >= 3;
            }
        });

        System.out.println("Строки длиной >= 3 символов: " + filteredStrings);
    }

    private static void filterNumbers() {
        System.out.println("\n--- Фильтрация положительных чисел ---");
        System.out.print("Введите числа через запятую: ");
        String input = scanner.nextLine();

        String[] numberStrings = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String numStr : numberStrings) {
            numbers.add(Integer.parseInt(numStr.trim()));
        }

        System.out.println("Исходный список: " + numbers);

        List<Integer> positiveNumbers = ListUtils.filter(numbers, new Predicate<Integer>() {
            @Override
            public boolean test(Integer value) {
                return value > 0;
            }
        });

        System.out.println("Положительные числа: " + positiveNumbers);
    }

    private static void filterArrays() {
        System.out.println("\n--- Фильтрация массивов без положительных элементов ---");
        System.out.print("Сколько массивов создать? ");
        int arrayCount = getIntInput(1, 5);

        List<int[]> arrays = new ArrayList<>();

        for (int i = 0; i < arrayCount; i++) {
            System.out.print("Введите числа для массива " + (i + 1) + " через запятую: ");
            String input = scanner.nextLine();

            String[] numberStrings = input.split(",");
            int[] array = new int[numberStrings.length];
            for (int j = 0; j < numberStrings.length; j++) {
                array[j] = Integer.parseInt(numberStrings[j].trim());
            }
            arrays.add(array);
        }

        System.out.print("Исходные массивы: ");
        for (int[] arr : arrays) {
            System.out.print(Arrays.toString(arr) + " ");
        }
        System.out.println();

        List<int[]> arraysWithoutPositives = ListUtils.filter(arrays, new Predicate<int[]>() {
            @Override
            public boolean test(int[] value) {
                for (int num : value) {
                    if (num > 0) {
                        return false;
                    }
                }
                return true;
            }
        });

        System.out.print("Массивы без положительных элементов: ");
        for (int[] arr : arraysWithoutPositives) {
            System.out.print(Arrays.toString(arr) + " ");
        }
        System.out.println();
    }

    // Интерактивная работа со сверткой
    public static void reshReduce() {
        System.out.println("=== РЕШЕНИЕ: Свертка списков ===");

        System.out.println("Выберите тип свертки:");
        System.out.println("1. Строки - Конкатенация");
        System.out.println("2. Числа - Сумма");
        System.out.println("3. Числа - Произведение");
        System.out.print("Ваш выбор: ");

        int choice = getIntInput(1, 3);

        switch (choice) {
            case 1:
                reduceStrings();
                break;
            case 2:
                reduceNumbersSum();
                break;
            case 3:
                reduceNumbersProduct();
                break;
        }
    }

    private static void reduceStrings() {
        System.out.println("\n--- Конкатенация строк ---");
        System.out.print("Введите строки через запятую: ");
        String input = scanner.nextLine();

        String[] stringArray = input.split(",");
        List<String> strings = new ArrayList<>();
        for (String str : stringArray) {
            strings.add(str.trim());
        }

        System.out.println("Исходный список: " + strings);

        String result = ListUtils.reduce(strings, new Reducer<String>() {
            @Override
            public String reduce(String accumulator, String current) {
                return accumulator + current;
            }
        }, "");

        System.out.println("Результат конкатенации: " + result);
    }

    private static void reduceNumbersSum() {
        System.out.println("\n--- Сумма чисел ---");
        System.out.print("Введите числа через запятую: ");
        String input = scanner.nextLine();

        String[] numberStrings = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String numStr : numberStrings) {
            numbers.add(Integer.parseInt(numStr.trim()));
        }

        System.out.println("Исходный список: " + numbers);

        Integer sum = ListUtils.reduce(numbers, new Reducer<Integer>() {
            @Override
            public Integer reduce(Integer accumulator, Integer current) {
                return accumulator + current;
            }
        }, 0);

        System.out.println("Сумма: " + sum);
    }

    private static void reduceNumbersProduct() {
        System.out.println("\n--- Произведение чисел ---");
        System.out.print("Введите числа через запятую: ");
        String input = scanner.nextLine();

        String[] numberStrings = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String numStr : numberStrings) {
            numbers.add(Integer.parseInt(numStr.trim()));
        }

        System.out.println("Исходный список: " + numbers);

        Integer product = ListUtils.reduce(numbers, new Reducer<Integer>() {
            @Override
            public Integer reduce(Integer accumulator, Integer current) {
                return accumulator * current;
            }
        }, 1);

        System.out.println("Произведение: " + product);
    }

    // Интерактивная работа с коллекционированием
    public static void reshCollect() {
        System.out.println("=== РЕШЕНИЕ: Коллекционирование ===");

        System.out.println("Выберите тип коллекционирования:");
        System.out.println("1. Числа - Разбиение на положительные/отрицательные");
        System.out.println("2. Строки - Группировка по длине");
        System.out.println("3. Строки - Уникальные значения");
        System.out.print("Ваш выбор: ");

        int choice = getIntInput(1, 3);

        switch (choice) {
            case 1:
                collectNumbers();
                break;
            case 2:
                collectStringsByLength();
                break;
            case 3:
                collectUniqueStrings();
                break;
        }
    }

    private static void collectNumbers() {
        System.out.println("\n--- Разбиение чисел на положительные/отрицательные ---");
        System.out.print("Введите числа через запятую: ");
        String input = scanner.nextLine();

        String[] numberStrings = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String numStr : numberStrings) {
            numbers.add(Integer.parseInt(numStr.trim()));
        }

        System.out.println("Исходный список: " + numbers);

        Map<String, List<Integer>> groups = ListUtils.collect(numbers,
                new Collector<Integer, Map<String, List<Integer>>>() {
                    @Override
                    public Map<String, List<Integer>> create() {
                        Map<String, List<Integer>> map = new HashMap<>();
                        map.put("positive", new ArrayList<>());
                        map.put("negative", new ArrayList<>());
                        map.put("zero", new ArrayList<>());
                        return map;
                    }

                    @Override
                    public void add(Map<String, List<Integer>> map, Integer item) {
                        if (item > 0) {
                            map.get("positive").add(item);
                        } else if (item < 0) {
                            map.get("negative").add(item);
                        } else {
                            map.get("zero").add(item);
                        }
                    }
                });

        System.out.println("Результат:");
        System.out.println("  Положительные: " + groups.get("positive"));
        System.out.println("  Отрицательные: " + groups.get("negative"));
        System.out.println("  Нули: " + groups.get("zero"));
    }

    private static void collectStringsByLength() {
        System.out.println("\n--- Группировка строк по длине ---");
        System.out.print("Введите строки через запятую: ");
        String input = scanner.nextLine();

        String[] stringArray = input.split(",");
        List<String> strings = new ArrayList<>();
        for (String str : stringArray) {
            strings.add(str.trim());
        }

        System.out.println("Исходный список: " + strings);

        Map<Integer, List<String>> lengthGroups = ListUtils.collect(strings,
                new Collector<String, Map<Integer, List<String>>>() {
                    @Override
                    public Map<Integer, List<String>> create() {
                        return new HashMap<>();
                    }

                    @Override
                    public void add(Map<Integer, List<String>> map, String item) {
                        int length = item.length();
                        if (!map.containsKey(length)) {
                            map.put(length, new ArrayList<>());
                        }
                        map.get(length).add(item);
                    }
                });

        System.out.println("Группы по длине:");
        for (Map.Entry<Integer, List<String>> entry : lengthGroups.entrySet()) {
            System.out.println("  Длина " + entry.getKey() + ": " + entry.getValue());
        }
    }

    private static void collectUniqueStrings() {
        System.out.println("\n--- Уникальные строки ---");
        System.out.print("Введите строки через запятую: ");
        String input = scanner.nextLine();

        String[] stringArray = input.split(",");
        List<String> strings = new ArrayList<>();
        for (String str : stringArray) {
            strings.add(str.trim());
        }

        System.out.println("Исходный список: " + strings);

        Set<String> uniqueStrings = ListUtils.collect(strings,
                new Collector<String, Set<String>>() {
                    @Override
                    public Set<String> create() {
                        return new HashSet<>();
                    }

                    @Override
                    public void add(Set<String> set, String item) {
                        set.add(item);
                    }
                });

        System.out.println("Уникальные строки: " + uniqueStrings);
    }
}