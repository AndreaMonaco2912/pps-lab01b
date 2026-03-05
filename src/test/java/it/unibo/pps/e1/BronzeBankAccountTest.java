package it.unibo.pps.e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BronzeBankAccountTest extends CoreBankAccountTest {

    @Test
    public void testCanWithMaximalFeeWithdraw() {
        final int deposit = 1000;
        final int withdraw = 200; // 200 is bigger than the discriminant withdrawNumber (100)
        final int withdrawalFee = 1;
        this.account.deposit(deposit);
        this.account.withdraw(withdraw);
        assertEquals(deposit - withdraw - withdrawalFee, this.account.getBalance());
    }

    @Test
    public void testCanWithMinimalFeeWithdraw() {
        final int deposit = 1000;
        final int withdraw = 99; // 99 is smaller than the discriminant withdrawNumber (100)
        final int withdrawalFee = 0;
        this.account.deposit(deposit);
        this.account.withdraw(withdraw);
        assertEquals(deposit - withdraw - withdrawalFee, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable() {
        final int amount = 1000;
        final int withdrawalAmount = 1200;
        this.account.deposit(amount);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(withdrawalAmount));
    }

    @Override
    protected BankAccount createBankAccount() {
        return factory.createBronzeBankAccount();
    }
}
