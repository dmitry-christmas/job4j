package ru.job4j.bank;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class BankTest {
    Bank bank = new Bank();
    User dmitry = new User("Dmitry", "17 645230");
    User petr = new User("Petr", "17 655445");
    Account petrAccount1 = new Account(200.00, "0001");
    Account petrAccount2 = new Account(300.00, "0002");
    @Before
    public void makingDatabase() {
        bank.addUser(dmitry);
        bank.addUser(petr);
        bank.addAccountToUser("17 655445", petrAccount1);
        bank.addAccountToUser("17 655445", petrAccount2);
    }
    @Test
    public void addUserTest() {
        bank.addUser(new User("Petr", "17 655445"));
        User[] expected = {dmitry, petr};
        /*
        не понимаю, почему не работает команда ниже, но та же команда в assertThat работает
        User[] userSet = bank.getBankDatabase().keySet().toArray();
        */
        assertThat(bank.getBankDatabase().keySet().toArray(), is(expected));
    }
    @Test
    public void deleteUserTest() {
        bank.deleteUser(petr);
        assertThat(bank.getBankDatabase().containsKey(petr), is(false));
    }
    @Test
    public void addAccountToUser() {
        bank.addAccountToUser("17 645230", new Account(100.00, "1001"));
        assertThat(bank.getBankDatabase().get(dmitry).get(0).getValue(), is(100.00));
    }
    @Test
    public void deleteAccountTest() {
        bank.deleteAccountFromUser("17 655445", petrAccount1);
        assertThat(bank.getBankDatabase().get(petr).indexOf(petrAccount1), is(-1));
    }
    @Test
    public void getUserAccountsTest() {
        bank.addAccountToUser("17 655445", petrAccount2);
        Account[] expected = {petrAccount1, petrAccount2};
        assertThat(bank.getUserAccounts("17 655445").toArray(), is(expected));
    }
    @Test
    public void transferTest() {
        bank.addAccountToUser("17 645230", new Account(100.00, "1001"));
        bank.transferMoney("17 645230", "1001", "17 655445", "0002", 100.00);
        assertThat(bank.getBankDatabase().get(dmitry).get(0).getValue(), is(0.0));
    }
    @Test
    public void transferTestError()  {
        bank.addAccountToUser("17 645230", new Account(100.00, "1001"));
        bank.transferMoney("17 645230", "1001", "17 655445", "0002", 200.00);
        assertThat(bank.getUserAccounts("17 645230").get(0).getValue(), is(100.00));
    }
    @Test (expected = MoneyOutException.class)
    public void transferTestException()  {
        bank.addAccountToUser("17 645230", new Account(100.00, "1001"));
        bank.transferMoney("17 645230", "1001", "17 655445", "0002", 200.00);
    }
}
