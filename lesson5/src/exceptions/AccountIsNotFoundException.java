package exceptions;

public class AccountIsNotFoundException extends RuntimeException{
    public AccountIsNotFoundException(String message) {
        super(message);
    }
}
