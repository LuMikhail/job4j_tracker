package ru.job4j.interfacepoly;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " передвигается по рельсам.");
    }

    @Override
    public void speed() {
        System.out.println("Максимальная скорость " + getClass().getSimpleName() + " 200 км / час.");
    }
}
