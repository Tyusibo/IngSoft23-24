package unisa.ingsoft.Exceptions;

public class LessThanTwoElementsException extends NotEnoughElementsException{
    public String getMessage(){
        return "Servono almeno 2 elementi per lo swap";
    }
}
