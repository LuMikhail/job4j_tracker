package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс генерировать ярлыки для продуктов со скидкой
 */
public class ProductLabel {

    /**
     * Метод создает список продуктов со скидкой в 50%, если продукт выходить из срока годности через 3 дня:
     * <p>1. Фильтруем продукты если срок годности заканчивается через три дня.</p>
     * <p>2. Переносим отфильтрованные продукты в класс типа Label с уменьшением их прайсовой цены на 50%.</p>
     * <p>3. Создаем список продуктов типа String со скидкой.</p>
     * @param products входящие данные из класса Product
     * @return возвращает продукты со скидкой из класса Label в виде строки.
     *
     * @version 1.0
     */
    public List<String> generateLabels(List<Product> products) {
        List<String> result = products.stream()
                .filter(f -> f.getActual() <= f.getStandard())
                .filter(f -> f.getStandard() - f.getActual() < 4)
                .map(f -> new Label(f.getName(), f.getPrice() * 50 / 100))
                .map(f -> f.getName() + " " + f.getPrice())
                .collect(Collectors.toList());
        return result;
    }
}
