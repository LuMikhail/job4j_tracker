package ru.job4j.early;

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

    private static boolean findNumber(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkSpecialChars(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c) && !Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkSubstring(String rsl) {
        String[] exceptionSubstring = {"qwerty", "password", "12345", "admin", "user"};
        boolean notSubstring = false;
        for (String s : exceptionSubstring) {
            if (rsl.toLowerCase().contains(s)) {
                notSubstring = true;
                break;
            }
        }
        return notSubstring;
    }
}
