package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> list = users.get(user.get());
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Метод ищет в коллекции пользователя по паспорту.
     *
     * @param passport - паспортные данные.
     * @return - Пользователь или null, если пользователь не найден.
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(p -> p.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод ищет банковский счет по паспорту и реквизитам.
     *
     * @param passport  - паспортные данные.
     * @param requisite - номер счета.
     * @return - банковский счет или null, если счет не найден.
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        return findByPassport(passport).flatMap(x -> users.get(x)
                .stream()
                .filter(a -> a.getRequisite().equals(requisite))
                .findFirst());
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
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        boolean rsl = false;
        if (srcAccount.isPresent()
                && destAccount.isPresent()
                && srcAccount.get().getBalance() >= amount) {
            srcAccount.get()
                    .setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get()
                    .setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}