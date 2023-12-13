package unisa.ingsoft.ComplexNumber;

import org.junit.jupiter.api.*;

import unisa.ingsoft.Exceptions.SyntaxException;

import static org.junit.jupiter.api.Assertions.*;

public class ComplexNumberTest {
double delta=0.001;

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
    @Test  //caso parte reale positiva parte immaginaria nulla
    public void testSum() {
        ComplexNumber instance = new ComplexNumber(12,0);
        ComplexNumber z = new ComplexNumber(3,0);
        ComplexNumber result = instance.sum(z);
        assertEquals(15, result.getRe(), delta);
        assertEquals(0, result.getIm(), delta);
    }
    @Test  //caso parte reale negativa parte immaginaria nulla
    public void testSum2() {
        ComplexNumber instance = new ComplexNumber(-12,0);
        ComplexNumber z = new ComplexNumber(-3,0);
        ComplexNumber result = instance.sum(z);
        assertEquals(-15, result.getRe(), delta);
        assertEquals(0, result.getIm(), delta);
    }
    @Test  //caso parte reale discorde parte immaginaria nulla
    public void testSum3() {
        ComplexNumber instance = new ComplexNumber(12,0);
        ComplexNumber z = new ComplexNumber(-3,0);
        ComplexNumber result = instance.sum(z);
        assertEquals(9, result.getRe(), delta);
        assertEquals(0, result.getIm(), delta);
    } 
    @Test  //caso parte reale discorde parte immaginaria nulla
    public void testSum4() {
        ComplexNumber instance = new ComplexNumber(-12,0);
        ComplexNumber z = new ComplexNumber(3,0);
        ComplexNumber result = instance.sum(z);
        assertEquals(-9, result.getRe(), delta);
        assertEquals(0, result.getIm(), delta);
    } 
    @Test  //caso parte reale nulla parte immaginaria positiva
    public void testSum5() {
        ComplexNumber instance = new ComplexNumber(0,6);
        ComplexNumber z = new ComplexNumber(0,5);
        ComplexNumber result = instance.sum(z);
        assertEquals(0, result.getRe(), delta);
        assertEquals(11, result.getIm(), delta);
    } 
    @Test  //caso parte reale nulla parte immaginaria negativa
    public void testSum6() {
        ComplexNumber instance = new ComplexNumber(0,-6);
        ComplexNumber z = new ComplexNumber(0,-5);
        ComplexNumber result = instance.sum(z);
        assertEquals(0, result.getRe(), delta);
        assertEquals(-11, result.getIm(), delta);
    } 
    @Test  //caso parte reale nulla parte immaginaria discorde
    public void testSum7() {
        ComplexNumber instance = new ComplexNumber(0,6);
        ComplexNumber z = new ComplexNumber(0,-5);
        ComplexNumber result = instance.sum(z);
        assertEquals(0, result.getRe(), delta);
        assertEquals(1, result.getIm(), delta);
    } 
    @Test  //caso parte reale nulla parte immaginaria discorde
    public void testSum8() {
        ComplexNumber instance = new ComplexNumber(0,-6);
        ComplexNumber z = new ComplexNumber(0,5);
        ComplexNumber result = instance.sum(z);
        assertEquals(0, result.getRe(), delta);
        assertEquals(-1, result.getIm(), delta);
    } 
    @Test  //caso parte reale positiva parte immaginaria positiva
    public void testSum9() {
        ComplexNumber instance = new ComplexNumber(0,-6);
        ComplexNumber z = new ComplexNumber(0,5);
        ComplexNumber result = instance.sum(z);
        assertEquals(0, result.getRe(), delta);
        assertEquals(-1, result.getIm(), delta);
    } 

    /**
     * Test of sub method, of class ComplexNumber.
     */
    @Test  //caso generale
    public void testSub() {
        ComplexNumber instance = new ComplexNumber(12.5,6.3);
        ComplexNumber z = new ComplexNumber(3.3,6.5);
        ComplexNumber result = instance.sub(z);
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
        assertEquals(0.3, result.getRe(), delta);
        assertEquals(102.04, result.getIm(), delta);
    }

    @Test  //primo operando uguale a 0
    public void testMol2() {
        ComplexNumber instance = new ComplexNumber(0,0);
        ComplexNumber z = new ComplexNumber(91,52.91);
        ComplexNumber result = instance.mol(z);
        assertEquals(0, result.getRe(), delta);
        assertEquals(0, result.getIm(), delta);
    }

    @Test  //secondo operando uguale a 0
    public void testMol3() {
        ComplexNumber instance = new ComplexNumber(73.53,24.66);
        ComplexNumber z = new ComplexNumber(0,0);
        ComplexNumber result = instance.mol(z);
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
        assertEquals(1.546, result.getRe(), delta);
        assertEquals(-1.137, result.getIm(), delta);
    }

    @Test  //0 diviso un numero non nullo
    public void testDiv2(){
            ComplexNumber instance = new ComplexNumber(0,0);
            ComplexNumber z = new ComplexNumber(24.5,67.1);
            ComplexNumber result = instance.div(z);
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
        assertEquals(1.146, result.getRe(), delta);
        assertEquals(1.146, result.getIm(), delta);
    }
    
    @Test //parte immaginaria uguale a 0
    public void testSqrt3() {
        ComplexNumber instance = new ComplexNumber(4.81,0);
        ComplexNumber result = instance.sqrt();
        assertEquals(2.193, result.getRe(), delta);
        assertEquals(0, result.getIm(), delta);
    }

    @Test //radice di 0
    public void testSqrt4() {
        ComplexNumber instance = new ComplexNumber(0,0);
        ComplexNumber result = instance.sqrt();
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
        assertEquals(0, result.getRe(), delta);
        assertEquals(-49.39, result.getIm(), delta);
    }
    @Test  //parte immaginaria uguale a 0
    public void testInv4() {
        ComplexNumber instance = new ComplexNumber(-15.82,0);
        ComplexNumber result = instance.inv();
        assertEquals(15.82, result.getRe(), delta);
        assertEquals(0, result.getIm(), delta);
    }

    @Test  //inverso di 0
    public void testInv5() {
        ComplexNumber instance = new ComplexNumber(0,0);
        ComplexNumber result = instance.inv();
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
        assertEquals(-15.82, result.getRe(), delta);
        assertEquals(-49.39, result.getIm(), delta);
    }
    @Test  //parte immaginaria negativa
    public void testConj2() {
        ComplexNumber instance = new ComplexNumber(0,-49.39);
        ComplexNumber result = instance.conj();
        assertEquals(0, result.getRe(), delta);
        assertEquals(49.39, result.getIm(), delta);
    }
    @Test  //parte immaginaria nulla
    public void testConj3() {
        ComplexNumber instance = new ComplexNumber(15.82,0);
        ComplexNumber result = instance.conj();
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
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(4,result.getRe());
        assertEquals(5,result.getIm());
    }

    @Test //parte reale positiva e parte immaginaria positiva con numeri decimali
    public void testParseB() throws SyntaxException{
        String instance = "2.4+34.12j";
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(2.4,result.getRe());
        assertEquals(34.12,result.getIm());
    }

    @Test //parte reale positiva con segno e parte immaginaria positiva
    public void testParse2() throws SyntaxException{
        String instance = "+4+5j";
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(4,result.getRe());
        assertEquals(5,result.getIm());
    }

    @Test //parte reale positiva con segno e parte immaginaria positiva con numeri decimali
    public void testParse2B() throws SyntaxException{
        String instance = "+2.4+34.12j";
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(2.4,result.getRe());
        assertEquals(34.12,result.getIm());
    }

    @Test //parte reale positiva e parte immaginaria negativa
    public void testParse3() throws SyntaxException{
        String instance = "4-5j";
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(4,result.getRe());
        assertEquals(-5,result.getIm());
    }

    @Test //parte reale positiva e parte immaginaria negativa con numeri decimali
    public void testParse3B() throws SyntaxException{
        String instance = "2.4-34.12j";
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(2.4,result.getRe());
        assertEquals(-34.12,result.getIm());
    }

    @Test //parte reale positiva con segno e parte immaginaria negativa
    public void testParse4() throws SyntaxException{
        String instance = "+4-5j";
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(4,result.getRe());
        assertEquals(-5,result.getIm());
    }

    @Test //parte reale positiva con segno e parte immaginaria negativa con numero decimale
    public void testParse4B() throws SyntaxException{
        String instance = "+2.4-34.12j";
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(2.4,result.getRe());
        assertEquals(-34.12,result.getIm());
    }

    @Test //parte reale negativa e parte immaginaria positiva
    public void testParse5() throws SyntaxException{
        String instance = "-4+5j";
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(-4,result.getRe());
        assertEquals(5,result.getIm());
    }

    @Test //parte reale negativa e parte immaginaria positiva con numero decimale
    public void testParse5B() throws SyntaxException{
        String instance = "-2.4+34.12j";
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(-2.4,result.getRe());
        assertEquals(34.12,result.getIm());
    }

    @Test //parte reale negativa e parte immaginaria negativa
    public void testParse6() throws SyntaxException{
        String instance = "-4-5j";
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(-4,result.getRe());
        assertEquals(-5,result.getIm());
    }

    @Test //parte reale negativa e parte immaginaria negativa con numero decimale
    public void testParse6B() throws SyntaxException{
        String instance = "-2.4-34.12j";
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(-2.4,result.getRe());
        assertEquals(-34.12,result.getIm());
    }

    @Test //parte reale positiva e parte immaginaria nulla
    public void testParse7() throws SyntaxException{
        String instance = "4";
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(4,result.getRe());
        assertEquals(0,result.getIm());
    }

    @Test //parte reale positiva e parte immaginaria nulla con numero decimale
    public void testParse7B() throws SyntaxException{
        String instance = "4.537";
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(4.537,result.getRe());
        assertEquals(0,result.getIm());
    }

    @Test //parte reale positiva con segno e parte immaginaria nulla
    public void testParse8() throws SyntaxException{
        String instance = "+4";
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(4,result.getRe());
        assertEquals(0,result.getIm());
    }

    @Test //parte reale positiva con segno e parte immaginaria nulla con numero decimale
    public void testParse8B() throws SyntaxException{
        String instance = "+4.537";
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(4.537,result.getRe());
        assertEquals(0,result.getIm());
    }

    @Test //parte reale negativa e parte immaginaria nulla
    public void testParse9() throws SyntaxException{
        String instance = "-4";
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(-4,result.getRe());
        assertEquals(0,result.getIm());
    }

    @Test //parte reale negativa e parte immaginaria nulla con numero decimale
    public void testParse9B() throws SyntaxException{
        String instance = "-4.537";
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(-4.537,result.getRe());
        assertEquals(0,result.getIm());
    }

    @Test //parte reale nulla e parte immaginaria positiva
    public void testParse10() throws SyntaxException{
        String instance = "5j";
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(0,result.getRe());
        assertEquals(5,result.getIm());
    }

    @Test //parte reale nulla e parte immaginaria positiva con numero decimale
    public void testParse10B() throws SyntaxException{
        String instance = "5.85j";
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(0,result.getRe());
        assertEquals(5.85,result.getIm());
    }

    @Test //parte reale nulla e parte immaginaria positiva con j posta prima
    public void testParse11() throws SyntaxException{
        String instance = "j5";
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(0,result.getRe());
        assertEquals(5,result.getIm());
    }

    @Test //parte reale nulla e parte immaginaria positiva con j posta prima e numero decimale
    public void testParse11B() throws SyntaxException{
        String instance = "j5.85";
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(0,result.getRe());
        assertEquals(5.85,result.getIm());
    }

    @Test //parte reale nulla e parte immaginaria positiva con segno
    public void testParse12() throws SyntaxException{
        String instance = "+5j";
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(0,result.getRe());
        assertEquals(5,result.getIm());
    }

    @Test //parte reale nulla e parte immaginaria positiva con segno e numero decimale
    public void testParse12B() throws SyntaxException{
        String instance = "+5.85j";
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(0,result.getRe());
        assertEquals(5.85,result.getIm());
    }

    @Test //parte reale nulla e parte immaginaria positiva con segno j posta prima
    public void testParse13() throws SyntaxException{
        String instance = "+j5";
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(0,result.getRe());
        assertEquals(5,result.getIm());
    }

    @Test //parte reale nulla e parte immaginaria positiva con segno j posta prima e numero decimale
    public void testParse13B() throws SyntaxException{
        String instance = "+j5.85";
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(0,result.getRe());
        assertEquals(5.85,result.getIm());
    }

    @Test //parte reale nulla e parte immaginaria negativa
    public void testParse14() throws SyntaxException{
        String instance = "-5j";
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(0,result.getRe());
        assertEquals(-5,result.getIm());
    }

    @Test //parte reale nulla e parte immaginaria negativa con numero decimale
    public void testParse14B() throws SyntaxException{
        String instance = "-5.85j";
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(0,result.getRe());
        assertEquals(-5.85,result.getIm());
    }

    @Test //parte reale nulla e parte immaginaria negativa con j posta prima
    public void testParse15() throws SyntaxException{
        String instance = "-j5";
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(0,result.getRe());
        assertEquals(-5,result.getIm());
    }

    @Test //parte reale nulla e parte immaginaria negativa con j posta prima e numero decimale
    public void testParse15B() throws SyntaxException{
        String instance = "-j5.85";
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(0,result.getRe());
        assertEquals(-5.85,result.getIm());
    }
    
    @Test //parte immaginaria nulla con segno -
    public void testParse16() throws SyntaxException{
        String instance = "27.25-0j";
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(27.25,result.getRe());
        assertEquals(0,result.getIm());
    }

    @Test //parte reale nulla con segno -
    public void testParse17() throws SyntaxException{
        String instance = "-0-84.346j";
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(0,result.getRe());
        assertEquals(-84.346,result.getIm());
    }

    @Test //parte reale nulla con segno - e parte immaginaria nulla con segno -
    public void testParse18() throws SyntaxException{
        String instance = "-0-0j";
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(0,result.getRe());
        assertEquals(0,result.getIm());
    }
    
    @Test //parte reale nulla con segno - e parte immaginaria nulla omessa
    public void testParse19() throws SyntaxException{
        String instance = "-0";
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(0,result.getRe());
        assertEquals(0,result.getIm());
    }

    @Test //parte reale nulla omessa e parte immaginaria nulla con segno -
    public void testParse20() throws SyntaxException{
        String instance = "-0j";
        ComplexNumber result = ComplexNumber.parseComplexNumber(instance);
        assertEquals(0,result.getRe());
        assertEquals(0,result.getIm());
    }
    
    @Test //delimitatore non preceduto da numero
    public void testParse21() throws SyntaxException{
        String instance = ".5";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parseComplexNumber(instance);
        });
    }
   
    @Test //solo unità immaginaria
    public void testParse22() throws SyntaxException{
        String instance = "j";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parseComplexNumber(instance);
        });
    }

    @Test //parte reale e solo unità immaginaria
    public void testParse23() throws SyntaxException{
        String instance = "4+j";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parseComplexNumber(instance);
        });
    }

    @Test //unità immaginaria fuori posto
    public void testParse24() throws SyntaxException{
        String instance = "-4+5j3";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parseComplexNumber(instance);
        });
    }

    @Test //più di un segno nella parte immaginaria
    public void testParse25() throws SyntaxException{
        String instance = "-4+-53j";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parseComplexNumber(instance);
        });
    }

    @Test //più di un segno nella parte reale
    public void testParse26() throws SyntaxException{
        String instance = "-+14.1+9.3j";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parseComplexNumber(instance);
        });
    }

    @Test //più di un segno nella parte reale e nella parte immaginaria
    public void testParse27() throws SyntaxException{
        String instance = "-+14.1++9.3j";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parseComplexNumber(instance);
        });
    }

    @Test //più di un segno nella parte reale con parte immaginaria omessa
    public void testParse28() throws SyntaxException{
        String instance = "++-23.34";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parseComplexNumber(instance);
        });
    }

    @Test //più di un segno nella parte immmaginaria con parte reale omessa
    public void testParse29() throws SyntaxException{
        String instance = "++-23.34j";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parseComplexNumber(instance);
        });
    }

    @Test //più di un punto nella parte immaginaria
    public void testParse30() throws SyntaxException{
        String instance = "8.24+368..1j";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parseComplexNumber(instance);
        });
    }

    @Test //più di un punto nella parte reale
    public void testParse31() throws SyntaxException{
        String instance = "8..24+368.1j";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parseComplexNumber(instance);
        });
    }

    @Test //più di un punto nella parte reale e nella parte immaginaria
    public void testParse32() throws SyntaxException{
        String instance = "8..24+368..1j";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parseComplexNumber(instance);
        });
    }

    @Test //più di un punto nella parte reale con parte immaginaria omessa
    public void testParse33() throws SyntaxException{
        String instance = "35..93";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parseComplexNumber(instance);
        });
    }

    @Test //più di un punto nella parte immmaginaria con parte reale omessa
    public void testParse34() throws SyntaxException{
        String instance = "35..93j";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parseComplexNumber(instance);
        });
    }

    @Test //unità immaginaria ripetuta
    public void testParse35() throws SyntaxException{
        String instance = "457.12-j348.61j";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parseComplexNumber(instance);
        });
    }

    @Test //unità immaginaria ripetuta che alla fine con parte reale omessa
    public void testParse36() throws SyntaxException{
        String instance = "16j.8j";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parseComplexNumber(instance);
        });
    }
    
    @Test //stringa vuota
    public void testParse37() throws SyntaxException{
        String instance = "";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parseComplexNumber(instance);
        });
    }
}
