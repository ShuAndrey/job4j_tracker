package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс реализует простейшую версию банковских переводов.
 *
 * @author Andrey Shulgin
 */
public class BankService {
    /**
     * Коллекция хранит пользователей и привязанные к ним банковские счета.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в коллекцию, если он не был добавлен до этого.
     *
     * @param user - пользователь.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет пользователю счет.
     *
     * @param passport - паспортные данные пользователя.
     * @param account  - банковский счет который необходимо добавить пользователю.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> list = users.get(user);
        if (!list.contains(account)) {
            list.add(account);
        }
    }

    /**
     * Метод ищет в коллекции пользователя по паспорту.
     *
     * @param passport - паспортные данные.
     * @return - Пользователь или null, если пользователь не найден.
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(p -> p.getPassport().equals(passport))
                .findFirst().orElse(null);
    }

    /**
     * Метод ищет банковский счет по паспорту и реквизитам.
     *
     * @param passport  - паспортные данные.
     * @param requisite - номер счета.
     * @return - банковский счет или null, если счет не найден.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        return user != null
                ? users.get(user)
                .stream()
                .filter(a -> a.getRequisite().equals(requisite))
                .findFirst().orElse(null)
                : null;
    }

    /**
     * Метод производит перевод с одного счета на другой.
     *
     * @param srcPassport   - паспортные данные делающего перевод.
     * @param srcRequisite  - банковский счет делающего перевод.
     * @param destPassport  - паспортные данные принимающего перевод.
     * @param destRequisite - банковский счет принимающего перевод.
     * @param amount        - сумма перевода.
     * @return - возвращает true если перевод был успешен.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        boolean rsl = srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount;
        if (rsl) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
        }
        return rsl;
    }
}