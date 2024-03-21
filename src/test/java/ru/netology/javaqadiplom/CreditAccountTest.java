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
    public void balanceAboveLimitAfterPurchase() {
        CreditAccount account= new CreditAccount(
                5_002,
                5_000,
                15
        );

        account.pay(1);

        Assertions.assertEquals(5_001,account.getBalance());
    }

    @Test
    public void balanceAfterPurchaseEqualLimit() {
        CreditAccount account= new CreditAccount(
                5_001,
                5_000,
                15
        );

        account.pay(1);

        Assertions.assertEquals(5_000,account.getBalance());
    }
    @Test
    public void balanceLessThanLimitAfterPurchase() {
        CreditAccount account= new CreditAccount(
                5_000,
                5_000,
                15
        );

        account.pay(1);
        boolean expected = false;
        boolean actual = account.pay(4_999);

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

//    @Test
//    public void calculationOfInterest() {
//        CreditAccount account = new CreditAccount(
//                -1_000,
//                5_000,
//                -5
//        );
//
//        Assertions.assertThrows(IllegalArgumentException.class,() -> {
//            account.yearChange();
//        });
//    }
}
