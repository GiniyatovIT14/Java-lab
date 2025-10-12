package ru.Giniyatov.Contacts;

import java.util.*;

public class TelephoneName {
    private Map<String, String> contacts; // имя -> телефон

    public TelephoneName() {
        this.contacts = new HashMap<>();
    }

    // Проверка на непустоту
    private boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    // Добавление новой пары
    public String addContact(String phone, String name) {
        if (isEmpty(phone) || isEmpty(name)) {
            throw new IllegalArgumentException("Телефон и имя не могут быть пустыми");
        }

        String oldPhone = contacts.put(name.trim(), phone.trim());
        return oldPhone;
    }

    // Удаление по имени
    public String removeContact(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        return contacts.remove(name.trim());
    }

    // Получение телефона по имени
    public String getPhone(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        return contacts.get(name.trim());
    }

    // Проверка наличия имени
    public boolean hasName(String name) {
        if (isEmpty(name)) return false;
        return contacts.containsKey(name.trim());
    }

    // Проверка наличия телефона
    public boolean hasPhone(String phone) {
        if (isEmpty(phone)) return false;
        return contacts.containsValue(phone.trim());
    }

    // Получение количества контактов
    public int getContactCount() {
        return contacts.size();
    }

    // Получение всех пар
    public String[][] getAllPairs() {
        String[][] pairs = new String[contacts.size()][2];
        int i = 0;
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            pairs[i][0] = entry.getKey();    // имя
            pairs[i][1] = entry.getValue();  // телефон
            i++;
        }
        return pairs;
    }

    // Получение всех телефонов
    public String[] getAllPhones() {
        return contacts.values().toArray(new String[0]);
    }

    // Получение всех имен
    public String[] getAllNames() {
        return contacts.keySet().toArray(new String[0]);
    }

    // Получение имен по префиксу
    public String[] getNamesByPrefix(String prefix) {
        if (isEmpty(prefix)) return new String[0];

        List<String> matchingNames = new ArrayList<>();
        String searchPrefix = prefix.trim().toLowerCase();

        for (String name : contacts.keySet()) {
            if (name.toLowerCase().startsWith(searchPrefix)) {
                matchingNames.add(name);
            }
        }
        return matchingNames.toArray(new String[0]);
    }

    @Override
    public String toString() {
        if (contacts.isEmpty()) {
            return "Телефонный справочник пуст";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Телефонный справочник:\n");
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            sb.append(entry.getValue()).append(" - ").append(entry.getKey()).append("\n");
        }
        return sb.toString();
    }
}