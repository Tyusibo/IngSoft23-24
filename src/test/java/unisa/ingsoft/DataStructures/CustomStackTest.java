package unisa.ingsoft.DataStructures;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import unisa.ingsoft.Exceptions.LessThanOneElementException;
import unisa.ingsoft.Exceptions.LessThanTwoElementsException;

public class CustomStackTest {
    
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
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    
     /**
     * Test of drop method, of class CustomStack.
     */
    @Test  //caso generale
    public void testDrop() {
        CustomStack<Integer> instance = new CustomStack<>();
        instance.push(1); instance.push(2); instance.push(3); 
        instance.drop();
        assertEquals(2,instance.size());
        assertEquals(2,instance.pop());
        assertEquals(1,instance.pop());    
        instance.drop();
        assertTrue(instance.isEmpty());
    }
    

    @Test  //caso con 0 elementi
    public void testDrop2() {
        CustomStack<Integer> instance = new CustomStack<>();
        instance.drop();
        assertTrue(instance.isEmpty());
    }
    
    /**
     * Test of clear method, of class CustomStack.
     */
    @Test  //caso generale
    public void testClear() {
        CustomStack<Integer> instance = new CustomStack<>();
        instance.push(1); instance.push(2); instance.push(3); 
        instance.clear();
        assertTrue(instance.isEmpty());
    }
    
    @Test  //caso con 0 elementi
    public void testClear2() {
        CustomStack<Integer> instance = new CustomStack<>();
        instance.clear();
        assertTrue(instance.isEmpty());
    }

    /**
     * Test of swap method, of class CustomStack.
     */
    @Test  //caso generale
    public void testSwap() throws LessThanTwoElementsException {
        CustomStack<Integer> instance = new CustomStack<>();
        instance.push(1); instance.push(2); instance.push(3); 
        instance.swap();
        assertEquals(3,instance.size());
        assertEquals(2,instance.pop());
        assertEquals(3,instance.pop());
        assertEquals(1,instance.pop()); 
    }
    
    @Test  //caso con 1 elemento
    public void testSwap2() throws LessThanTwoElementsException{
        CustomStack<Integer> instance = new CustomStack<> ();
        instance.push(1); 
        assertThrows(LessThanTwoElementsException.class, () -> {
            instance.swap();
     });
    }
                
    @Test  //caso con 0 elementi
    public void testSwap3() throws LessThanTwoElementsException {
        CustomStack<Integer>  instance = new CustomStack<> ();
        assertThrows(LessThanTwoElementsException.class, () -> {
            instance.swap();
     });
    }

    /**
     * Test of dup method, of class CustomStack.
     */
    @Test //caso generale
    public void testDup() throws LessThanOneElementException {
        CustomStack<Integer> instance = new CustomStack<>();
        instance.push(1); instance.push(2); instance.push(3); 
        instance.dup();
        assertEquals(4,instance.size());
        assertEquals(3,instance.pop());
        assertEquals(3,instance.pop());
        assertEquals(2,instance.pop());
        assertEquals(1,instance.pop());         
    }
    
    @Test //caso con 0 elementi
    public void testDup2() throws LessThanOneElementException{
        CustomStack<Integer>  instance = new CustomStack<> ();
        assertThrows(LessThanOneElementException.class, () -> {
            instance.dup();
     });       
    }

    /**
     * Test of over method, of class CustomStack.
     */
    @Test  //caso generale
    public void testOver() throws LessThanTwoElementsException {
        CustomStack<Integer>  instance = new CustomStack<> ();
        instance.push(1); instance.push(2); instance.push(3);  
        instance.over();
        assertEquals(4,instance.size());
        assertEquals(2,instance.pop());
        assertEquals(3,instance.pop());
        assertEquals(2,instance.pop());
        assertEquals(1,instance.pop()); 
    }
    @Test  //caso con 1 elemento
    public void testOver2() throws LessThanTwoElementsException {
        CustomStack<Integer>  instance = new CustomStack<> ();
        instance.push(1); 
        assertThrows(LessThanTwoElementsException.class, () -> {
            instance.over();
     }); 
    }
    
    @Test  //caso con 0 elementi
    public void testOver3() throws LessThanTwoElementsException {
        CustomStack<Integer>  instance = new CustomStack<> ();
        assertThrows(LessThanTwoElementsException.class, () -> {
            instance.over();
     }); 
    }
    
}
