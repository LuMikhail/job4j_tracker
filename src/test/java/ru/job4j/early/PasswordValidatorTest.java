package ru.job4j.early;

import org.junit.jupiter.api.Test;
import ru.job4j.ex.Fact;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void isPassworValidateTrue() {
        String checkValidate = "Fgdf1!tu";
        String expected = "Fgdf1!tu";
        assertThat(checkValidate).isEqualTo(expected);
    }

    @Test
    public void whenPasswordHaveNull() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator password = new PasswordValidator();
                    password.validate("");
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль не может быть null.");
    }

    @Test
    public void whenPasswordOutOfRange() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator password = new PasswordValidator();
                    password.validate("12");
                });
        assertThat(exception.getMessage()).isEqualTo("Длина пароля выходит за диапазон [8, 32].");
    }

    @Test
    public void whenPasswordHaveUpperCase() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator password = new PasswordValidator();
                    password.validate("12popok!dsfc");
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль должен содержать хотя бы один символ в верхнем регистре.");
    }

    @Test
    public void whenPasswordHaveLowerCase() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator password = new PasswordValidator();
                    password.validate("R25WFS!HGV");
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль должен содержать хотя бы один символ в нижнем регистре.");
    }

    @Test
    public void whenPasswordHaveDigit() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator password = new PasswordValidator();
                    password.validate("RWfdFS!HGV");
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль должен содержать хотя бы одну цифру.");
    }

    @Test
    public void whenPasswordHaveSpecialChars() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator password = new PasswordValidator();
                    password.validate("dfDPVwscg154");
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль должен содержать хотя бы один спец. символ.");
    }

    @Test
    public void whenPasswordHaveNotSubstring() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator password = new PasswordValidator();
                    password.validate("sdfdGS!12345S5");
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль не должен содержать эти подстроки: \"qwerty, 12345, password, admin, user\".");
    }
}