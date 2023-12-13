package unisa.ingsoft.Exceptions;

public class NotEnoughElementsException extends Exception{
    @Override
    public String getMessage(){
        return "Non abbastanza elementi";
    }
}
