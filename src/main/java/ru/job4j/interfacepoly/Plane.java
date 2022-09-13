package ru.job4j.interfacepoly;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летает по воздуху");
    }

    @Override
    public void speed() {
        System.out.println("Максимальная скорость " + getClass().getSimpleName() + " 800 км / час");
    }
}
