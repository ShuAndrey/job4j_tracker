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
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            while (matches < 1 || matches > 3) {
                System.out.println("Число не 1 - 3, повторите ввод.");
                matches = Integer.parseInt(input.nextLine());
            }
            count -= matches;
            while (count < 0) {
                System.out.println("На столе спичек меньше чем вы хотите взять, повторите попытку.");
                count += matches;
                matches = Integer.parseInt(input.nextLine());
                count -= matches;
            }
            System.out.println("Осталось : " + count);
            turn = !turn;
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}