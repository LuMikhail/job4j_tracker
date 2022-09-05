package ru.job4j.inheritance;

public class PizzaExtraCheese extends Pizza {
    public static final String PIZZA_EXTRA = " with cheese Mozzarella";

    @Override
    public String name() {
        return super.name() + PIZZA_EXTRA;
    }
}
