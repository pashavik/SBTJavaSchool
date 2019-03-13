package terminal.exceptions;

public class TerminalServerException extends RuntimeException {
    public TerminalServerException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
