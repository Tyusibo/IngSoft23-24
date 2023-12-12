package unisa.ingsoft.Exceptions;


public class LessThanOneElementException extends NotEnoughElementsException{
    public String getMessage(){
        return "Non è presente nessun elemento nello stack per effettuare l'operazione";
    }
}
