package ru.job4j.map;

import java.util.List;

/**
 * Модель данных.
 *
 * @author Andrey Shulgin
 */
public record Pupil(String name, List<Subject> subjects) {
}