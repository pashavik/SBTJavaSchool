import exceptions.InsufficientFundsException;

public class Account {
    private final String accountNumber;
    private final String pin;
    private int balance;

    public Account(String accountNumber, String pin) {
        this.accountNumber = accountNumber;
        this.pin = pin;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPin() {
        return pin;
    }

    public int getBalance() {
        return balance;
    }

    public int depositMoney(int money) {
        balance += money;
        return balance;
    }

    public int withdrawMoney(int money) {
        if (money > balance) {
            throw new InsufficientFundsException("Не достаточно средств");
        }
        balance -= money;
        return balance;
    }
}