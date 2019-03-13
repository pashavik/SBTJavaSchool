package exceptions;

public class PinIsNotEntered extends RuntimeException {
    public PinIsNotEntered(String s) {
        super(s);
    }
}
