package ru.job4j.early;

import ru.job4j.ex.UserInvalidException;
import ru.job4j.ex.UserNotFoundException;

import java.util.Arrays;
import java.util.Locale;

public class PasswordValidator {

    public static String validate(String password) {
        char[] passwordChar = password.toCharArray();
        if (password.equals("")) {
            throw new IllegalArgumentException("Пароль не может быть null.");
        }
        if (passwordChar.length < 8 || passwordChar.length >= 33) {
            throw new IllegalArgumentException("Длина пароля выходит за диапазон [8, 32].");
        }
        if (password.toLowerCase().equals(password)) {
            throw new IllegalArgumentException("Пароль должен содержать хотя бы один символ в верхнем регистре.");
        }
        if (password.toUpperCase().equals(password)) {
            throw new IllegalArgumentException("Пароль должен содержать хотя бы один символ в нижнем регистре.");
        }
        if (!findNumber(password)) {
            throw new IllegalArgumentException("Пароль должен содержать хотя бы одну цифру.");
        }
        if (!checkSpecialChars(password)) {
            throw new IllegalArgumentException("Пароль должен содержать хотя бы один спец. символ.");
        }
        if (checkSubstring(password)) {
            throw new IllegalArgumentException("Пароль не должен содержать эти подстроки: \"qwerty, 12345, password, admin, user\".");
        }
        return password;
    }

    public static void main(String[] args) throws UserNotFoundException {
        String rsl = "ПРur2И*ВЕТyРА1н";
        String rsl2 = "";
        validate(rsl);
        validate(rsl2);
    }

    private static boolean findNumber(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkSpecialChars(String rsl) {
        String specialChars = "\"/*!@#$%^&()\\\"{}_[]|\\\\?/<>,.\";";
        char currentChar;
        boolean specialChar = false;

        for (int i = 0; i < rsl.length(); i++) {
            currentChar = rsl.charAt(i);
            if (specialChars.contains(String.valueOf(currentChar))) {
                specialChar = true;
                break;
            }
        }
        return specialChar;
    }

    private static boolean checkSubstring(String rsl) {
        return rsl.toLowerCase().contains("qwerty") || rsl.toLowerCase().contains("password") || rsl.contains("12345")
                || rsl.toLowerCase().contains("admin") || rsl.toLowerCase().contains("user");
    }
}
