package terminal;

import terminal.exceptions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TerminalImpl {
    private final TerminalServer server;
   // private final terminal.PinValidator pinValidator;
    private Validator validator;

    private int wrongCount;
    private boolean accountLocked = false;
    private Date unlockTime;
    private boolean correctPin;

    public TerminalImpl(TerminalServer server, Validator validator) {
        this.server = server;
        this.validator=validator;
    }


    public boolean start(String accountNumber) {
        try {

            validator.validateAccount(accountNumber);
            server.start(accountNumber);

            System.out.println("Введите pin");
            return true;
        } catch (WrongInputException e) {
            System.out.println("Терминал " +e.getMessage());
            return false;
        }
    }

    public boolean enterPin(String pin) throws InterruptedException {
        try {

            if (accountIsLocked()) {
                throw new AccountIsLockedException("Счет заблокирован до "+ getUnlockTimeFormatted());
            }
            validator.validatePin(pin);
            server.checkPin(pin);
            correctPin = true;
            wrongCount = 0;
            System.out.println("Корректный Pin");
            return true;
        } catch (WrongInputException | AccountIsLockedException e){
            System.out.println("Терминал " + e.getMessage());
        }catch( PinException e){
            wrongCount++;
            System.out.println("Терминал+ " + e.getMessage());
            if (wrongCount > 3) {
                accountLocked = true;
                unlockTime = new Date(System.currentTimeMillis() + 5000);
                System.out.println("Заблокировано до " + getUnlockTimeFormatted());
                Thread.sleep(3 * 1000);
            }
        }
        return false;
    }

    public void getAccountBalance() {
        try {
            if (accountIsLocked()) {
                throw new AccountIsLockedException("Счет заблокирован до "+ getUnlockTimeFormatted());
            }
            if(!correctPin){
                throw new PinIsNotEntered("Необходимо ввести pin");
            }

            int balance = server.getAccountBalance();
            System.out.println("Остаток на счете = " + balance);
        } catch ( AccountIsLockedException e ){
            System.out.println("Терминал: " + e.getMessage());
        }
    }

    public void withdrawMoney(int sum) {
        try {
            if (accountIsLocked()) {
                throw new AccountIsLockedException("Счет заблокирован до "+ getUnlockTimeFormatted());
            }
            if (!correctPin) {
                throw new PinIsNotEntered("Необходимо ввести pin");
            }
            if (sum % 100 != 0) {
                throw new WrongSumException("Сумма должна быть кратна 10");
            }
            int balance = server.getMoney(sum);
            System.out.println("Вы сняли " + sum);
            System.out.println("Сумма на счету = " + balance);
        } catch ( AccountIsLockedException|PinException |WrongSumException e){
            System.out.println("Терминал "+ e.getMessage());
        }
    }

    public void putMoney(int sum){
        try {
            if (accountIsLocked()) {
                throw new AccountIsLockedException("Счет заблокирован до "+ getUnlockTimeFormatted());
            }
            if (!correctPin) {
                throw new PinIsNotEntered("Необходимо ввести pin");
            }
            if (sum % 100 != 0) {
                throw new WrongSumException("Сумма должна быть кратна 10");
            }
            int balance = server.putCash(sum);
            System.out.println("Вы внесли " + sum);
            System.out.println("Сумма на счету = " + balance);
        } catch ( AccountIsLockedException|PinException |WrongSumException e){
            System.out.println("Терминал "+ e.getMessage());
        }
    }

    public void stop(){
        server.close();
        System.out.println("Обслуживание завершено");
    }

    private boolean accountIsLocked(){
        if(accountLocked){
            if(unlockTime.compareTo(new Date(System.currentTimeMillis()))>0){
                return accountLocked;
            } else accountLocked=false;
        }
        return accountLocked;
    }
    private String getUnlockTimeFormatted() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(unlockTime);
    }

}