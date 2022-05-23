package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            if (count == 2) {
                System.out.println(player + " введите число от 1 до 2:");
            } else if (count == 1) {
                System.out.println(player + " введите число 1:");
            } else {
                System.out.println(player + " введите число от 1 до 3:");
            }
            int matches = Integer.parseInt(input.nextLine());
            int temp = count - matches;
            if (matches >= 1 && matches <= 3 && temp >= 0) {
                count -= matches;
                System.out.println("Осталось : " + count);
                turn = !turn;
            } else if (temp < 0) {
                System.out.println("Вы пытаетесь ввести число, которое превышает остаток равный " + count);
            } else {
                System.out.println("Введенное число не 1 - 3. Повторите попытку.");
            }
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}