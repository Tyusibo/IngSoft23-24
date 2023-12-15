package unisa.ingsoft;

import unisa.ingsoft.ComplexNumber.ComplexNumber;
import unisa.ingsoft.DataStructures.CustomStack;
import unisa.ingsoft.DataStructures.Variables;
import unisa.ingsoft.Exceptions.LessThanOneElementException;
import unisa.ingsoft.Exceptions.LessThanTwoElementsException;
import unisa.ingsoft.Exceptions.SyntaxException;
import unisa.ingsoft.Exceptions.VariableNotInitializedException;

public class Calculator {

    private final CustomStack<ComplexNumber> stack;
    private final Variables vars;

    public Calculator(){
        stack = new CustomStack<>();
        vars = new Variables();
    }

    public void insert(String number) throws SyntaxException{
        ComplexNumber num = ComplexNumber.parse(number);
        double newRe;
        double newIm;
        if(num.getRe()==-0){
            newRe = 0;
        } else newRe = num.getRe();
        if(num.getIm()==-0){
            newIm = 0; //impostare la parte immaginaria a 0 è necessario per non causare dipendenze, ma non è necessario nel contesto della calcolatrice
        } else newIm = num.getIm();
        stack.push(new ComplexNumber(newRe, newIm));
    }

    public ComplexNumber sumCalculator() throws LessThanTwoElementsException{
        if (stack.size()<2)
            throw new LessThanTwoElementsException();
        ComplexNumber w, result;
        w = stack.pop();
        result = stack.pop().sum(w);
        stack.push(result);
        return result;
    }
    public ComplexNumber subCalculator() throws LessThanTwoElementsException{
        if (stack.size()<2)
            throw new LessThanTwoElementsException();
        ComplexNumber w, result;
        w = stack.pop();
        result = stack.pop().sub(w);
        stack.push(result);
        return result;
    }
    public ComplexNumber molCalculator() throws LessThanTwoElementsException{
        if (stack.size()<2)
            throw new LessThanTwoElementsException();
        ComplexNumber w, result;
        w = stack.pop();
        result = stack.pop().mol(w);
        double newRe;
        double newIm;
        if(result.getRe()==-0){
            newRe = 0;
        } else newRe = result.getRe();
        if(result.getIm()==-0){
            newIm = 0; //impostare la parte immaginaria a 0 è necessario per non causare dipendenze, ma non è necessario nel contesto della calcolatrice
        } else newIm = result.getIm();
        ComplexNumber ret = new ComplexNumber(newRe, newIm);
        stack.push(ret);
        return ret;
    }
    public ComplexNumber divCalculator() throws LessThanTwoElementsException, ArithmeticException{
        if (stack.size()<2)
            throw new LessThanTwoElementsException();
        ComplexNumber z,w, result;
        w = stack.pop();
        z = stack.pop();
        try{
            result=z.div(w);
        } catch(ArithmeticException ex){
            stack.push(z);
            stack.push(w);
            throw new ArithmeticException();
        }
        stack.push(result);
        return result;
    }
    public ComplexNumber sqrtCalculator() throws LessThanOneElementException{
        if (stack.size()<1)
            throw new LessThanOneElementException();
        ComplexNumber result = stack.pop().sqrt();
        stack.push(result);
        return result;
    }
    public ComplexNumber invCalculator() throws LessThanOneElementException{
        if (stack.size()<1)
            throw new LessThanOneElementException();
        ComplexNumber result = stack.pop().inv();
        double newRe;
        double newIm;
        if(result.getRe()==-0){
            newRe = 0;
        } else newRe = result.getRe();
        if(result.getIm()==-0){
            newIm = 0; //impostare la parte immaginaria a 0 è necessario per non causare dipendenze, ma non è necessario nel contesto della calcolatrice
        } else newIm = result.getIm();
        ComplexNumber ret = new ComplexNumber(newRe, newIm);
        stack.push(ret);
        return ret;
    }
    public ComplexNumber conjCalculator() throws LessThanOneElementException{
        if (stack.size()<1)
            throw new LessThanOneElementException();
        ComplexNumber result = stack.pop().conj();
        double newIm;
        if(result.getIm()==-0){
            newIm = 0; //impostare la parte immaginaria a 0 è necessario per non causare dipendenze, ma non è necessario nel contesto della calcolatrice
        } else newIm = result.getIm();
        ComplexNumber ret = new ComplexNumber(result.getRe(), newIm);
        stack.push(ret);
        return ret;
    }

    public ComplexNumber saveOnStack(Character c) throws VariableNotInitializedException{
        return stack.push(vars.get(c));
    }
    public ComplexNumber saveOnVariable(Character c) throws LessThanOneElementException, VariableNotInitializedException{
        if(stack.isEmpty()) 
            throw new LessThanOneElementException();
        vars.put(c, stack.pop());
        return vars.get(c);
        
    }
    public ComplexNumber increaseVariable(Character c)throws VariableNotInitializedException, LessThanOneElementException{
        if(stack.isEmpty())
            throw new LessThanOneElementException();
        ComplexNumber elem=stack.pop();
        try{
            return vars.increase(c, elem);
        }catch(VariableNotInitializedException w){
            stack.push(elem);
            throw new VariableNotInitializedException();
        }     
    }

    public ComplexNumber decreaseVariable(Character c)throws VariableNotInitializedException, LessThanOneElementException{
        if(stack.isEmpty())
            throw new LessThanOneElementException();
        ComplexNumber elem=stack.pop();
        try{
            return vars.decrease(c, elem);
        }catch(VariableNotInitializedException w){
            stack.push(elem);
            throw new VariableNotInitializedException();
        } 
    }
    
    public ComplexNumber[] stackToArray(){
        ComplexNumber[] result = new ComplexNumber[stack.size()];    
        return stack.toArray(result);
    } 

    public void clear(){stack.clear();}
    public void drop(){stack.drop();}
    public void swap() throws LessThanTwoElementsException{stack.swap();}
    public void dup() throws LessThanOneElementException{stack.dup();}
    public void over() throws LessThanTwoElementsException{stack.over();} 

}