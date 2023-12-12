package unisa.ingsoft.DataStructures;

import unisa.ingsoft.Exceptions.VariableNotInitializedException;

public interface VariablesOperations<T>{
    public T get(Character c) throws VariableNotInitializedException;
    public T put(Character c, T t);
    public T increase(Character c, T t) throws VariableNotInitializedException;
    public T decrease(Character c, T t) throws VariableNotInitializedException;
}