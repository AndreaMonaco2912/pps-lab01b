package it.unibo.pps.e1;

public class BankAccountFactoryImpl implements BankAccountFactory {

    @Override
    public BankAccount createSilverBankAccount() {
        final int withdrawalFee = 1;
        final int maximalDebt = 0;
        return new CoreBankAccount(
                ((balance, amount) -> {
                    stopIllegalWithdraw(balance - amount, maximalDebt);
                    return balance - amount - withdrawalFee;
                })
        );
    }

    @Override
    public BankAccount createGoldBankAccount() {
        final int maximalDebt = 500;
        return new CoreBankAccount(
                ((balance, amount) -> {
                    final int finalBalance = balance - amount;
                    stopIllegalWithdraw(finalBalance, maximalDebt);
                    return finalBalance;
                })
        );
    }

    @Override
    public BankAccount createBronzeBankAccount() {
        final int feeDiscriminant = 100;
        final int minWithdrawalFee = 0;
        final int maxWithdrawalFee = 1;
        final int maximalDebt = 0;
        return new CoreBankAccount(
                ((balance, amount) -> {
                    final int fee = amount < feeDiscriminant ? minWithdrawalFee : maxWithdrawalFee;
                    final int finalBalance = balance - amount - fee;
                    stopIllegalWithdraw(finalBalance, maximalDebt);
                    return finalBalance;
                })
        );
    }

    private void stopIllegalWithdraw(int finalBalance, int maximalDebt) {
        if (finalBalance < -maximalDebt) {
            throw new IllegalStateException();
        }
    }
}
