package ru.job4j.collection.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковской системы, которая позволяет:
 * 1. Регистрировать пользователя.
 * <p>
 * 2. Удалять пользователя из системы.
 * <p>
 * 3. Добавлять пользователю банковский счет. У пользователя системы могут быть несколько счетов.
 * <p>
 * 4. Переводить деньги с одного банковского счета на другой счет.
 *
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение всех пользователей системы с привязанными к ним счетами
     * осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в систему.
     * Если он есть, то новый не добавляется.
     *
     * @param user пользователь, который добавляется в систему.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавляет новый счет к пользователю.
     * Счет добавляется только, если такого счета у пользователя еще нет.
     * Пользователь определяется по паспорту.
     * Для этого используется метод findByPassport.
     * Если пользователь найден - получаем список всех его счетов, после чего
     * добавляется новый счет к ним.
     *
     * @param passport паспорт пользователя.
     * @param account  счет пользователя.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accountsNew = users.get(user);
            if (!accountsNew.contains(account)) {
                accountsNew.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта.
     *
     * @param passport паспорт пользователя.
     * @return возвращает пользователя, если входящий passport совпал с passport пользователя.
     * Если паспорт не найден - метод возвращает null.
     */
    public User findByPassport(String passport) {
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                return key;
            }
        }
        return null;
    }

    /**
     * Метод ищет счет пользователя по реквизитам.
     * Находим пользователя по паспорту с помощью метода findByPassport.
     * Если пользователь найден.
     * Получаем список счетов этого пользователя и в нем находим нужный счет.
     *
     * @param passport  паспорт пользователя.
     * @param requisite рекзвизиты пользователя.
     * @return возвращает счет пользователя и null, если счет не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод предназначен для перечисления денег с одного счёта на другой счёт.
     *
     * @param srcPassport   паспорт отправителя.
     * @param srcRequisite  реквизиты отправителя.
     * @param destPassport  паспорт получателя.
     * @param destRequisite реквизиты получателя.
     * @param amount        сумма, которую нужно перевести со счета отправителя на счет получателя.
     * @return если счёт отстуствуют у отправителя и получателя,
     * и не достаточно для перевода денег на счёту отправителя, то метод должен вернуть false,
     * в остальных случаях - true.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account accountScr = findByRequisite(srcPassport, srcRequisite);
        Account accountDest = findByRequisite(destPassport, destRequisite);
        if (accountScr != null
                && accountDest != null
                && accountScr.getBalance() >= amount) {
            accountScr.setBalance(accountScr.getBalance() - amount);
            accountDest.setBalance(accountDest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }

}
