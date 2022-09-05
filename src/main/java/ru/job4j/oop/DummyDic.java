package ru.job4j.oop;

public class DummyDic {

    public String engToRus(String eng) {
        return eng;
    }

    public static void main(String[] args) {
        DummyDic unknown = new DummyDic();
        String eng = unknown.engToRus("аброкадабра");
        System.out.println("Неизвестное слово " + eng);
    }
}
