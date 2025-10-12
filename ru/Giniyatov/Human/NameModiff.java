package ru.Giniyatov.Human;

public class NameModiff {
    private final String firstName;
    private final String lastName;
    private final String patronymic;

    public NameModiff(String firstName) {
        checkOneNoneEmpty(firstName, null, null);
        this.firstName = isEmpty(firstName) ? null : firstName.trim();
        this.lastName = null;
        this.patronymic = null;
    }

    public NameModiff(String firstName, String lastName) {
        checkOneNoneEmpty(firstName, lastName, null);
        this.firstName = isEmpty(firstName) ? null : firstName.trim();
        this.lastName = isEmpty(lastName) ? null : lastName.trim();
        this.patronymic = null;
    }

    public NameModiff(String firstName, String lastName, String patronymic) {
        checkOneNoneEmpty(firstName, lastName, patronymic);
        this.firstName = isEmpty(firstName) ? null : firstName.trim();
        this.lastName = isEmpty(lastName) ? null : lastName.trim();
        this.patronymic = isEmpty(patronymic) ? null : patronymic.trim();
    }

    private void checkOneNoneEmpty(String firstName, String lastName, String patronymic) {
        boolean hasFirst = !isEmpty(firstName);
        boolean hasLast = !isEmpty(lastName);
        boolean hasPatronymic = !isEmpty(patronymic);

        if (!hasFirst && !hasLast && !hasPatronymic) {
            throw new IllegalArgumentException("Как минимум один параметр должен быть не пустым!");
        }
    }

    private boolean isEmpty(String name) {
        return name == null || name.trim().isEmpty();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        if (lastName != null) {
            result.append(lastName);
        }

        if (firstName != null) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(firstName);
        }

        if (patronymic != null) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(patronymic);
        }

        return result.toString();
    }
}
