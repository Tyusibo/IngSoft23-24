package unisa.ingsoft;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import unisa.ingsoft.ComplexNumber.ComplexNumber;
import unisa.ingsoft.DataStructures.CustomStack;
import unisa.ingsoft.DataStructures.Variables;
import unisa.ingsoft.Exceptions.LessThanTwoElementsException;
import unisa.ingsoft.Exceptions.LessThanOneElementException;
import unisa.ingsoft.Exceptions.SyntaxException;

public class CalculatorTest {
    
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
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of stackToArray method, of class Calculator.
     */
    @Test  //caso generale
    public void testStackToArray() throws SyntaxException {
        Calculator instance = new Calculator();
        instance.insert("4+3j");
        instance.insert("-5+8j");
        instance.insert("0");
        ComplexNumber[] result = instance.stackToArray();
        assertEquals(3,result.length);
        assertEquals(4,result[0].getRe());
        assertEquals(3,result[0].getIm());
        assertEquals(-5,result[1].getRe());
        assertEquals(8,result[1].getIm());
        assertEquals(0,result[2].getRe());
        assertEquals(0,result[2].getIm());
    }
    
    @Test  //caso stack vuoto
    public void testStackToArray2(){
        Calculator instance = new Calculator();
        ComplexNumber[] result = instance.stackToArray();
        assertEquals(0,result.length);
    }
    
    /**
     * Test of insert method, of class Calculator.
     */
    @Test  //caso generale
    public void testInsert() throws SyntaxException{
        Calculator instance = new Calculator();
        instance.insert("4+3j");
        ComplexNumber[] result = instance.stackToArray();
        assertEquals(1,result.length);
        assertEquals(4,result[0].getRe());
        assertEquals(3,result[0].getIm());
    }
    
    @Test  //Formato errato
    public void testInsert2() throws SyntaxException{
        Calculator instance = new Calculator();
        assertThrows(SyntaxException.class, () -> {
            instance.insert("4+3+j");
        });
    }

    /**
     * Test of sumCalculator method, of class Calculator.
     */
    @Test  //caso generale
    public void testSumCalculator() throws LessThanTwoElementsException, SyntaxException {
        Calculator instance = new Calculator();
        instance.insert("4+3j");
        instance.insert("-5+8j");
        instance.sumCalculator();
        ComplexNumber[] result = instance.stackToArray();
        assertEquals(1,result.length);
        assertEquals(-1,result[0].getRe());
        assertEquals(11,result[0].getIm());
    }
    
    @Test  //1 solo elemento
    public void testSumCalculator2() throws LessThanTwoElementsException, SyntaxException{
        Calculator instance = new Calculator();
        instance.insert("4+3j");
        assertThrows(LessThanTwoElementsException.class, () -> {
            instance.sumCalculator();
        });
    }
    
    @Test  //0 elementi
    public void testSumCalculator3() throws LessThanTwoElementsException{
        Calculator instance = new Calculator();
        assertThrows(LessThanTwoElementsException.class, () -> {
            instance.sumCalculator();
        });
    }
    
    /**
     * Test of subCalculator method, of class Calculator.
     */
    @Test  //caso generale
    public void testSubCalculator() throws LessThanTwoElementsException, SyntaxException {
        Calculator instance = new Calculator();
        instance.insert("4+3j");
        instance.insert("-5+8j");
        instance.subCalculator();
        ComplexNumber[] result = instance.stackToArray();
        assertEquals(1,result.length);
        assertEquals(9,result[0].getRe());
        assertEquals(-5,result[0].getIm());
    }
    
    @Test  //1 solo elemento
    public void testSubCalculator2() throws LessThanTwoElementsException, SyntaxException{
        Calculator instance = new Calculator();
        instance.insert("4+3j");
        assertThrows(LessThanTwoElementsException.class, () -> {
            instance.subCalculator();
        });
    }
    
    @Test  //0 elementi
    public void testSubCalculator3() throws LessThanTwoElementsException{
        Calculator instance = new Calculator();
        assertThrows(LessThanTwoElementsException.class, () -> {
            instance.subCalculator();
        });
    }    
    
    /**
     * Test of molCalculator method, of class Calculator.
     */
    @Test  //caso generale
    public void testMolCalculator() throws LessThanTwoElementsException, SyntaxException {
        Calculator instance = new Calculator();
        instance.insert("4+3j");
        instance.insert("-5+8j");
        instance.molCalculator();
        ComplexNumber[] result = instance.stackToArray();
        assertEquals(1,result.length);
        assertEquals(9,result[0].getRe()); //??
        assertEquals(-5,result[0].getIm()); //??
    }
    
    @Test  //1 solo elemento
    public void testMolCalculator2() throws LessThanTwoElementsException, SyntaxException{
        Calculator instance = new Calculator();
        instance.insert("4+3j");
        assertThrows(LessThanTwoElementsException.class, () -> {
            instance.molCalculator();
        });
    }
    
    @Test  //0 elementi
    public void testMolCalculator3() throws LessThanTwoElementsException{
        Calculator instance = new Calculator();
        assertThrows(LessThanTwoElementsException.class, () -> {
            instance.molCalculator();
        });
    } 
    
    /**
     * Test of divCalculator method, of class Calculator.
     */
    @Test  //caso generale
    public void testDivCalculator() throws LessThanTwoElementsException, SyntaxException {
        Calculator instance = new Calculator();
        instance.insert("4+3j");
        instance.insert("-5+8j");
        instance.divCalculator();
        ComplexNumber[] result = instance.stackToArray();
        assertEquals(1,result.length);
        assertEquals(9,result[0].getRe()); //??
        assertEquals(-5,result[0].getIm());  //??
    }
    
    @Test  //1 solo elemento
    public void testDivCalculator2() throws LessThanTwoElementsException, SyntaxException{
        Calculator instance = new Calculator();
        instance.insert("4+3j");
        assertThrows(LessThanTwoElementsException.class, () -> {
            instance.divCalculator();
        });
    }
    
    @Test  //0 elementi
    public void testDivCalculator3() throws LessThanTwoElementsException{
        Calculator instance = new Calculator();
        assertThrows(LessThanTwoElementsException.class, () -> {
            instance.divCalculator();
        });
    }   

    /**
     * Test of sqrtCalculator method, of class Calculator.
     */
    @Test  //caso generale
    public void testSqrtCalculator() throws LessThanOneElementException, SyntaxException {
        Calculator instance = new Calculator();
        instance.insert("4+3j");
        instance.sqrtCalculator();
        ComplexNumber[] result = instance.stackToArray();
        assertEquals(1,result.length);
        assertEquals(9,result[0].getRe()); //??
        assertEquals(-5,result[0].getIm());  //??
    }
    
    @Test  //0 elementi
    public void testSqrtCalculator2() throws LessThanOneElementException{
        Calculator instance = new Calculator();
        assertThrows(LessThanOneElementException.class, () -> {
            instance.sqrtCalculator();
        });
    } 
    

    /**
     * Test of invCalculator method, of class Calculator.
     */
    @Test //caso generale
    public void testInvCalculator() throws LessThanOneElementException, SyntaxException {
        Calculator instance = new Calculator();
        instance.insert("4+3j");
        instance.invCalculator();
        ComplexNumber[] result = instance.stackToArray();
        assertEquals(1,result.length);
        assertEquals(-4,result[0].getRe()); 
        assertEquals(-3,result[0].getIm());  
    }
    
    @Test  //0 elementi
    public void testInvCalculator2() throws LessThanOneElementException{
        Calculator instance = new Calculator();
        assertThrows(LessThanOneElementException.class, () -> {
            instance.invCalculator();
        });
    } 
    

    /**
     * Test of conjCalculator method, of class Calculator.
     */
    @Test //caso generale
    public void testConjCalculator() throws LessThanOneElementException, SyntaxException {
        Calculator instance = new Calculator();
        instance.insert("4+3j");
        instance.conjCalculator();
        ComplexNumber[] result = instance.stackToArray();
        assertEquals(1,result.length);
        assertEquals(4,result[0].getRe()); 
        assertEquals(-3,result[0].getIm());  
    }
    
    @Test  //0 elementi
    public void testConjCalculator2() throws LessThanOneElementException{
        Calculator instance = new Calculator();
        assertThrows(LessThanOneElementException.class, () -> {
            instance.conjCalculator();
        });
    } 

    /**
     * Test of saveOnStack method, of class Calculator.
     */
    @Test
    public void testSaveOnStack() throws Exception {
        System.out.println("saveOnStack");
        Character c = null;
        Calculator instance = new Calculator();
        ComplexNumber expResult = null;
        ComplexNumber result = instance.saveOnStack(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveOnVariable method, of class Calculator.
     */
    @Test
    public void testSaveOnVariable() throws Exception {
        System.out.println("saveOnVariable");
        Character c = null;
        Calculator instance = new Calculator();
        ComplexNumber expResult = null;
        ComplexNumber result = instance.saveOnVariable(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of increaseVariable method, of class Calculator.
     */
    @Test
    public void testIncreaseVariable() throws Exception {
        System.out.println("increaseVariable");
        Character c = null;
        Calculator instance = new Calculator();
        ComplexNumber expResult = null;
        ComplexNumber result = instance.increaseVariable(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of decreaseVariable method, of class Calculator.
     */
    @Test
    public void testDecreaseVariable() throws Exception {
        System.out.println("decreaseVariable");
        Character c = null;
        Calculator instance = new Calculator();
        ComplexNumber expResult = null;
        ComplexNumber result = instance.decreaseVariable(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class Calculator.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        Calculator instance = new Calculator();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drop method, of class Calculator.
     */
    @Test
    public void testDrop() {
        System.out.println("drop");
        Calculator instance = new Calculator();
        instance.drop();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of swap method, of class Calculator.
     */
    @Test
    public void testSwap() throws Exception {
        System.out.println("swap");
        Calculator instance = new Calculator();
        instance.swap();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dup method, of class Calculator.
     */
    @Test
    public void testDup() throws Exception {
        System.out.println("dup");
        Calculator instance = new Calculator();
        instance.dup();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of over method, of class Calculator.
     */
    @Test
    public void testOver() throws Exception {
        System.out.println("over");
        Calculator instance = new Calculator();
        instance.over();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
