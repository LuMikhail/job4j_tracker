package ru.job4j.stream.listaddress;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс позволяет с помощью реализованных в нем методов:
 * <p> 1. Преобразовать список профилей в список адресов.
 * <p> 2. Отсортировать список адресов, удаляя дубликаты.
 * @version 1.0
 */

public class Profiles {

    /**
     * Метод, преобразует список профилей в список адресов
     *
     * @param profiles входящий класс типа Profile.
     * @return возвращает класс тапа Address.
     */
    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }

    /**
     * Метод, преобразует список профилей в список адресов, сортируя адреса по городу и удаляет дубликаты.
     *
     * @param profiles входящий класс типа Profile.
     * @return возвращает класс тапа Address.
     */
    public static List<Address> collectSortWithoutDuplicate(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .sorted(Comparator.comparing(Address::getCity))
                .distinct()
                .collect(Collectors.toList());
    }
}
