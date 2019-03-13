import exceptions.WrongInputException;

public class Validator {
    public void validateAccount(String accountNumber){
        if(accountNumber.length()!=19){
            throw new WrongInputException("Номер должен содержать 19 цифр");
        }
    }

    public void validatePin(String pin){
        if(pin.length()!=4){
            throw new WrongInputException("Пин должен содержать 4 цифры");
        }
    }
}
