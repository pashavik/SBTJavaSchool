package exceptions;

public class WrongInputException extends RuntimeException {
    public WrongInputException(String s) {
        super(s);
    }
}
