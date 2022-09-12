package ru.job4j.poly;

public class Bus implements Transport {

    public static void main(String[] args) {
        Bus bus = new Bus();
        bus.drive();
        bus.numberOfPassengers(15);
        double fillPrise = bus.prise(55);
        System.out.println("На заправку автобуса было потрачено " + fillPrise + " рублей");
    }

    @Override
    public void drive() {
            System.out.println("Автобус едит");
    }

    @Override
        public void numberOfPassengers(int passengers) {
            if (passengers > 0) {
                System.out.println("В автобусе находится " + passengers + " пасажиров");
            } else {
                System.out.println("В автобусе нет пасажиров");
            }
        }

    @Override
    public double prise(int fill) {
        double oil = 53.80;
        return oil * fill;
        }
}
