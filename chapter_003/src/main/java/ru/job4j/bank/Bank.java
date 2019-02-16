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
        bankDatabase.put(user, new ArrayList<>());
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
        for (User user : bankDatabase.keySet()) {
            if (user.getPassport().equals(passport) && !bankDatabase.get(user).contains(account)) {
                bankDatabase.get(user).add(account);
                break;
            }
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
        List<Account> result = new ArrayList<>();
        for (User user : bankDatabase.keySet()) {
            if (user.getPassport().equals(passport)) {
            result.addAll(bankDatabase.get(user));
            break;
            }
        }
        if (result.size() <= 0) {
            throw new UserOutException("У клиента с паспортом " + passport + " нет банковского счёта!");
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
        try {
            User userSrc = userSearch(srcPassport);
            User userDst = userSearch(destPassport);
            int indexSrc = requsitesSearch(srcRequisite, userSrc);
            int indexDst = requsitesSearch(dstRequisite, userDst);

            Account accSrc = bankDatabase.get(userSrc).get(indexSrc);
            Account accDest = bankDatabase.get(userDst).get(indexDst);
        if (accSrc.getValue() >= amount) {
            accSrc.transfer(accDest, amount);
            result = true;
        } else {
            throw new MoneyOutException("Денег на счёте недостаточно!");
        }
        } catch (UserOutException uoe) {
            System.out.println(uoe.msg);
        } catch (MoneyOutException moe) {
            System.out.println(moe.msg);
        } catch (AccountOutException aoe) {
            System.out.println(aoe.msg);
        } catch (Exception e) {
            System.out.println("перехвачено исключение!");
        }
        return result;
    }

    /**
     * внутренний метод поиска клиента по паспорту.
     * @param passport паспортные данные клиента.
     * @return возвращает найденного пользователя.
     * @throws UserOutException, если пользователь не найден.
     */
    private User userSearch(String passport) throws UserOutException {
        User result = null;
        for (User user : bankDatabase.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = user;
                break;
            }
        }
            if (result == null) {
                throw new UserOutException("Заданы неверные паспортные данные!");
            }

        return result;
    }

    /**
     * метод поиска банковского счёта пользователя по реквизитам.
     * @param req реквизита счёта.
     * @param user пользователь, у которого ищем счёт.
     * @return возвращает индекс счёта в ArrayList со счетами.
     * @throws AccountOutException, если счёт не найден.
     */
    private int requsitesSearch(String req, User user) throws AccountOutException {
        int result = -1;
        for (Account account : bankDatabase.get(user)) {
            if (req.equals(account.getRequisites())) {
                result = bankDatabase.get(user).indexOf(account);
                break;
            }
        }
        if (result < 0) {
            throw new AccountOutException("Заданы неверные реквизиты счёта!");
        }
        return result;
    }
}
