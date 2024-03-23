package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void payBalanceAboveLimitAfterPurchase() {
        CreditAccount account= new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.pay(5_999);

        Assertions.assertEquals(-4_999,account.getBalance());
    }

    @Test
    public void payBalanceAfterPurchaseEqualLimit() {
        CreditAccount account= new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.pay(6_000);

        Assertions.assertEquals(-5_000,account.getBalance());
    }
    @Test
    public void payBalanceLessThanLimitAfterPurchase() {
        CreditAccount account= new CreditAccount(
                1_000,
                5_000,
                15
        );

        boolean expected = false;
        boolean actual = account.pay(6_001);

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void replenishmentBalanceGreaterThanZero() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );
        account.add(1);

        Assertions.assertEquals(1_001, account.getBalance());
    }

    @Test
    public void replenishmentBalanceEqualZero() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                5
        );


        boolean expected = false;
        boolean actual = account.add(0);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void replenishmentBalanceLessThanZero() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                5
        );


        boolean expected = false;
        boolean actual = account.add(-1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calculationOfInterestOnLoanBalanceGreaterThanZero() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                5
        );

        Assertions.assertEquals(0,account.yearChange());
    }

    @Test
    public void calculationOfInterestOnLoanBalanceLessThanZero() {
        CreditAccount account = new CreditAccount(
                -1_000,
                5_000,
                5
        );

        Assertions.assertEquals(-50,account.yearChange());
    }

    @Test
    public void shouldShowExceptionRate() {

        Assertions.assertThrows(IllegalArgumentException.class,() -> {
            new CreditAccount(1000,1000,-5);
        });
    }
    @Test
    public void shouldShowExceptionInitialBalanceAndCreditLimit() {

        Assertions.assertThrows(IllegalArgumentException.class,() -> {
            new CreditAccount(-6_000,-5_000,5);
        });
    }
}