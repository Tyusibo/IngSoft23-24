package unisa.ingsoft.Exceptions;

public class LessThanTwoElementsException extends NotEnoughElementsException{
    @Override
    public String getMessage(){
        return "Inserisci almeno 2 numeri nello stack";
    }
}
