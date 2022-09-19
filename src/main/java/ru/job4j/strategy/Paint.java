package ru.job4j.strategy;

public class Paint {
    public void drow(Shape shape) {
        System.out.println(shape.drow());
    }

    public static void main(String[] args) {
        Paint contexst = new Paint();
        contexst.drow(new Triangle());
        contexst.drow(new Square());
    }
}
