package terminal;

public class PinValidator {
    public void validate(Account account, String pin){
        if(!pin.equals(account.getPin())){
            throw new RuntimeException ("Неверный pin");

        }
    }
}


