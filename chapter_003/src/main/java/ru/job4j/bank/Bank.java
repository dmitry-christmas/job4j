package ru.job4j.bank;
/**
 * Класс банка.
 * @author Dmitry Rozhdestvenskiy (dmr1433@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Bank {
    /**
     * База данных банка в виде TreeMap. Ключом является User, данными - ArrayList со счетами пользователя.
     */
    private TreeMap<User, List<Account>> bankDatabase = new TreeMap<>();

    public TreeMap<User, List<Account>> getBankDatabase() {
        return bankDatabase;
    }
    /**
     * Метод добавления нового пользователя.
     * @param user новый пользователь.
     */
    public void addUser(User user) {
        bankDatabase.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаления пользователя.
     * @param user Пользователь, которого нужно удалить.
     */
    public void deleteUser(User user) {
        bankDatabase.remove(user);
    }

    /**
     * Метод добавления аккаунта к пользователю.
     * @param passport Паспортные данные пользователя.
     * @param account Добавляемый аккаунт.
     */
    public void addAccountToUser(String passport, Account account) {
        /*List<Account> accounts = getUserAccounts(passport);
        if (accounts != null && !accounts.contains(account)) {
            accounts.add(account);
        }*/
        if (account != null) {
            bankDatabase.computeIfPresent(userSearch(passport), (user, list) -> {
                if (!list.contains(account)) {
                    list.add(account);
                }
                return list;
                }
            );
        }
    }
    /**
     * Метод удаления аккаунта у пользователя.
     * @param passport паспортные данные пользователя.
     * @param account удаляемый аккаунт.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        for (User user : bankDatabase.keySet()) {
            if (user.getPassport().equals(passport)) {
                bankDatabase.get(user).remove(account);
                break;
            }
        }
    }

    /**
     * Метод получения списка с аккаунтами клиента банка.
     * @param passport паспортные данные пользователя.
     * @return ArrayList со списком счетов.
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> result = null;
        for (User user : bankDatabase.keySet()) {
            if (user.getPassport().equals(passport)) {
            result = bankDatabase.get(user);
            break;
            }
        }
        if (result == null) {
            System.out.println("Клиента с паспортом " + passport + "в банке не зарегистрировано!");

        }
        return result;
    }

    /**
     * Метод перевода денег со счёта на счёт.
     * @param srcPassport паспортные данные клиента отправителя.
     * @param srcRequisite реквизиты счёта отправителя.
     * @param destPassport паспортные данные клиента получателя.
     * @param dstRequisite реквизиты счёта получателя.
     * @param amount сумма перевода.
     * @return true, если перевод выполнен.
     */
    public boolean transferMoney(
            String srcPassport, String srcRequisite, String destPassport,
            String dstRequisite, double amount) {
        boolean result = false;
        Account accSrc = accountSearch(srcPassport, srcRequisite);
        Account accDest = accountSearch(destPassport, dstRequisite);
        if (accSrc != null && accDest != null && accSrc.getValue() >= amount) {
                accSrc.transfer(accDest, amount);
                result = true;
            } else {
                System.out.println("Денег на счёте недостаточно!");
            }
        return result;
    }
    /**
     * внутренний метод поиска клиента по паспорту.
     * @param passport паспортные данные клиента.
     * @return возвращает найденного пользователя.
     */
    private User userSearch(String passport) {
        User result = null;
        for (User user : bankDatabase.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = user;
                break;
            }
        }
            if (result == null) {
                System.out.println("Клиента с паспортом " + passport + " в банке нет!");
            }
        return result;
    }
    /**
     * метод поиска банковского счёта пользователя по реквизитам.
     * @param req реквизита счёта.
     * @param user пользователь, у которого ищем счёт.
     * @return возвращает индекс счёта в ArrayList со счетами.
     */
    private int requsitesSearch(String req, User user) {
        int result = -1;
        for (Account account : bankDatabase.get(user)) {
            if (req.equals(account.getRequisites())) {
                result = bankDatabase.get(user).indexOf(account);
                break;
            }
        }
        if (result < 0) {
            System.out.println("Счёта с реквизитами " + req + " в банке нет");
        }
        return result;
    }
    private Account accountSearch(String passport, String req) {
        Account result = null;
        for (User user : bankDatabase.keySet()) {
            if (user.getPassport().equals(passport)) {
                for (Account account : bankDatabase.get(user)) {
                    if (account.getRequisites().equals(req)) {
                        result = account;
                        break;
                    }
                }
            }
            if (result != null) {
                break;
            }
        }
        return result;
    }
}
