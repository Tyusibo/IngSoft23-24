package unisa.ingsoft;

import unisa.ingsoft.ComplexNumber.ComplexNumber;
import unisa.ingsoft.DataStructures.CustomStack;
import unisa.ingsoft.DataStructures.Variables;
import unisa.ingsoft.Exceptions.LessThanOneElementException;
import unisa.ingsoft.Exceptions.LessThanTwoElementsException;
import unisa.ingsoft.Exceptions.SyntaxException;
import unisa.ingsoft.Exceptions.VariableNotInitializedException;

public class Calculator {

    private CustomStack<ComplexNumber> stack;
    private Variables vars;

    public Calculator(){
        stack = new CustomStack<>();
        vars = new Variables();
    }

    public void insert(String number) throws SyntaxException{
        ComplexNumber num = ComplexNumber.parseComplexNumber(number);
        stack.push(num);
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
        stack.push(result);
        return result;
    }
    public ComplexNumber divCalculator() throws LessThanTwoElementsException{
        if (stack.size()<2)
            throw new LessThanTwoElementsException();
        ComplexNumber w, result;
        w = stack.pop();
        result = stack.pop().div(w);
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
        stack.push(result);
        return result;
    }
    public ComplexNumber conjCalculator() throws LessThanOneElementException{
        if (stack.size()<1)
            throw new LessThanOneElementException();
        ComplexNumber result = stack.pop().conj();
        stack.push(result);
        return result;
    }

    public ComplexNumber saveOnStack(Character c) throws VariableNotInitializedException{
        return stack.push(vars.get(c));
    }
    public ComplexNumber saveOnVariable(Character c) throws LessThanOneElementException, VariableNotInitializedException{
        if(!stack.isEmpty()){
            vars.put(c, stack.pop());
            return vars.get(c);
        }else
            throw new LessThanOneElementException();
        
    }
    public ComplexNumber increaseVariable(Character c)throws VariableNotInitializedException, LessThanOneElementException{
        if(!stack.isEmpty()){
        ComplexNumber elem=stack.pop();
        try{
            return vars.increase(c, elem);
        } catch(VariableNotInitializedException w){
            stack.push(elem);
            throw new VariableNotInitializedException();
        }
        }else
            throw new LessThanOneElementException();
    }

    public ComplexNumber decreaseVariable(Character c)throws VariableNotInitializedException, LessThanOneElementException{
        if(!stack.isEmpty()){
        ComplexNumber elem=stack.pop();
        try{
            return vars.decrease(c, elem);
        } catch(VariableNotInitializedException w){
            stack.push(elem);
            throw new VariableNotInitializedException();
        }
        }else
            throw new LessThanOneElementException();
    }

    public void clear(){stack.clear();}
    public void drop(){stack.drop();}
    public void swap() throws LessThanTwoElementsException{stack.swap();}
    public void dup() throws LessThanOneElementException{stack.dup();}
    public void over() throws LessThanTwoElementsException{stack.over();}

    public ComplexNumber[] stackToArray(){
        ComplexNumber[] result = new ComplexNumber[stack.size()];    
        return stack.toArray(result);
    }

    

}