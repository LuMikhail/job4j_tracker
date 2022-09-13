package ru.job4j.interfacepoly;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " двигается по скоростным трассам.");
    }

    @Override
    public void speed() {
        System.out.println("Максимальная скорость " + getClass().getSimpleName() + " 110 км / час.");
    }
}
