package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Я великий Оракул. Что ты хочешь узнать");
        String question = input.nextLine();
        Random fortune = new Random();
        int answer = fortune.nextInt(2);
        if (answer == 0) {
            System.out.println("Отвечаю на твой вопрос \"" + question + "\" Да");
        } else if (answer == 1) {
            System.out.println("Отвечаю на твой вопрос \"" + question + "\" Нет");
        } else {
            System.out.println("Отвечаю на твой вопрос \"" + question + "\" Может быть");
        }
    }
}
