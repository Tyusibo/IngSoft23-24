package unisa.ingsoft.ComplexNumber;

import org.junit.jupiter.api.*;

import unisa.ingsoft.Exceptions.SyntaxException;

import static org.junit.jupiter.api.Assertions.*;

public class ComplexNumberTest {
    
    public ComplexNumberTest() {
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
     * Test of getRe method, of class ComplexNumber.
     */ 
    @Test  //caso generale
    public void testGetRe() {
        ComplexNumber instance = new ComplexNumber(3.3,6.5);
        assertEquals(3.3, instance.getRe());
    }

    /**
     * Test of getIm method, of class ComplexNumber.
     */
    @Test  //caso generale
    public void testGetIm() {
        ComplexNumber instance = new ComplexNumber(3.3,6.5);
        assertEquals(6.5, instance.getIm());
    }

    /**
     * Test of sum method, of class ComplexNumber.
     */
    @Test  //caso generale
    public void testSum() {
        ComplexNumber instance = new ComplexNumber(12.5,6.3);
        ComplexNumber z = new ComplexNumber(3.3,6.5);
        ComplexNumber result = instance.sum(z);
        double delta=0.001;
        assertEquals(15.8, result.getRe(), delta);
        assertEquals(12.8, result.getIm(), delta);
    }

    /**
     * Test of sub method, of class ComplexNumber.
     */
    @Test  //caso generale
    public void testSub() {
        ComplexNumber instance = new ComplexNumber(12.5,6.3);
        ComplexNumber z = new ComplexNumber(3.3,6.5);
        ComplexNumber result = instance.sub(z);
        double delta=0.001;
        assertEquals(9.2, result.getRe(), delta);
        assertEquals(-0.2, result.getIm(), delta);
    }

    /**
     * Test of mol method, of class ComplexNumber.
     */
    @Test  //caso generale
    public void testMol() {
        ComplexNumber instance = new ComplexNumber(12.5,6.3);
        ComplexNumber z = new ComplexNumber(3.3,6.5);
        ComplexNumber result = instance.mol(z);
        double delta=0.001;
        assertEquals(0.3, result.getRe(), delta);
        assertEquals(102.04, result.getIm(), delta);
    }

    @Test  //primo operando uguale a 0
    public void testMol2() {
        ComplexNumber instance = new ComplexNumber(0,0);
        ComplexNumber z = new ComplexNumber(91,52.91);
        ComplexNumber result = instance.mol(z);
        double delta=0.001;
        assertEquals(0, result.getRe(), delta);
        assertEquals(0, result.getIm(), delta);
    }

    @Test  //secondo operando uguale a 0
    public void testMol3() {
        ComplexNumber instance = new ComplexNumber(73.53,24.66);
        ComplexNumber z = new ComplexNumber(0,0);
        ComplexNumber result = instance.mol(z);
        double delta=0.001;
        assertEquals(0, result.getRe(), delta);
        assertEquals(0, result.getIm(), delta);
    }

    /**
     * Test of div method, of class ComplexNumber.
     */
    @Test  //caso generale
    public void testDiv() {
        ComplexNumber instance = new ComplexNumber(12.5,6.3);
        ComplexNumber z = new ComplexNumber(3.3,6.5);
        ComplexNumber result = instance.div(z);
        double delta=0.001;
        assertEquals(1.546, result.getRe(), delta);
        assertEquals(-1.137, result.getIm(), delta);
    }

    @Test  //0 diviso un numero non nullo
    public void testDiv2(){
            ComplexNumber instance = new ComplexNumber(0,0);
            ComplexNumber z = new ComplexNumber(24.5,67.1);
            ComplexNumber result = instance.div(z);
            double delta=0.001;
            assertEquals(0, result.getRe(), delta);
            assertEquals(0, result.getIm(), delta);
    }
    @Test  //divisione per 0
    public void testDiv3() throws ArithmeticException{
        ComplexNumber instance = new ComplexNumber(12.5,6.3);
        ComplexNumber z = new ComplexNumber(0,0);
        assertThrows(ArithmeticException.class, () -> {
            instance.div(z);
        });
    }
    @Test  //0 diviso 0
    public void testDiv4() throws ArithmeticException{
        ComplexNumber instance = new ComplexNumber(0,0);
        ComplexNumber z = new ComplexNumber(0,0);
        assertThrows(ArithmeticException.class, () -> {
            instance.div(z);
        });
    }
    /**
     * Test of sqrt method, of class ComplexNumber.
     */
    @Test  //caso generale
    public void testSqrt() {
        ComplexNumber instance = new ComplexNumber(4.81,2.63);
        ComplexNumber result = instance.sqrt();
        double delta=0.001;
        assertEquals(2.268, result.getRe(), delta);
        assertEquals(0.579, result.getIm(), delta);
        ComplexNumber instance1 = new ComplexNumber(4.81,-2.63);
        ComplexNumber result1 = instance1.sqrt();
        assertEquals(2.268, result1.getRe(), delta);
        assertEquals(-0.579, result1.getIm(), delta);
        ComplexNumber instance2 = new ComplexNumber(-4.81,-2.63);
        ComplexNumber result2 = instance2.sqrt();
        assertEquals(0.579, result2.getRe(), delta);
        assertEquals(-2.268, result2.getIm(), delta);
        ComplexNumber instance3 = new ComplexNumber(-4.81,+2.63);
        ComplexNumber result3 = instance3.sqrt();
        assertEquals(0.579, result3.getRe(), delta);
        assertEquals(+2.268, result3.getIm(), delta);
    }
    @Test //parte reale uguale a 0
    public void testSqrt2() {
        ComplexNumber instance = new ComplexNumber(0,2.63);
        ComplexNumber result = instance.sqrt();
        double delta=0.001;
        assertEquals(1.146, result.getRe(), delta);
        assertEquals(1.146, result.getIm(), delta);
    }
    
    @Test //parte immaginaria uguale a 0
    public void testSqrt3() {
        ComplexNumber instance = new ComplexNumber(4.81,0);
        ComplexNumber result = instance.sqrt();
        double delta=0.001;
        assertEquals(2.193, result.getRe(), delta);
        assertEquals(0, result.getIm(), delta);
    }

    @Test //radice di 0
    public void testSqrt4() {
        ComplexNumber instance = new ComplexNumber(0,0);
        ComplexNumber result = instance.sqrt();
        double delta=0.001;
        assertEquals(0, result.getRe(), delta);
        assertEquals(0, result.getIm(), delta);
    } 
    /**
     * Test of inv method, of class ComplexNumber.
     */
    @Test  //caso segni discordi
    public void testInv() {
        ComplexNumber instance = new ComplexNumber(-15.82,49.39);
        ComplexNumber result = instance.inv();
        double delta=0.001;
        assertEquals(15.82, result.getRe(), delta);
        assertEquals(-49.39, result.getIm(), delta);
        ComplexNumber instance1 = new ComplexNumber(15.82,-49.39);
        ComplexNumber result1 = instance1.inv();
        assertEquals(-15.82, result1.getRe(), delta);
        assertEquals(49.39, result1.getIm(), delta);
    }

    @Test  //caso segni concordi 
    public void testInv2() {
        ComplexNumber instance = new ComplexNumber(15.82,49.39);
        ComplexNumber result = instance.inv();
        double delta=0.001;
        assertEquals(-15.82, result.getRe(), delta);
        assertEquals(-49.39, result.getIm(), delta);
        ComplexNumber instance1 = new ComplexNumber(-15.82,-49.39);
        ComplexNumber result1 = instance1.inv();
        assertEquals(15.82, result1.getRe(), delta);
        assertEquals(49.39, result1.getIm(), delta);
    }
    @Test  //parte reale uguale a 0
    public void testInv3() {
        ComplexNumber instance = new ComplexNumber(0,49.39);
        ComplexNumber result = instance.inv();
        double delta=0.001;
        assertEquals(0, result.getRe(), delta);
        assertEquals(-49.39, result.getIm(), delta);
    }
    @Test  //parte immaginaria uguale a 0
    public void testInv4() {
        ComplexNumber instance = new ComplexNumber(-15.82,0);
        ComplexNumber result = instance.inv();
        double delta=0.001;
        assertEquals(15.82, result.getRe(), delta);
        assertEquals(0, result.getIm(), delta);
    }

    @Test  //inverso di 0
    public void testInv5() {
        ComplexNumber instance = new ComplexNumber(0,0);
        ComplexNumber result = instance.inv();
        double delta=0.001;
        assertEquals(0, result.getRe(), delta);
        assertEquals(0, result.getIm(), delta);
    }

    /**
     * Test of conj method, of class ComplexNumber.
     */
    @Test  //parte immaginaria positiva
    public void testConj() {
        ComplexNumber instance = new ComplexNumber(-15.82,49.39);
        ComplexNumber result = instance.conj();
        double delta=0.001;
        assertEquals(-15.82, result.getRe(), delta);
        assertEquals(-49.39, result.getIm(), delta);
    }
    @Test  //parte immaginaria negativa
    public void testConj2() {
        ComplexNumber instance = new ComplexNumber(0,-49.39);
        ComplexNumber result = instance.conj();
        double delta=0.001;
        assertEquals(0, result.getRe(), delta);
        assertEquals(49.39, result.getIm(), delta);
    }
    @Test  //parte immaginaria nulla
    public void testConj3() {
        ComplexNumber instance = new ComplexNumber(15.82,0);
        ComplexNumber result = instance.conj();
        double delta=0.001;
        assertEquals(15.82, result.getRe(), delta);
        assertEquals(0, result.getIm(), delta);
    }

    /**
     * Test of toString method, of class ComplexNumber.
     */
    @Test //parte reale positiva e parte immaginaria positiva
    public void testToString() {
        ComplexNumber instance = new ComplexNumber(12.5,6.3);
        String result = instance.toString();
        assertEquals("12.5+6.3j", result);
    }
    
    @Test  //parte reale positiva e parte immaginaria negativa
    public void testToString2() {
        ComplexNumber instance = new ComplexNumber(12.5,-6.3);
        String result = instance.toString();
        assertEquals("12.5-6.3j", result);
    }

    @Test //parte reale negativa e parte immaginaria positiva
    public void testToString3() {
        ComplexNumber instance = new ComplexNumber(-12.5,6.3);
        String result = instance.toString();
        assertEquals("-12.5+6.3j", result);
    }
    
    @Test  //parte reale negativa e parte immaginaria negativa
    public void testToString4() {
        ComplexNumber instance = new ComplexNumber(-12.5,-6.3);
        String result = instance.toString();
        assertEquals("-12.5-6.3j", result);
    }
    
    @Test //parte reale nulla e parte immaginaria positiva
    public void testToString5() {
        ComplexNumber instance = new ComplexNumber(0,+6.3);
        String result = instance.toString();
        assertEquals("6.3j", result);
    }
    
    @Test  //parte reale nulla e parte immaginaria negativa
    public void testToString6() {
        ComplexNumber instance = new ComplexNumber(0,-6.3);
        String result = instance.toString();
        assertEquals("-6.3j", result);
    }
    
    @Test  //parte reale positiva e parte immaginaria nulla
    public void testToString7() {
        ComplexNumber instance = new ComplexNumber(12.5,0);
        String result = instance.toString();
        assertEquals("12.5", result);
    }
    
    @Test  //parte reale negativa e parte immaginaria nulla
    public void testToString8() {
        ComplexNumber instance = new ComplexNumber(-12,0);
        String result = instance.toString();
        assertEquals("-12", result);
    }

    @Test  //parte reale nulla e parte immaginaria nulla
    public void testToString9() {
        ComplexNumber instance = new ComplexNumber(0,0);
        String result = instance.toString();
        assertEquals("0", result);
    }
    

    /**
     * Test of Parse method, of class ComplexNumber.
     */
    @Test //parte reale positiva e parte immaginaria positiva
    public void testParse() throws SyntaxException{
        String instance = "4+5j";
        ComplexNumber result = ComplexNumber.parseComplexNumber((instance));
        assertEquals(4,result.getRe());
        assertEquals(5,result.getIm());
    }

    @Test //parte reale positiva e parte immaginaria negativa
    public void testParse2() throws SyntaxException{
        String instance = "4-5j";
        ComplexNumber result = ComplexNumber.parseComplexNumber((instance));
        assertEquals(4,result.getRe());
        assertEquals(-5,result.getIm());
    }

    @Test //parte reale negativa e parte immaginaria positiva
    public void testParse3() throws SyntaxException{
        String instance = "-4+5j";
        ComplexNumber result = ComplexNumber.parseComplexNumber((instance));
        assertEquals(-4,result.getRe());
        assertEquals(+5,result.getIm());
    }

    @Test //parte reale negativa e parte immaginaria negativa
    public void testParse4() throws SyntaxException{
        String instance = "-4-5j";
        ComplexNumber result = ComplexNumber.parseComplexNumber((instance));
        assertEquals(-4,result.getRe());
        assertEquals(-5,result.getIm());
    }

    @Test //parte reale positiva e parte immaginaria nulla
    public void testParse5() throws SyntaxException{
        String instance = "4";
        ComplexNumber result = ComplexNumber.parseComplexNumber((instance));
        assertEquals(4,result.getRe());
        assertEquals(0,result.getIm());
    }

    @Test //parte reale negativa e parte immaginaria nulla
    public void testParse6() throws SyntaxException{
        String instance = "-4";
        ComplexNumber result = ComplexNumber.parseComplexNumber((instance));
        assertEquals(-4,result.getRe());
        assertEquals(0,result.getIm());
    }

    @Test //parte reale nulla e parte immaginaria positiva
    public void testParse7() throws SyntaxException{
        String instance = "5j";
        ComplexNumber result = ComplexNumber.parseComplexNumber((instance));
        assertEquals(0,result.getRe());
        assertEquals(5,result.getIm());
    }

    @Test //parte reale nulla e parte immaginaria negativa
    public void testParse8() throws SyntaxException{
        String instance = "-4j";
        ComplexNumber result = ComplexNumber.parseComplexNumber((instance));
        assertEquals(0,result.getRe());
        assertEquals(-4,result.getIm());
    }

    @Test //parte reale nulla e parte immaginaria nulla
    public void testParse9() throws SyntaxException{
        String instance = "-0-0j";
        ComplexNumber result = ComplexNumber.parseComplexNumber((instance));
        assertEquals(0,result.getRe());
        assertEquals(0,result.getIm());
    }

    @Test //parte reale nulla e parte immaginaria nulla omessa
    public void testParse10() throws SyntaxException{
        String instance = "-0";
        ComplexNumber result = ComplexNumber.parseComplexNumber((instance));
        assertEquals(0,result.getRe());
        assertEquals(0,result.getIm());
    }

    @Test //parte reale nulla omessa e parte immaginaria nulla
    public void testParse11() throws SyntaxException{
        String instance = "-0j";
        ComplexNumber result = ComplexNumber.parseComplexNumber((instance));
        assertEquals(0,result.getRe());
        assertEquals(0,result.getIm());
    }
}
