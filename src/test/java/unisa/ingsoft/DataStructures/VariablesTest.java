package unisa.ingsoft.DataStructures;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import unisa.ingsoft.ComplexNumber.ComplexNumber;
import unisa.ingsoft.Exceptions.VariableNotInitializedException;

public class VariablesTest {
    
    public VariablesTest() {
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
     * Test of put method, of class Variables.
     */
    @Test  //caso generale
    public void testPut(){
        Character c = 'c';
        ComplexNumber z=new ComplexNumber(4,4);
        ComplexNumber w=new ComplexNumber(8,8);
        Variables instance = new Variables();
        instance.put(c, z);
        ComplexNumber result = instance.put(c, w); //controllo il funzionamento della put precedente
        assertEquals(4, result.getRe());   
        assertEquals(4, result.getIm());   
    }

    @Test  //caso key = null
    public void testPut2() {
        Character c = null;
        ComplexNumber z=new ComplexNumber(4,4);
        ComplexNumber w=new ComplexNumber(8,8);
        Variables instance = new Variables();
        instance.put(c, z);
        ComplexNumber result = instance.put(c, w); //controllo il funzionamento della put precedente
        assertEquals(4, result.getRe());   
        assertEquals(4, result.getIm());  
    }

    @Test  //caso value = null
    public void testPut3() {
        Character c = 'c';
        ComplexNumber z=null;
        ComplexNumber w=new ComplexNumber(8,8);
        Variables instance = new Variables();
        instance.put(c, z);
        ComplexNumber result = instance.put(c, w); //controllo il funzionamento della put precedente
        assertEquals(null, result);   
        ComplexNumber result2 = instance.put(c, z); //controllo il funzionamento della put precedente
        assertEquals(8, result2.getRe()); 
        assertEquals(8, result2.getIm());    
    }
    
    /**
     * Test of get method, of class Variables.
     */
    @Test  //caso generale
    public void testGet() throws VariableNotInitializedException {
        Character c = 'c';
        ComplexNumber z=new ComplexNumber(4,4);
        Variables instance = new Variables();
        instance.put(c, z);
        ComplexNumber result=instance.get(c);
        assertEquals(4, result.getRe());   
        assertEquals(4, result.getIm()); 
    }
    @Test  //variabile non inizializzata
    public void testGet2()throws VariableNotInitializedException {
        Character c = 'c';
        Variables instance = new Variables();
        assertThrows(VariableNotInitializedException.class, () -> {
            instance.get(c);
     }); 
    }

    /**
     * Test of increase method, of class Variables.
     */
    @Test  //caso generale
    public void testIncrease() throws VariableNotInitializedException {
        Character c = 'c';
        ComplexNumber z=new ComplexNumber(4,4);
        ComplexNumber w=new ComplexNumber(7,8);
        Variables instance = new Variables();
        instance.put(c,w);
        ComplexNumber result=instance.increase(c,z);
        assertEquals(11,result.getRe());
        assertEquals(12,result.getIm());
    }
    @Test  //variabile non inizializzata
    public void testIncrease2() throws VariableNotInitializedException {
        Character c = 'c';
        ComplexNumber z=new ComplexNumber(4,4);
        Variables instance = new Variables(); 
        assertThrows(VariableNotInitializedException.class, () -> {
            instance.increase(c,z);
     }); 
    }
    /**
     * Test of decrease method, of class Variables.
     */
    @Test  //caso generale
    public void testDecrease() throws VariableNotInitializedException {
        Character c = 'c';
        ComplexNumber z=new ComplexNumber(4,4);
        ComplexNumber w=new ComplexNumber(7,8);
        Variables instance = new Variables();
        instance.put(c,w);
        ComplexNumber result=instance.decrease(c,z);
        assertEquals(3,result.getRe());
        assertEquals(4,result.getIm());
    }
    @Test  //variabile non inizializzata
    public void testDecrease2() throws VariableNotInitializedException {
        Character c = 'c';
        ComplexNumber z=new ComplexNumber(4,4);
        Variables instance = new Variables(); 
        assertThrows(VariableNotInitializedException.class, () -> {
            instance.decrease(c,z);
     }); 
    
}
}