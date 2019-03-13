package terminal.exceptions;

public class AccountIsLockedException extends RuntimeException {
    public AccountIsLockedException(String s) {
        super(s);
    }
}
