package unisa.ingsoft;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import unisa.ingsoft.ComplexNumber.ComplexNumber;
import unisa.ingsoft.Exceptions.LessThanTwoElementsException;
import unisa.ingsoft.Exceptions.LessThanOneElementException;
import unisa.ingsoft.Exceptions.SyntaxException;
import unisa.ingsoft.Exceptions.VariableNotInitializedException;

public class CalculatorTest {
Calculator instance;
double delta=0.001;
    
    public CalculatorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        instance= new Calculator();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of stackToArray method, of class Calculator.
     */
    @Test  //caso generale
    public void testStackToArray() throws SyntaxException {
        instance.insert("4.4+3.4j");
        instance.insert("-5.6+8.6j");
        instance.insert("0");
        ComplexNumber[] result = instance.stackToArray();
        assertEquals(3,result.length);
        assertEquals(4.4,result[0].getRe(), delta);
        assertEquals(3.4,result[0].getIm(), delta);
        assertEquals(-5.6,result[1].getRe(), delta);
        assertEquals(8.6,result[1].getIm(), delta);
        assertEquals(0.0,result[2].getRe(), delta);
        assertEquals(0.0,result[2].getIm(), delta);
    }
    
    @Test  //caso stack vuoto
    public void testStackToArray2(){
        ComplexNumber[] result = instance.stackToArray();
        assertEquals(0,result.length);
    }
    
    /**
     * Test of insert method, of class Calculator.
     */
    @Test  //caso generale
    public void testInsert() throws SyntaxException{
        instance.insert("4.4+3.4j");
        ComplexNumber[] result = instance.stackToArray();
        assertEquals(1,result.length);
        assertEquals(4.4,result[0].getRe(), delta);
        assertEquals(3.4,result[0].getIm(), delta);
    }
    
    @Test  //Formato errato
    public void testInsert2() throws SyntaxException{
        assertThrows(SyntaxException.class, () -> {
            instance.insert("4+3+j");
        });
    }

    /**
     * Test of sumCalculator method, of class Calculator.
     */
    @Test  //caso generale
    public void testSumCalculator() throws LessThanTwoElementsException, SyntaxException {
        instance.insert("4.4+3.4j");
        instance.insert("-5.6+8.6j");
        ComplexNumber[] result = instance.stackToArray();
        assertEquals(1,result.length);
        instance.sumCalculator();
        result = instance.stackToArray();
        assertEquals(1,result.length);
        assertEquals(-1.2,result[0].getRe(), delta);
        assertEquals(12.0,result[0].getIm(), delta);
    }
    
    @Test  //1 solo elemento
    public void testSumCalculator2() throws LessThanTwoElementsException, SyntaxException{
        instance.insert("4.4+3.4j");
        assertThrows(LessThanTwoElementsException.class, () -> {
            instance.sumCalculator();
        });
        //controllo che lo stack è rimasto invariato
        ComplexNumber[] result = instance.stackToArray();
        assertEquals(1,result.length);
    }
    
    @Test  //0 elementi
    public void testSumCalculator3() throws LessThanTwoElementsException{
        assertThrows(LessThanTwoElementsException.class, () -> {
            instance.sumCalculator();
        });
    }
    
    /**
     * Test of subCalculator method, of class Calculator.
     */
    @Test  //caso generale
    public void testSubCalculator() throws LessThanTwoElementsException, SyntaxException {
        instance.insert("4.4+3.4j");
        instance.insert("-5.6+8.6j");
        ComplexNumber[] result = instance.stackToArray();
        assertEquals(1,result.length);
        instance.subCalculator();
        result = instance.stackToArray();
        assertEquals(1,result.length);
        assertEquals(10.0,result[0].getRe(), delta);
        assertEquals(-5.2,result[0].getIm(), delta);
    }
    
    @Test  //1 solo elemento
    public void testSubCalculator2() throws LessThanTwoElementsException, SyntaxException{
        instance.insert("4.4+3.4j");
        assertThrows(LessThanTwoElementsException.class, () -> {
            instance.subCalculator();
        });
        //controllo che lo stack è rimasto invariato
        ComplexNumber[] result = instance.stackToArray();
        assertEquals(1,result.length);
    }
    
    @Test  //0 elementi
    public void testSubCalculator3() throws LessThanTwoElementsException{
        assertThrows(LessThanTwoElementsException.class, () -> {
            instance.subCalculator();
        });
    }    
    
    /**
     * Test of molCalculator method, of class Calculator.
     */
    @Test  //caso generale
    public void testMolCalculator() throws LessThanTwoElementsException, SyntaxException {
        instance.insert("4.4+3.4j");
        instance.insert("-5.6+8.6j");
        ComplexNumber[] result = instance.stackToArray();
        assertEquals(1,result.length);
        instance.molCalculator();
        result = instance.stackToArray();
        assertEquals(1,result.length);
        assertEquals(-53.88,result[0].getRe(), delta); 
        assertEquals(18.8,result[0].getIm(), delta); 
    }
    
    @Test  //1 solo elemento
    public void testMolCalculator2() throws LessThanTwoElementsException, SyntaxException{
        instance.insert("4.4+3.4j");
        assertThrows(LessThanTwoElementsException.class, () -> {
            instance.molCalculator();
        });
        //controllo che lo stack è rimasto invariato
        ComplexNumber[] result = instance.stackToArray();
        assertEquals(1,result.length);
    }
    
    @Test  //0 elementi
    public void testMolCalculator3() throws LessThanTwoElementsException{
        assertThrows(LessThanTwoElementsException.class, () -> {
            instance.molCalculator();
        });
    } 
    
    /**
     * Test of divCalculator method, of class Calculator.
     */
    @Test  //caso generale
    public void testDivCalculator() throws LessThanTwoElementsException, SyntaxException {
        instance.insert("4.4+3.4j");
        instance.insert("-5.6+8.6j");
        ComplexNumber[] result = instance.stackToArray();
        assertEquals(2,result.length);
        instance.divCalculator();
        result = instance.stackToArray();
        assertEquals(1,result.length);
        assertEquals(0.043,result[0].getRe(), delta); 
        assertEquals(-0.540,result[0].getIm(), delta);  
    }
    
    @Test  //1 solo elemento
    public void testDivCalculator2() throws LessThanTwoElementsException, SyntaxException{
        instance.insert("4.4+3.4j");
        assertThrows(LessThanTwoElementsException.class, () -> {
            instance.divCalculator();
        });
        //controllo che lo stack è rimasto invariato
        ComplexNumber[] result = instance.stackToArray();
        assertEquals(1,result.length);
    }
    
    @Test  //0 elementi
    public void testDivCalculator3() throws LessThanTwoElementsException{
        assertThrows(LessThanTwoElementsException.class, () -> {
            instance.divCalculator();
        });
    }   

    @Test  //divisione per 0
    public void testDivCalculator4() throws LessThanTwoElementsException, SyntaxException, ArithmeticException {
        instance.insert("4.4+3.4j");
        instance.insert("0");
        assertThrows(ArithmeticException.class, () -> {
            instance.divCalculator();
        });  
        //controllo che lo stack è rimasto invariato
        ComplexNumber[] result = instance.stackToArray();  
        assertEquals(2,result.length);
    }   
       
    /**
     * Test of sqrtCalculator method, of class Calculator.
     */
    @Test  //caso generale
    public void testSqrtCalculator() throws LessThanOneElementException, SyntaxException {
        instance.insert("4.4+3.4j");
        ComplexNumber[] result = instance.stackToArray();
        assertEquals(1,result.length);
        instance.sqrtCalculator();
        result = instance.stackToArray();
        assertEquals(1,result.length);
        assertEquals(2.231,result[0].getRe(), delta); 
        assertEquals(0.761,result[0].getIm(), delta);  
    }
    
    @Test  //0 elementi
    public void testSqrtCalculator2() throws LessThanOneElementException{
        assertThrows(LessThanOneElementException.class, () -> {
            instance.sqrtCalculator();
        });
    }     
    /**
     * Test of invCalculator method, of class Calculator.
     */
    @Test //caso generale
    public void testInvCalculator() throws LessThanOneElementException, SyntaxException {
        instance.insert("4.4+3.4j");
        instance.invCalculator();
        ComplexNumber[] result = instance.stackToArray();
        assertEquals(1,result.length);
        assertEquals(-4,result[0].getRe(), delta); 
        assertEquals(-3,result[0].getIm(), delta);  
    }
    
    @Test  //0 elementi
    public void testInvCalculator2() throws LessThanOneElementException{
        assertThrows(LessThanOneElementException.class, () -> {
            instance.invCalculator();
        });
    }  
    /**
     * Test of conjCalculator method, of class Calculator.
     */
    @Test //caso generale
    public void testConjCalculator() throws LessThanOneElementException, SyntaxException {
        instance.insert("4.4+3.4j");
        instance.conjCalculator();
        ComplexNumber[] result = instance.stackToArray();
        assertEquals(1,result.length);
        assertEquals(4,result[0].getRe(), delta); 
        assertEquals(-3,result[0].getIm(), delta);  
    }
    
    @Test  //0 elementi
    public void testConjCalculator2() throws LessThanOneElementException{
        assertThrows(LessThanOneElementException.class, () -> {
            instance.conjCalculator();
        });
    } 
    /**
     * Test of saveOnVariable method, of class Calculator.
     */
    @Test  //caso generale
    public void testSaveOnVariable() throws SyntaxException, LessThanOneElementException, VariableNotInitializedException {
        Character c='c';
        instance.insert("4.4+3.4j");
        assertTrue(instance.stackToArray().length==1);
        instance.saveOnVariable(c);
        assertTrue(instance.stackToArray().length==0);
        ComplexNumber result = instance.saveOnStack(c);
        assertTrue(instance.stackToArray().length==1);
        assertEquals(4, result.getRe(), delta);
        assertEquals(3, result.getIm(), delta);
    }
    @Test  //stack vuoto
    public void testSaveOnVariable2() throws SyntaxException, LessThanOneElementException, VariableNotInitializedException {
        Character c='c';
        assertThrows(LessThanOneElementException.class, () -> {
            instance.saveOnVariable(c);
        });
    }
    
    /**
     * Test of saveOnStack method, of class Calculator.
     */
    @Test
    public void testSaveOnStack() throws SyntaxException, VariableNotInitializedException, LessThanOneElementException{
        Character c='c';
        instance.insert("4.4+3.4j");
        instance.saveOnVariable(c);
        assertTrue(instance.stackToArray().length==0);
        ComplexNumber result = instance.saveOnStack(c);
        assertTrue(instance.stackToArray().length==1);
        assertEquals(4, result.getRe(), delta);
        assertEquals(3, result.getIm(), delta);
    }
    @Test  //variabile non inizializzata
    public void testSaveOnStack2() throws SyntaxException, LessThanOneElementException, VariableNotInitializedException {
        Character c='c';
        assertThrows(VariableNotInitializedException.class, () -> {
            instance.saveOnStack(c);
        });
    }

    /**
     * Test of increaseVariable method, of class Calculator.
     */
    @Test
    public void testIncreaseVariable() throws SyntaxException, LessThanOneElementException, VariableNotInitializedException{
        Character c='c';
        instance.insert("4.4+3.4j");
        instance.saveOnVariable(c);
        instance.insert("-5.6+8.6j");
        assertTrue(instance.stackToArray().length==1);
        ComplexNumber result = instance.increaseVariable(c);
        assertTrue(instance.stackToArray().length==0);
        assertEquals(7, result.getRe(), delta);
        assertEquals(10, result.getIm(), delta);
    }
    
    @Test  //stack vuoto
    public void testIncreaseVariable2() throws SyntaxException, LessThanOneElementException, VariableNotInitializedException {
        Character c='c';
        assertThrows(LessThanOneElementException.class, () -> {
            instance.increaseVariable(c);
        });
    }
    
    @Test  //variabile non inizializzata
    public void testIncreaseVariable3() throws SyntaxException, LessThanOneElementException, VariableNotInitializedException {
        Character c='c';
        instance.insert("4.4+3.4j");
        assertThrows(VariableNotInitializedException.class, () -> {
            instance.increaseVariable(c);
        });
    }

    /**
     * Test of decreaseVariable method, of class Calculator.
     */
    @Test
    public void testDecreaseVariable() throws SyntaxException, LessThanOneElementException, VariableNotInitializedException{
        Character c='c';
        instance.insert("4.4+3.4j");
        instance.saveOnVariable(c);
        instance.insert("-5.6+8.6j");
        assertTrue(instance.stackToArray().length==1);
        ComplexNumber result = instance.decreaseVariable(c);
        assertTrue(instance.stackToArray().length==0);
        assertEquals(1, result.getRe(), delta);
        assertEquals(-4, result.getIm(), delta);
    }
    
    @Test  //stack vuoto
    public void testDecreaseVariable2() throws SyntaxException, LessThanOneElementException, VariableNotInitializedException {
        Character c='c';
        assertThrows(LessThanOneElementException.class, () -> {
            instance.decreaseVariable(c);
        });
    }
    
    @Test  //variabile non inizializzata
    public void testDecreaseVariable3() throws SyntaxException, LessThanOneElementException, VariableNotInitializedException {
        Character c='c';
        instance.insert("4+3j");
        assertThrows(VariableNotInitializedException.class, () -> {
            instance.decreaseVariable(c);
        });
    }
}
