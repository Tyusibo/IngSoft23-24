package unisa.ingsoft.DataStructures;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import unisa.ingsoft.ComplexNumber.ComplexNumber;
import unisa.ingsoft.Exceptions.VariableNotInitializedException;

public class VariablesTest {
Variables instance;
double delta=0.001;

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
        instance = new Variables();
    }
    
    @AfterEach
    public void tearDown() {
    }

        /**
     * Test of put method, of class Variables.
     */
    @Test  //caso generale
    public void testPut()throws VariableNotInitializedException {
        Character c = 'c';
        ComplexNumber z=new ComplexNumber(4,4);
        ComplexNumber w=new ComplexNumber(8,8);
        instance.put(c, z);
        ComplexNumber result = instance.put(c, w); //controllo il funzionamento della put precedente
        assertEquals(4, result.getRe(), delta);   
        assertEquals(4, result.getIm(), delta);  
    }

    @Test  //caso key = null
    public void testPut2() {
        Character c = null;
        ComplexNumber z=new ComplexNumber(4,4);
        ComplexNumber w=new ComplexNumber(8,8);
        instance.put(c, z);
        ComplexNumber result = instance.put(c, w); //controllo il funzionamento della put precedente
        assertEquals(4, result.getRe(), delta);   
        assertEquals(4, result.getIm(), delta);  
    }

    @Test  //caso value = null
    public void testPut3() {
        Character c = 'c';
        ComplexNumber z=null;
        ComplexNumber w=new ComplexNumber(8,8);
        instance.put(c, z);
        ComplexNumber result = instance.put(c, w); //controllo il funzionamento della put precedente
        assertEquals(null, result);   
        ComplexNumber result2 = instance.put(c, z); //controllo il funzionamento della put precedente
        assertEquals(8, result2.getRe(), delta); 
        assertEquals(8, result2.getIm(), delta);    
    }

    /**
     * Test of get method, of class Variables.
     */
    @Test  //caso generale
    public void testGet() throws VariableNotInitializedException {
        Character c = 'a';
        ComplexNumber z=new ComplexNumber(4,4);
        instance.put(c, z);
        ComplexNumber result=instance.get(c);
        assertEquals(4, result.getRe(), delta);   
        assertEquals(4, result.getIm(), delta); 
    }
    @Test  //variabile non inizializzata
    public void testGet2()throws VariableNotInitializedException {
        Character c = 'a';
        assertThrows(VariableNotInitializedException.class, () -> {
            instance.get(c);
     }); 
    }
    /**
     * Test of increase method, of class Variables.
     */
    @Test  //caso generale
    public void testIncrease() throws VariableNotInitializedException {
        Character c = 'a';
        ComplexNumber z=new ComplexNumber(4,4);
        ComplexNumber w=new ComplexNumber(7,8);
        instance.put(c,w);
        ComplexNumber result=instance.increase(c,z);
        assertEquals(11,result.getRe(), delta);
        assertEquals(12,result.getIm(), delta);
    }
    @Test  //variabile non inizializzata
    public void testIncrease2() throws VariableNotInitializedException {
        Character c = 'a';
        ComplexNumber z=new ComplexNumber(4,4);
        assertThrows(VariableNotInitializedException.class, () -> {
            instance.increase(c,z);
     }); 
    }
    /**
     * Test of decrease method, of class Variables.
     */
    @Test  //caso generale
    public void testDecrease() throws VariableNotInitializedException {
        Character c = 'a';
        ComplexNumber z=new ComplexNumber(4,4);
        ComplexNumber w=new ComplexNumber(7,8);
        instance.put(c,w);
        ComplexNumber result=instance.decrease(c,z);
        assertEquals(3,result.getRe(), delta);
        assertEquals(4,result.getIm(), delta);
    }
    @Test  //variabile non inizializzata
    public void testDecrease2() throws VariableNotInitializedException {
        Character c = 'a';
        ComplexNumber z=new ComplexNumber(4,4);
        assertThrows(VariableNotInitializedException.class, () -> {
            instance.decrease(c,z);
     }); 
    
}
}
