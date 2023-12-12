package unisa.ingsoft.DataStructures;

import unisa.ingsoft.Exceptions.LessThanOneElementException;
import unisa.ingsoft.Exceptions.LessThanTwoElementsException;

public interface StackOperations {

    public void clear();
    public void drop();
    public void swap() throws LessThanTwoElementsException;
    public void dup() throws LessThanOneElementException;
    public void over() throws LessThanTwoElementsException;

}