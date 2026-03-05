package it.unibo.pps.e1;

class CoreBankAccount implements BankAccount{

    private int balance = 0;
    private final WithdrawStrategy withdrawer;

    public CoreBankAccount(WithdrawStrategy withdrawer){
        this.withdrawer = withdrawer;
    }

    @Override
    public int getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(int amount) {
        this.balance = this.balance + amount;
    }

    @Override
    public void withdraw(int amount) {
        this.balance = this.withdrawer.withdraw(this.balance, amount);
    }
}
