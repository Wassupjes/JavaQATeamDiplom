package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }
    @Test
    public void shouldNotPayWhenLessMinBalance() {
        SavingAccount account = new SavingAccount(2_000, 1_500, 10_000, 5);

        account.pay(1_000);

        int expected = 2_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldAddEqualToMaxBalance() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);

        account.add(8_000);

        int expected = 10_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }
    @Test 
    public void shouldBalanceAboveTheMin() {
        SavingAccount account = new SavingAccount(
                3_000,
                1_000,
                10_000,
                5
        );

        Assertions.assertTrue(account.pay(2_000));
    }
    @Test
    public void shouldShowExceptionInitialBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> new SavingAccount(500, 1_000, 10_000, 5));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SavingAccount(11_000, 1_000, 10_000, 5));
    }
    @Test
    public void shouldShowExceptionMinBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> new SavingAccount(2_000, -1_000, 10_000, 5));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SavingAccount(2_000, 11_000, 10_000, 5));
    }
    @Test
    public void shouldCountRate() {
        SavingAccount account = new SavingAccount(50, 0, 10_000, 10);

        int expected = 5;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }
}
