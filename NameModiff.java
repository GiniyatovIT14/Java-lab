public class NameModiff {
    private String firstName;
    private String lastName;
    private String patronymic;

    public NameModiff() {
        this.firstName = null;
        this.lastName = null;
        this.patronymic = null;
    }

    public NameModiff(String firstName) {
        this.firstName = firstName;
        this.lastName = null;
        this.patronymic = null;
    }

    public NameModiff(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = null;
    }

    public NameModiff(String firstName, String lastName, String patronymic) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
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
