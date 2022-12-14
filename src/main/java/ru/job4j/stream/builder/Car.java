package ru.job4j.stream.builder;

import java.time.LocalDate;

/**
 * Класс реализует шаблон проектирования "Строитель".
 *
 * @version 1.0
 */
public class Car {
    private String brand;

    private String model;

    private LocalDate created;

    private double volume;

    private String color;

    /**
     * Статический вложенный класс.  Заменяет конструктор с большим количеством параметров.
     */
    static class Builder {
        private String brand;
        private String model;
        private LocalDate created;
        private double volume;
        private String color;

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildCreated(LocalDate created) {
            this.created = created;
            return this;
        }

        Builder buildVolume(double volume) {
            this.volume = volume;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        /**
         * Метод, который сознает готовый объект.
         * @return возвращает экземпляр класса Car.
         */
        Car build() {
            Car car = new Car();
            car.brand = brand;
            car.model = model;
            car.created = created;
            car.volume = volume;
            car.color = color;
            return car;
        }
    }

    @Override
    public String toString() {
        return "Car{"
                + "brand='" + brand + '\''
                + ", model='" + model + '\''
                + ", created=" + created
                + ", volume=" + volume
                + ", color='" + color + '\'' + '}';
    }

    public static void main(String[] args) {
        Car car = new Builder()
                .buildBrand("Toyota")
                .buildModel("Camry")
                .buildCreated(LocalDate.of(2021, 6, 1))
                .buildVolume(2.5)
                .buildColor("Red")
                .build();
        System.out.println(car);
        Car chery = new Builder()
                .buildBrand("Chery")
                .buildModel("Tiggo 7 Pro")
                .buildCreated(LocalDate.of(2022, 7, 15))
                .build();
        System.out.println(chery);
    }
}
