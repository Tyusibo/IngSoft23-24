package unisa.ingsoft.DataStructures;

import unisa.ingsoft.ComplexNumber.ComplexNumber;
import unisa.ingsoft.Exceptions.VariableNotInitializedException;

import java.util.LinkedHashMap;
import java.util.Map;

public class Variables implements VariablesOperations<ComplexNumber>{
    private Map<Character,ComplexNumber> variables;
    
    public Variables() {
        variables=new LinkedHashMap<>();
    }
    
    
    @Override
    public ComplexNumber get(Character c) throws VariableNotInitializedException{
        ComplexNumber w=variables.get(c);
        if(w==null)
            throw new VariableNotInitializedException();
        return w;  //la push verrà fatta dalla calcolatricia
    }
    
    @Override
    public ComplexNumber put(Character c,ComplexNumber z){  //unica che può inizializzare
        return variables.put(c,z);
    }
    
   
    @Override
    public ComplexNumber increase(Character c, ComplexNumber z) throws VariableNotInitializedException{
        this.put(c,(this.get(c).sum(z)));       //l'eccezione sale al chiamante???
        return this.get(c);
    }
    
    @Override
    public ComplexNumber decrease(Character c,ComplexNumber z) throws VariableNotInitializedException{
        this.put(c,(this.get(c).sub(z)));  //l'eccezione sale al chiamante???
        return this.get(c);
    }
}