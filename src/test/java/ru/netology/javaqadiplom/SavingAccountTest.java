package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {   ///Баланс в пределах максимального значения
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());

        //При пополнении баланса, не учитывается текущий баланс, отображается только сумма пополнения.
    }

    @Test
    public void shouldAddEqualMaxBalance() {   ///общий баланс равен максимальному значению
        SavingAccount account = new SavingAccount(
                4_000,
                500,
                10_000,
                6);

        account.add(6_000);

        Assertions.assertEquals(6_000 + 4_000, account.getBalance());

        //При пополнении баланса, не учитывается текущий баланс, отображается только сумма пополнения.
    }


    @Test
    public void exceedsMaxBalance() {   ///общий баланс превышает максимальное значение (должно быть сообщение)
        SavingAccount account = new SavingAccount(
                2_000,
                500,
                8_000,
                7);

        account.add(7_000);

        Assertions.assertEquals(2_000 + 7_000, account.getBalance());


    }

    @Test
    public void dontExceedsMaxBalance() {   ///общий баланс не превышает минимального значения (должно быть сообщение)
        SavingAccount account = new SavingAccount(
                3_000,
                5_000,
                8_000,
                5);

        account.add(2_000);

        Assertions.assertEquals(3_000 + 2_000, account.getBalance());


    }

    @Test
    public void cantAcceptNegativeBalance() {   ///Минимальное значение баланса не может принимать отрицательное значение (должно быть сообщение)
        SavingAccount account = new SavingAccount(
                2_000,
                -1,
                8_000,
                2);

        account.add(2_000);

        Assertions.assertEquals(2_000 + 2_000, account.getBalance());


    }

    @Test
    public void MinBalanceMoreMaxBalance() {   ///Минимальный баланс больше максимального (должно быть сообщение)
        SavingAccount account = new SavingAccount(
                7_000,
                10_000,
                9_000,
                2);

        account.add(2_000);

        Assertions.assertEquals(7_000 + 2_000, account.getBalance());


    }

    @Test
    public void rateCantAcceptNegative() {   ///Процентная ставка не может быть отрицательной
        SavingAccount account = new SavingAccount(
                7_000,
                1_000,
                9_000,
                -1);

        account.add(2_000);

        Assertions.assertEquals(7_000 + 2_000, account.getBalance());

    }

    @Test
    public void initialBalanceNotExceedMinBalance() {   ///Начальный баланс не превышает минимальное значение (должно быть сообщение)
        SavingAccount account = new SavingAccount(
                500,
                1_000,
                9_000,
                9);

        account.add(5_000);

        Assertions.assertEquals(500 + 5_000, account.getBalance());

    }

    @Test
    public void initialBalanceEqualToMinBalance() {   ///Начальный баланс равен минимальному значению
        SavingAccount account = new SavingAccount(
                1_000,
                1_000,
                9_000,
                9);

        account.add(500);

        Assertions.assertEquals(1_000 + 500, account.getBalance());

    }

    @Test
    public void initialBalanceEqualToMaxBalance() {   ///Начальный баланс равен максимальному значению
        SavingAccount account = new SavingAccount(
                9_000,
                1_000,
                9_000,
                10);



        Assertions.assertEquals(9_000, account.getBalance());

    }

    @Test
    public void initialBalanceExceedsMaxBalance() {   ///Начальный баланс превышает максимальное значение (должно быть сообщение)
        SavingAccount account = new SavingAccount(
                10_000,
                1_000,
                9_000,
                10);

        Assertions.assertEquals(9_000, account.getBalance());

    }


    @Test
    public void paymentAmountNotExceedsInitialBalance() {   ///сумма покупки не превышает текущий баланс
        SavingAccount account = new SavingAccount(
                7_000,
                1_000,
                9_000,
                5);

        account.pay(2_000);

        Assertions.assertEquals(7_000 - 2_000, account.getBalance());

    }

    @Test
    public void paymentAmountExceedsInitialBalance() {   ///сумма покупки превышает текущий баланс (сумма не должна измениться)
        SavingAccount account = new SavingAccount(
                1_000,
                500,
                12_000,
                5);

        account.pay(2_000);

        Assertions.assertEquals(1_000, account.getBalance());

        ///Итоговый баланс превысил минимальное значение баланса

    }

    @Test
    public void paymentAmountEqualToInitialBalance() {   ///сумма покупки равна текущему балансу
        SavingAccount account = new SavingAccount(
                5_000,
                500,
                15_000,
                10);

        account.pay(5_000);

        Assertions.assertEquals(0, account.getBalance());


    }

    @Test
    public void paymentAmountCantAcceptNegative() {  ///сумма покупки не может принимать отрицательное значение
        SavingAccount savingAccount = new SavingAccount(
                35_000,
                500,
                500_000,
                16);

        Boolean expected = false;

        Boolean actual = savingAccount.add(-555);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void paymentAmountCanNotTakeValueZero() {  ///сумма покупки не может принимать значение равное нулю
        SavingAccount savingAccount = new SavingAccount(
                35_000,
                500,
                500_000,
                16);

        Boolean expected = false;

        Boolean actual = savingAccount.pay(0);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ratePositive() {  ///Положительная процентная ставка
        SavingAccount savingAccount = new SavingAccount(
                10_000,
                1_000,
                15_000,
                22);

        Assertions.assertEquals(2_200, savingAccount.yearChange());
    }


    @Test
    public void rateEqualToZero() {  ///Процентная ставка равна 0
        SavingAccount savingAccount = new SavingAccount(
                10_000,
                1_000,
                15_000,
                0);

        Assertions.assertEquals(0, savingAccount.yearChange());
    }

    @Test
    public void returnMinBalance() {
        SavingAccount savingAccount = new SavingAccount(
                5_000,
                1_000,
                10_000,
                4);
        Assertions.assertEquals(1_000, savingAccount.getMinBalance());
    }


    @Test
    public void returnMaxBalance() {
        SavingAccount savingAccount = new SavingAccount(
                80_000,
                0,
                188_000,
                3);
        Assertions.assertEquals(188_000, savingAccount.getMaxBalance());
    }

}
