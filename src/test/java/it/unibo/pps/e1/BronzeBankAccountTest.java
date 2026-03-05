package it.unibo.pps.e1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BronzeBankAccountTest extends CoreBankAccountTest {

    @ParameterizedTest
    @CsvSource({
            "1000, 200, 1", // 200 is bigger than the discriminant withdrawNumber (100)
            "1000, 99, 0" // 99 is smaller than the discriminant withdrawNumber (100)
    })
    public void testWithdraw(int deposit, int withdraw, int withdrawalFee) {
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
