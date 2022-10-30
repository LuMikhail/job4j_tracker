package ru.job4j.stream.listaddress;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс реализует метод, который позволит преобразовать список профилей в список адресов.
 *
 * @version 1.0
 */

public class Profiles {

    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }
}
