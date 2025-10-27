// Коробка для хранения одного объекта
public class Box<T> {
    private T item;

    public Box() {
        this.item = null;
    }

    public Box(T item) {
        this.item = item;
    }

    // Положить объект в коробку
    public void put(T item) {
        if (this.item != null) {
            throw new IllegalStateException("Коробка уже занята!");
        }
        this.item = item;
    }

    // Извлечь объект из коробки
    public T get() {
        if (this.item == null) {
            throw new IllegalStateException("Коробка пуста!");
        }
        T temp = this.item;
        this.item = null;
        return temp;
    }

    // Получить значение как double для чисел
    // +метод для задачи 3.2.2
    public double getAsDouble() {
        if (this.item == null) {
            throw new IllegalStateException("Коробка пуста!");
        }
        if (this.item instanceof Number) {
            return ((Number) this.item).doubleValue();
        }
        throw new IllegalStateException("Коробка не содержит число!");
    }

    // Проверить заполненность
    public boolean isFull() {
        return this.item != null;
    }

    // Проверить пустоту
    public boolean isEmpty() {
        return this.item == null;
    }

    // Проверить содержит ли число
    public boolean containsNumber() {
        return this.item != null && this.item instanceof Number;
    }

    @Override
    public String toString() {
        if (item == null) {
            return "Коробка{пустая}";
        } else {
            return "Коробка{объект=" + item + " (" + item.getClass().getSimpleName() + ")}";
        }
    }
}