package terminal;

import terminal.exceptions.AccountIsNotFoundException;
import terminal.exceptions.InsufficientFundsException;
import terminal.exceptions.PinException;
import terminal.exceptions.TerminalServerException;

import java.util.ArrayList;
import java.util.List;

public class TerminalServer {
    private List<Account> accountList;
    private Account currentAccount;

    public TerminalServer() {
        this.accountList = storedAccounts();
    }

    private List<Account> storedAccounts() {
        List<Account> list=new ArrayList<>();
        list.add(new Account("1111_1111_1111_1111", "1111"));
        list.add(new Account("2222_2222_2222_2222", "2222"));
        list.add(new Account("3333_3333_3333_3333", "3333"));
        list.add(new Account("4444_4444_4444_4444", "4444"));

        return list;
    }

    public void start(String accountNumber) {
        for (Account account : accountList) {
            if (account.getAccountNumber().equals(accountNumber)) {
                currentAccount = account;
                return;
            }
        }
        throw new AccountIsNotFoundException("Счет нe зарегистрирован");
    }


    public void checkPin(String pin) {
        if (!currentAccount.getPin().equals(pin)) {
            throw new PinException("Некорректный PIN");
        }
    }


    public int getAccountBalance() {
        return currentAccount.getBalance();
    }


    public int getMoney(int sum) {
        try {
            return currentAccount.withdrawMoney(sum);
        } catch (InsufficientFundsException e){
            throw new TerminalServerException("Сервер: ошибка счета: " + e.getMessage(), e);
        }
    }


    public int putCash(int sum) {
        return currentAccount.depositMoney(sum);
    }

    public void close() {
        currentAccount = null;
    }
}