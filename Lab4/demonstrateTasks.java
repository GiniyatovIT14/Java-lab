import java.util.*;

// Класс для демонстрационных примеров (готовые данные)
class demonstrateTasks {

    // Демонстрация работы обобщенной коробки с готовыми данными
    public static void demonstrateBox() {
        System.out.println("=== ДЕМОНСТРАЦИЯ: Обобщенная коробка ===");

        // Демонстрация 1: Работа с целыми числами
        System.out.println("\n1. Демонстрация с целыми числами:");
        Box<Integer> intBox = new Box<>();
        intBox.put(3);
        System.out.println("Создана коробка: " + intBox);
        Integer value = intBox.get();
        System.out.println("Извлечено значение: " + value);
        System.out.println("Коробка после извлечения: " + intBox);

        // Демонстрация 2: Работа со строками
        System.out.println("\n2. Демонстрация со строками:");
        Box<String> stringBox = new Box<>("Hello World");
        System.out.println("Создана коробка: " + stringBox);
        String text = stringBox.get();
        System.out.println("Извлеченный текст: " + text);

        // Демонстрация 3: Обработка ошибок
        System.out.println("\n3. Демонстрация обработки ошибок:");
        Box<Double> doubleBox = new Box<>();
        doubleBox.put(3.14);
        System.out.println("Коробка заполнена: " + doubleBox);

        try {
            doubleBox.put(2.71); // Попытка положить второй объект
        } catch (IllegalStateException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println();
    }

    // Демонстрация интерфейса Comparable
    public static void demonstrateComparable() {
        System.out.println("=== ДЕМОНСТРАЦИЯ: Интерфейс Comparable ===");

        // Создаем числовые значения для сравнения
        NumberValue num1 = new NumberValue(10);
        NumberValue num2 = new NumberValue(5);
        NumberValue num3 = new NumberValue(10);
        NumberValue num4 = new NumberValue(15);

        System.out.println("Созданы объекты:");
        System.out.println("1. " + num1);
        System.out.println("2. " + num2);
        System.out.println("3. " + num3);
        System.out.println("4. " + num4);

        // Демонстрируем сравнение
        System.out.println("\nРезультаты сравнения:");

        int result1 = num1.compare(num2);
        System.out.println(num1.getValue() + " vs " + num2.getValue() + ": " + result1 +
                " (" + (result1 < 0 ? "меньше" : result1 > 0 ? "больше" : "равно") + ")");

        int result2 = num2.compare(num1);
        System.out.println(num2.getValue() + " vs " + num1.getValue() + ": " + result2 +
                " (" + (result2 < 0 ? "меньше" : result2 > 0 ? "больше" : "равно") + ")");

        int result3 = num1.compare(num3);
        System.out.println(num1.getValue() + " vs " + num3.getValue() + ": " + result3 +
                " (" + (result3 < 0 ? "меньше" : result3 > 0 ? "больше" : "равно") + ")");

        int result4 = num1.compare(num4);
        System.out.println(num1.getValue() + " vs " + num4.getValue() + ": " + result4 +
                " (" + (result4 < 0 ? "меньше" : result4 > 0 ? "больше" : "равно") + ")");
    }

    // Демонстрация поиска максимума
    public static void demonstrateMaxSearch() {
        System.out.println("=== ДЕМОНСТРАЦИЯ: Поиск максимума в коробках ===");

        // Создаем коробки с разными числовыми типами
        Box<Integer> box1 = new Box<>(42);
        Box<Double> box2 = new Box<>(3.14);
        Box<Float> box3 = new Box<>(100.5f);

        System.out.println("Созданы коробки с числами:");
        System.out.println("1. " + box1);
        System.out.println("2. " + box2);
        System.out.println("3. " + box3);

        // Поиск максимума
        List<Box<? extends Number>> boxList = List.of(box1, box2, box3);
        double max = MathUtils.findMax(boxList);
        System.out.println("\nМаксимальное значение в коробках: " + max);
    }

    // Демонстрация работы функции map
    public static void demonstrateFunction() {
        System.out.println("=== ДЕМОНСТРАЦИЯ: Функциональное преобразование списков ===");

        // 1. Преобразование строк в их длины
        System.out.println("\n1. Строки - Длины строк:");
        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
        System.out.println("Исходный список: " + strings);

        List<Integer> lengths = ListUtils.map(strings, new Function<String, Integer>() {
            @Override
            public Integer apply(String value) {
                return value.length();
            }
        });
        System.out.println("Результат (длины): " + lengths);

        // 2. Преобразование чисел: отрицательные - положительные
        System.out.println("\n2. Числа - Абсолютные значения:");
        List<Integer> numbers = Arrays.asList(1, -3, 7);
        System.out.println("Исходный список: " + numbers);

        List<Integer> absoluteValues = ListUtils.map(numbers, new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer value) {
                return Math.abs(value);
            }
        });
        System.out.println("Результат (абсолютные значения): " + absoluteValues);

        // 3. Преобразование массивов в их максимумы
        System.out.println("\n3. Массивы чисел - Максимумы массивов:");
        List<int[]> arrays = Arrays.asList(
                new int[]{1, 5, 3},
                new int[]{-2, 8, 0},
                new int[]{10, 2, 7}
        );
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
        System.out.println("Результат (максимумы): " + maxValues);
    }

    // Демонстрация работы фильтра
    public static void demonstrateFilter() {
        System.out.println("=== ДЕМОНСТРАЦИЯ: Фильтрация списков ===");

        // 1. Фильтрация строк по длине
        System.out.println("\n1. Фильтрация строк (длина >= 3):");
        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
        System.out.println("Исходный список: " + strings);

        List<String> filteredStrings = ListUtils.filter(strings, new Predicate<String>() {
            @Override
            public boolean test(String value) {
                return value.length() >= 3;
            }
        });
        System.out.println("После фильтрации: " + filteredStrings);

        // 2. Фильтрация положительных чисел
        System.out.println("\n2. Фильтрация положительных чисел:");
        List<Integer> numbers = Arrays.asList(1, -3, 7);
        System.out.println("Исходный список: " + numbers);

        List<Integer> positiveNumbers = ListUtils.filter(numbers, new Predicate<Integer>() {
            @Override
            public boolean test(Integer value) {
                return value > 0;
            }
        });
        System.out.println("Только положительные: " + positiveNumbers);

        // 3. Фильтрация массивов без положительных элементов
        System.out.println("\n3. Фильтрация массивов без положительных элементов:");
        List<int[]> arrays = Arrays.asList(
                new int[]{1, 5, 3},
                new int[]{-2, -8, 0},
                new int[]{-1, -5, -3},
                new int[]{10, 2, 7}
        );
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
                        return false; // есть положительный - не подходит
                    }
                }
                return true; // все элементы не положительные
            }
        });

        System.out.print("Массивы без положительных элементов: ");
        for (int[] arr : arraysWithoutPositives) {
            System.out.print(Arrays.toString(arr) + " ");
        }
        System.out.println();
    }

    // Демонстрация работы свертки
    public static void demonstrateReduce() {
        System.out.println("=== ДЕМОНСТРАЦИЯ: Свертка списков ===");

        // 1. Конкатенация строк
        System.out.println("\n1. Конкатенация строк:");
        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
        System.out.println("Исходный список: " + strings);

        String concatenated = ListUtils.reduce(strings, new Reducer<String>() {
            @Override
            public String reduce(String accumulator, String current) {
                return accumulator + current;
            }
        }, "");
        System.out.println("Результат конкатенации: " + concatenated);

        // 2. Сумма чисел
        System.out.println("\n2. Сумма чисел:");
        List<Integer> numbers = Arrays.asList(1, -3, 7);
        System.out.println("Исходный список: " + numbers);

        Integer sum = ListUtils.reduce(numbers, new Reducer<Integer>() {
            @Override
            public Integer reduce(Integer accumulator, Integer current) {
                return accumulator + current;
            }
        }, 0);
        System.out.println("Сумма: " + sum);

        // 3. Общее количество элементов во вложенных списках
        System.out.println("\n3. Общее количество элементов во вложенных списках:");
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );
        System.out.println("Исходный список списков: " + listOfLists);

        // Способ 1: Прямое вычисление через reduce
        Integer totalCount = ListUtils.reduce(listOfLists, new Reducer<List<Integer>>() {
            @Override
            public List<Integer> reduce(List<Integer> accumulator, List<Integer> current) {
                List<Integer> result = new ArrayList<>(accumulator);
                result.addAll(current);
                return result;
            }
        }, new ArrayList<Integer>()).size();

        System.out.println("Общее количество элементов (способ 1): " + totalCount);

        // Способ 2: Через map и reduce
        Integer totalCount2 = ListUtils.reduce(
                ListUtils.map(listOfLists, new Function<List<Integer>, Integer>() {
                    @Override
                    public Integer apply(List<Integer> value) {
                        return value.size();
                    }
                }),
                new Reducer<Integer>() {
                    @Override
                    public Integer reduce(Integer accumulator, Integer current) {
                        return accumulator + current;
                    }
                },
                0
        );

        System.out.println("Общее количество элементов (способ 2): " + totalCount2);

        // 4. Демонстрация работы с пустым списком
        System.out.println("\n4. Работа с пустым списком:");
        List<String> emptyList = new ArrayList<>();
        String emptyResult = ListUtils.reduce(emptyList, new Reducer<String>() {
            @Override
            public String reduce(String accumulator, String current) {
                return accumulator + current;
            }
        }, "Пустой список");
        System.out.println("Результат для пустого списка: " + emptyResult);
    }

    // Демонстрация работы коллекционирования
    public static void demonstrateCollect() {
        System.out.println("=== ДЕМОНСТРАЦИЯ: Коллекционирование ===");

        // 1. Разбиение на положительные и отрицательные числа
        System.out.println("\n1. Разбиение чисел на положительные и отрицательные:");
        List<Integer> numbers = Arrays.asList(1, -3, 7, -2, 0, 5);
        System.out.println("Исходный список: " + numbers);

        Map<String, List<Integer>> numberGroups = ListUtils.collect(numbers,
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

        System.out.println("Положительные: " + numberGroups.get("positive"));
        System.out.println("Отрицательные: " + numberGroups.get("negative"));
        System.out.println("Нули: " + numberGroups.get("zero"));

        // 2. Группировка строк по длине
        System.out.println("\n2. Группировка строк по длине:");
        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx", "qw", "hello", "a");
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
                        map.computeIfAbsent(length, k -> new ArrayList<>()).add(item);
                    }
                });

        System.out.println("Группы по длине:");
        for (Map.Entry<Integer, List<String>> entry : lengthGroups.entrySet()) {
            System.out.println("  Длина " + entry.getKey() + ": " + entry.getValue());
        }

        // 3. Уникальные строки (Set)
        System.out.println("\n3. Уникальные строки:");
        List<String> duplicateStrings = Arrays.asList("qwerty", "asdfg", "qwerty", "qw", "asdfg");
        System.out.println("Исходный список: " + duplicateStrings);

        Set<String> uniqueStrings = ListUtils.collect(duplicateStrings,
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

        // Дополнительный пример: подсчет частоты слов
        System.out.println("\n4. Подсчет частоты слов:");
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        System.out.println("Исходный список: " + words);

        Map<String, Integer> wordFrequency = ListUtils.collect(words,
                new Collector<String, Map<String, Integer>>() {
                    @Override
                    public Map<String, Integer> create() {
                        return new HashMap<>();
                    }

                    @Override
                    public void add(Map<String, Integer> map, String item) {
                        map.put(item, map.getOrDefault(item, 0) + 1);
                    }
                });

        System.out.println("Частота слов: " + wordFrequency);
    }
}