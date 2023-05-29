package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает сервис банковской системы
 * Возможности:
 * 1. Регистрировать пользователя
 * 2. Удалять пользователя
 * 3. Добавлять пользователю банковкий счет
 * 4. Переводить деньги с одного счета на другой
 */
public class BankService {
    /**
     * Поле содержит всех пользователей системы
     * Используется коллекция типа HashMap
     * Ключ - Пользователь
     * Значение - Список счетов
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя
     * А также создается пустой список счетов
     * @param user пользователь, которого хотим добавить
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удаляет пользователя
     * @param passport - паспорт пользователя, которого хотим удалить
     * @return - true, если удаление произошло
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Добавляет новый счет к пользователю
     * @param passport - парспорт пользователя
     * @param account - счет для добавления
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по паспорту
     * @param passport - паспорт пользователя
     * @return - возвращает найденного пользователя
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод ищет счет пользователя по реквизитам
     * @param passport - паспорт пользователя
     * @param requisite - реквизиты аккаунта
     * @return - возвращает найденный аккаунт
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод перечисляет деньги с src счета на dest счет
     * @param srcPassport - паспорт src аккаунта
     * @param srcRequisite - реквизиты src аккаунта
     * @param destPassport - паспорт dest аккаунта
     * @param destRequisite - реквизиты dest аккаунта
     * @param amount - сумма перечисляемых денег
     * @return - возвращает true, при успешном перечислении
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount == null || destAccount == null || srcAccount.getBalance() < amount) {
            return false;
        }
        srcAccount.setBalance(srcAccount.getBalance() - amount);
        destAccount.setBalance(destAccount.getBalance() + amount);
        return true;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
