package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {


    @Test
    public void payBalanceAboveLimitAfterPurchase() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.pay(5_999);

        Assertions.assertEquals(-4_999, account.getBalance());
    }


    @Test
    public void payBalanceAfterPurchaseAfterLimit() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.pay(6_001);

        Assertions.assertEquals(1_000, account.getBalance());
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
    public void calculationOfInterestOnLoanBalanceGreaterThanZero() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                5
        );

        Assertions.assertEquals(0, account.yearChange());
    }


    @Test
    public void shouldShowExceptionInitialBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(-1, 5_000, 5);
        });
    }

    @Test
    public void shouldShowExceptionCreditLimit() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(6_000, -1, 5);
        });
    }
}