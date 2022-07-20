package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Класс с методами поиска студента и предмета.
 *
 * @author Andrey Shulgin
 */
public record College(Map<Student, Set<Subject>> students) {

    /**
     * Метод поиска студента по аккаунту.
     *
     * @param account - аккаунт.
     * @return - студент.
     */
    public Optional<Student> findByAccount(String account) {
        Optional<Student> rsl = Optional.empty();
        for (Student s : students.keySet()) {
            if (account.equals(s.getAccount())) {
                rsl = Optional.of(s);
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод поиска предмета по аккаунту и имени.
     *
     * @param account - аккаунт.
     * @param name    - имя.
     * @return - предмет.
     */
    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Subject> rsl = Optional.empty();
        Optional<Student> s = findByAccount(account);
        if (s.isPresent()) {
            Set<Subject> subjects = students.get(s.get());
            for (Subject subj : subjects) {
                if (name.equals(subj.name())) {
                    rsl = Optional.of(subj);
                    break;
                }
            }
        }
        return rsl;
    }
}