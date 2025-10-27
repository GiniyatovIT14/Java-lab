// Класс числового значения, реализующий интерфейс Comparable
class NumberValue implements Comparable<NumberValue> {
    private int value;

    public NumberValue(int value) {
        this.value = value;
    }

    // Реализация метода compare
    @Override
    public int compare(NumberValue other) {
        if (this.value < other.value) {
            return -1;
        } else if (this.value > other.value) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "NumberValue{value=" + value + "}";
    }

    public int getValue() { return value; }
}