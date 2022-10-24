package ru.job4j.collection.bank;

import java.util.Objects;

/**
 * Класс описывает пользователя банка.
 */
public class User {
    /**
     * Пользователь банка должен иметь: номер паспорта и ФИО (username).
     */
    private String passport;
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * @return возвращает паспорт
     */
    public String getPassport() {
        return passport;
    }

    /**
     * @param passport изменяет паспорт
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * @return возвращает ФИО
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username изменяет ФИО
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
