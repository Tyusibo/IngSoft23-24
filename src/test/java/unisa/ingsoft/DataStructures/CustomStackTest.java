package unisa.ingsoft.DataStructures;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import unisa.ingsoft.ComplexNumber.ComplexNumber;
import unisa.ingsoft.Exceptions.LessThanOneElementException;
import unisa.ingsoft.Exceptions.LessThanTwoElementsException;

public class CustomStackTest{
CustomStack<ComplexNumber> instance; 
double delta=0.001;
    public CustomStackTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        instance= new CustomStack<>();
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    /**
    * Test of drop method, of class CustomStack.
    */
    @Test  //caso generale
    public void testDrop() {
        instance.push(new ComplexNumber(1,1));
        instance.push(new ComplexNumber(2,2));
        instance.drop();
        assertEquals(1,instance.size());
        ComplexNumber result=instance.peek();
        assertEquals(1,result.getRe(), delta);
        assertEquals(1,result.getIm(), delta);    
        instance.drop();
        assertTrue(instance.isEmpty());
    }
    
    @Test  //caso con 0 elementi
    public void testDrop2() {
        instance.drop();
        assertTrue(instance.isEmpty());
    }
    
    /**
     * Test of clear method, of class CustomStack.
     */
    @Test  //caso generale
    public void testClear() {
        instance.push(new ComplexNumber(1,1)); 
        instance.clear();
        assertTrue(instance.isEmpty());
    }
    
    @Test  //caso con 0 elementi
    public void testClear2() {
        instance.clear();
        assertTrue(instance.isEmpty());
    }

    /**
     * Test of swap method, of class CustomStack.
     */
    @Test  //caso generale
    public void testSwap() throws LessThanTwoElementsException {
        instance.push(new ComplexNumber(1,1));
        instance.push(new ComplexNumber(2,2));
        instance.swap();
        assertEquals(2,instance.size());
        ComplexNumber result1=instance.pop();
        assertEquals(1,result1.getRe(), delta);
        assertEquals(1,result1.getIm(), delta); 
        ComplexNumber result2=instance.pop();
        assertEquals(2,result2.getRe(), delta);
        assertEquals(2,result2.getIm(), delta);
    }
    
    @Test  //caso con 1 elemento
    public void testSwap2() throws LessThanTwoElementsException{
        instance.push(new ComplexNumber(1,1));
        assertThrows(LessThanTwoElementsException.class, () -> {
            instance.swap();
     });
    }
                
    @Test  //caso con 0 elementi
    public void testSwap3() throws LessThanTwoElementsException {
        assertThrows(LessThanTwoElementsException.class, () -> {
            instance.swap();
     });
    }

    /**
     * Test of dup method, of class CustomStack.
     */
    @Test //caso generale
    public void testDup() throws LessThanOneElementException {
        instance.push(new ComplexNumber(1,1));
        instance.dup();
        assertEquals(2,instance.size());
        ComplexNumber result2=instance.pop();
        assertEquals(1,result2.getRe(), delta);
        assertEquals(1,result2.getIm(), delta); 
        ComplexNumber result1=instance.pop();
        assertEquals(1,result1.getRe(), delta);
        assertEquals(1,result1.getIm(), delta);        
    }
    
    @Test //caso con 0 elementi
    public void testDup2() throws LessThanOneElementException{
        assertThrows(LessThanOneElementException.class, () -> {
            instance.dup();
     });       
    }

    /**
     * Test of over method, of class CustomStack.
     */
    @Test  //caso generale
    public void testOver() throws LessThanTwoElementsException {
        instance.push(new ComplexNumber(1,1));
        instance.push(new ComplexNumber(2,2));
        instance.over();
        assertEquals(3,instance.size());
        ComplexNumber result1=instance.pop();
        assertEquals(1,result1.getRe(), delta);
        assertEquals(1,result1.getIm(), delta); 
        ComplexNumber result2=instance.pop();
        assertEquals(2,result2.getRe(), delta);
        assertEquals(2,result2.getIm(), delta); 
        ComplexNumber result3=instance.pop();
        assertEquals(1,result3.getRe(), delta);
        assertEquals(1,result3.getIm(), delta); 
    }
    @Test  //caso con 1 elemento
    public void testOver2() throws LessThanTwoElementsException {
        instance.push(new ComplexNumber(1,1));
        assertThrows(LessThanTwoElementsException.class, () -> {
            instance.over();
     }); 
    }
    
    @Test  //caso con 0 elementi
    public void testOver3() throws LessThanTwoElementsException {
        assertThrows(LessThanTwoElementsException.class, () -> {
            instance.over();
     }); 
    }
    
}
