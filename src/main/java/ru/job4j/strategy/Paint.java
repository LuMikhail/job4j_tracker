package ru.job4j.strategy;

public class Paint {
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Paint contexst = new Paint();
        contexst.draw(new Triangle());
        contexst.draw(new Square());
    }
}
