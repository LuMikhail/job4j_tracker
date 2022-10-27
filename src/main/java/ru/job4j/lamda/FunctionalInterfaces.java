package ru.job4j.lamda;

import java.util.*;
import java.util.function.*;

/**
 * Класс показывает работу встроенных функциональных интерфейсов:
 * <p>1. Вставка элементов в карту с использованием BiConsumer.
 * <p>2. Проверка валидности с использованием BiPredicate.
 * <p>3. Создание ArrayList из значений Map с использованием Supplier.
 * <p>4. Вывод на консоль строк при помощи Consumer
 * с последующим их преобразованием в верхний регистр с помощью Function.
 *
 * @version 1.0
 */
public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biCon = (i, s) -> map.put(i, s);

        biCon.accept(1, "one");
        biCon.accept(2, "two");
        biCon.accept(3, "three");
        biCon.accept(4, "four");
        biCon.accept(5, "five");
        biCon.accept(6, "six");
        biCon.accept(7, "seven");

        System.out.println(map);

        BiPredicate<Integer, String> biPred = (i, s) -> i % 2 == 0 || map.get(i).length() == 4;
        for (Integer i : map.keySet()) {
            if (biPred.test(i, map.get(i))) {
                System.out.println("key: " + i + " value: " + map.get(i));
            }
        }

        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());
        List<String> strings = sup.get();
        System.out.println(strings);

        Consumer<String> con = s -> System.out.println(s);
        Function<String, String> func = s -> s.toUpperCase();
        for (String s : strings) {
            con.accept(func.apply(s));
        }
    }
}
