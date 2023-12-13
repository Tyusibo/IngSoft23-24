package unisa.ingsoft.Exceptions;


public class LessThanOneElementException extends NotEnoughElementsException{
    public String getMessage(){
        return "Inserisci almeno 1 numero nello stack";
    }
}
