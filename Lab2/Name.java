class Name {
    private String lastName;
    private String firstName;
    private String patronymic;

    public Name() {         // по умолчанию
        this.lastName = null;
        this.firstName = null;
        this.patronymic = null;
    }

    public Name(String lastName, String firstName, String patronymic) {         // с заданными параметрами
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPatronymic() {
        return patronymic;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        if (lastName != null && !lastName.trim().isEmpty()) {
            result.append(lastName.trim());
        }

        if (firstName != null && !firstName.trim().isEmpty()) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(firstName.trim());
        }

        if (patronymic != null && !patronymic.trim().isEmpty()) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(patronymic.trim());
        }

        return result.toString();
    }
}