package it.unibo.pps.e1;

public interface BankAccountFactory {

    BankAccount createSilverBankAccount();

    BankAccount createGoldBankAccount();

    BankAccount createBronzeBankAccount();
}
