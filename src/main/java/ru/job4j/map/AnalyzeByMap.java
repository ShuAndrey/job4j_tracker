package ru.job4j.map;

import java.util.*;

/**
 * Класс AnalyzeByMap получает статистику по аттестатам.
 *
 * @author Andrey Shulgin
 */
public class AnalyzeByMap {
    /**
     * Метод averageScore вычисляет общий средний балл.
     *
     * @param pupils список учеников.
     * @return - общий средний балл.
     */
    public static double averageScore(List<Pupil> pupils) {
        List<Label> labels = averageScoreByPupil(pupils);
        double allSumScore = 0;
        for (Label label : labels) {
            allSumScore += label.score();
        }
        return allSumScore / labels.size();
    }

    /**
     * Метод averageScoreByPupil вычисляет средний балл по каждому ученику.
     *
     * @param pupils список учеников.
     * @return средний балл по каждому ученику.
     */
    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        int sumScore = 0;
        int count = 0;
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumScore += subject.score();
                count++;
            }
            result.add(new Label(pupil.name(), (double) sumScore / count));
            sumScore = 0;
            count = 0;
        }
        return result;
    }

    /**
     * Метод averageScoreBySubject вычисляет средний балл по каждому предмету.
     *
     * @param pupils список учеников.
     * @return средний балл по каждому предмету.
     */
    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = mapOfSubjects(pupils);
        List<Label> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result.add(new Label(entry.getKey(), (double) entry.getValue() / pupils.size()));
        }
        return result;
    }

    /**
     * Метод bestStudent - возвращает лучшего ученика.
     * Лучшим считается ученик с наибольшим баллом по всем предметам.
     *
     * @param pupils список учеников.
     * @return лучшый ученик.
     */
    public static Label bestStudent(List<Pupil> pupils) {
        int sumScore = 0;
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumScore += subject.score();
            }
            result.add(new Label(pupil.name(), sumScore));
            sumScore = 0;
        }
        Collections.sort(result);
        return result.get(result.size() - 1);
    }

    /**
     * Метод bestSubject - возвращает предмет с наибольшим баллом для всех студентов.
     *
     * @param pupils список учеников.
     * @return предмет с наибольшим баллом для всех студентов.
     */
    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = mapOfSubjects(pupils);
        List<Label> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result.add(new Label(entry.getKey(), entry.getValue()));
        }
        Collections.sort(result);
        return result.get(result.size() - 1);
    }

    /**
     * Метод собирает карту из предметов и суммарных баллов по нему.
     *
     * @param pupils список учеников.
     * @return карта.
     */
    private static LinkedHashMap<String, Integer> mapOfSubjects(List<Pupil> pupils) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.putIfAbsent(subject.name(), 0);
                map.computeIfPresent(subject.name(), (a, b) -> b + subject.score());
            }
        }
        return map;
    }
}