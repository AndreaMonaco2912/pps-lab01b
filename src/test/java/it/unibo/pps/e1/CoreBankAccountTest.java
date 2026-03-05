package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class CoreBankAccountTest {
    protected final BankAccountFactory factory = new BankAccountFactoryImpl();
    protected BankAccount account;

    @BeforeEach
    void init(){
        this.account = createBankAccount();
    }

    protected abstract BankAccount createBankAccount();

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        final int depositedAmount = 1000;
        this.account.deposit(depositedAmount);
        assertEquals(depositedAmount, this.account.getBalance());
    }
}
