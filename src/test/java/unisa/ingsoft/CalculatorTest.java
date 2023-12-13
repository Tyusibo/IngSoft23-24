package unisa.ingsoft;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import unisa.ingsoft.ComplexNumber.ComplexNumber;
import unisa.ingsoft.DataStructures.CustomStack;
import unisa.ingsoft.DataStructures.Variables;
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
    @Test
    public void testStackToArray() throws SyntaxException {
        Calculator instance = new Calculator();
        instance.insert("4+3j");instance.insert("4+3j");instance.insert("4+3j");
        ComplexNumber[] result = instance.stackToArray();
        assertEquals(3,result.length);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
    
    /**
     * Test of insert method, of class Calculator.
     */
    @Test  //caso generale
    public void testInsert() throws SyntaxException{
        Calculator instance = new Calculator();
        String number="3+5j";
        instance.insert(number);
        /*
        ComplexNumber result=instance.stack.peek();
        assertEquals(1,stack.size());
        assertEquals(3,result.getRe());
        assertEquals(6,result.getIm());
        */
    }

    /**
     * Test of sumCalculator method, of class Calculator.
     */
    @Test
    public void testSumCalculator() throws Exception {
        Variables vars=new Variables();
        CustomStack<ComplexNumber> stack=new CustomStack<>();
        stack.push(new ComplexNumber(4,4));
        System.out.println("sumCalculator");
        Calculator instance = new Calculator();
        ComplexNumber expResult = null;
        ComplexNumber result = instance.sumCalculator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of subCalculator method, of class Calculator.
     */
    @Test
    public void testSubCalculator() throws Exception {
        System.out.println("subCalculator");
        Calculator instance = new Calculator();
        ComplexNumber expResult = null;
        ComplexNumber result = instance.subCalculator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of molCalculator method, of class Calculator.
     */
    @Test
    public void testMolCalculator() throws Exception {
        System.out.println("molCalculator");
        Calculator instance = new Calculator();
        ComplexNumber expResult = null;
        ComplexNumber result = instance.molCalculator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of divCalculator method, of class Calculator.
     */
    @Test
    public void testDivCalculator() throws Exception {
        System.out.println("divCalculator");
        Calculator instance = new Calculator();
        ComplexNumber expResult = null;
        ComplexNumber result = instance.divCalculator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sqrtCalculator method, of class Calculator.
     */
    @Test
    public void testSqrtCalculator() throws Exception {
        System.out.println("sqrtCalculator");
        Calculator instance = new Calculator();
        ComplexNumber expResult = null;
        ComplexNumber result = instance.sqrtCalculator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of invCalculator method, of class Calculator.
     */
    @Test
    public void testInvCalculator() throws Exception {
        System.out.println("invCalculator");
        Calculator instance = new Calculator();
        ComplexNumber expResult = null;
        ComplexNumber result = instance.invCalculator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of conjCalculator method, of class Calculator.
     */
    @Test
    public void testConjCalculator() throws Exception {
        System.out.println("conjCalculator");
        Calculator instance = new Calculator();
        ComplexNumber expResult = null;
        ComplexNumber result = instance.conjCalculator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
