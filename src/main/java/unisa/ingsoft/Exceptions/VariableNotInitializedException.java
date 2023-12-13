package unisa.ingsoft.Exceptions;

public class VariableNotInitializedException extends Exception{
    @Override
    public String getMessage(){
        return "Variabile non inizializzata";
    }
}
