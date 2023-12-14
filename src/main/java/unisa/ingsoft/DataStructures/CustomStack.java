package unisa.ingsoft.DataStructures;

import unisa.ingsoft.Exceptions.LessThanOneElementException;
import unisa.ingsoft.Exceptions.LessThanTwoElementsException;

import java.util.Stack;

public class CustomStack<E> extends Stack<E> implements StackOperations{ 

    public CustomStack() {
        super();
    }
    
    @Override
    public void clear(){  
        int n=size();
        for(int i=0; i<n;i++)
            drop();
    }
    public void drop(){
       if(size()>=1)
                pop();
    } 
    public void swap() throws LessThanTwoElementsException{
        if(size()<2)
            throw new LessThanTwoElementsException();
        
        E z=pop();
        E w=pop();
        push(z);
        push(w);
    }
    public void dup() throws LessThanOneElementException{
        if(size()<1)
            throw new LessThanOneElementException();
        
        push(peek());
    }
    public void over() throws LessThanTwoElementsException{
        if(size()<2)
            throw new LessThanTwoElementsException();
        
        E z=pop();
        E w=peek();
        push(z);
        push(w);
    }
}
