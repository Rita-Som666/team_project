package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    CreditAccount account = new CreditAccount(
            0,
            5_000,
            15
    );

    CreditAccount account1 = new CreditAccount(
            25,
            5_000,
            15
    );

    @Test
    public void shouldCreateAccWithInitialBalanceMoreZero(){
        int expected = 25;
        int actual = account1.getBalance();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddToPositiveBalance() {


        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }



    @Test
    public void shouldThrowIfInitialBalanceBellowZero(){

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount badAcc =  new CreditAccount(
                    -100,
                    5_000,
                    15
            );
        });



    }

    @Test
    public void shouldThrowIfCreditLimitBellowZero(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount badAcc =  new CreditAccount(
                    0,
                    -5_000,
                    15
            );
        });

    }

    @Test
    public void shouldThrowIfRateBellowZero(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount badAcc =  new CreditAccount(
                    0,
                    5_000,
                    -15
            );
        });

    }

    @Test
    public void NotPayIfMoreLimit(){

        account.pay(6000);
        int expected = 0;
        int actual = account.getBalance();
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldPaySuccess(){

        account1.pay(27);
        int expected = -2;
        int actual = account1.getBalance();
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldTopUpBalance(){

        account1.add(100);
        int expected = 125;
        int actual = account1.getBalance();
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldNotChangeBalanceIfAmountBellowZero(){

        account1.add(-100);
        int expected = 25;
        int actual = account1.getBalance();
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldCalculatePercent(){
        account.pay(200);
        int actual = account.yearChange();
        int expected = -30;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldNotChangePercentIfBalanceMoreZero(){
        account.add(200);
        int actual = account.yearChange();
        int expected = 0;
        Assertions.assertEquals(expected, actual);

    }





}
