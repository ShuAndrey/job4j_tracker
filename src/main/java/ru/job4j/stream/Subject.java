package ru.job4j.stream;

/**
 * Модель данных предмет.
 *
 * @author Andrey Shulgin
 */
public class Subject {
    private String name;
    private int score;

    public Subject(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}