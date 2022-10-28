package ru.job4j.lamda;

import java.util.function.Supplier;

/**
 * Класс показывает зону видимости переменных в лямбда-выражениях:
 * <p> 1. Переменная, объявленная внутри лямбда-выражения, доступна только в самом лямбда-выражении.
 * <p> 2. Переменная, объявленная вне лямбда-выражения, доступна как внутри лямбда-выражения, так и вне его.
 * <p> 3. Переменную, объявленную вне лямбда-выражения, изменять внутри лямбда-выражения нельзя.
 *
 * @version 1.0
 */
public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 12, 3};
        int total = 0;
        for (int num : number) {
            int finalTotal = total;
            total = add(
                    () -> finalTotal + num
            );
        }
        System.out.println(total);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}
