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
    @Test //somma tra 2 numeri complessi con parti reali e immaginarie non nulle
    public void testSum() {
        ComplexNumber instance = new ComplexNumber(12.3,27.1);
        ComplexNumber z = new ComplexNumber(74.4,91.4);
        ComplexNumber result = instance.sum(z);
        assertEquals(86.7, result.getRe(), delta);
        assertEquals(118.5, result.getIm(), delta);
    }
    @Test //somma tra 2 numeri complessi di cui uno con parte immaginaria nulla
    public void testSum2() {
        ComplexNumber instance = new ComplexNumber(12.3,27.1);
        ComplexNumber z = new ComplexNumber(74.4,0);
        ComplexNumber result = instance.sum(z);
        assertEquals(86.7, result.getRe(), delta);
        assertEquals(27.1, result.getIm(), delta);
    }
    @Test  //somma tra 2 numeri complessi di cui uno con parte reale nulla
    public void testSum3() {
        ComplexNumber instance = new ComplexNumber(12.3,-27.1);
        ComplexNumber z = new ComplexNumber(0, 91.4);
        ComplexNumber result = instance.sum(z);
        assertEquals(12.3, result.getRe(), delta);
        assertEquals(64.3, result.getIm(), delta);
    } 
    @Test  //somma tra 2 numeri complessi di cui uno nullo
    public void testSum4() {
        ComplexNumber instance = new ComplexNumber(12.3,27.1);
        ComplexNumber z = new ComplexNumber(0,0);
        ComplexNumber result = instance.sum(z);
        assertEquals(12.3, result.getRe(), delta);
        assertEquals(27.1, result.getIm(), delta);
    } 
    @Test  //somma tra 2 numeri complessi entrambi con parte immaginaria nulla
    public void testSum5() {
        ComplexNumber instance = new ComplexNumber(12.3,0);
        ComplexNumber z = new ComplexNumber(-74.4,0);
        ComplexNumber result = instance.sum(z);
        assertEquals(-62.1, result.getRe(), delta);
        assertEquals(0, result.getIm(), delta);
    } 
    @Test  //somma tra 2 numeri complessi di cui uno con parte immaginaria nulla e l'altro con parte reale nulla
    public void testSum6() {
        ComplexNumber instance = new ComplexNumber(-12.3,0);
        ComplexNumber z = new ComplexNumber(0,91.4);
        ComplexNumber result = instance.sum(z);
        assertEquals(-12.3, result.getRe(), delta);
        assertEquals(91.4, result.getIm(), delta);
    } 
    @Test  //somma tra 2 numeri complessi di cui uno nullo e uno con parte immaginaria nulla
    public void testSum7() {
        ComplexNumber instance = new ComplexNumber(12.3,0);
        ComplexNumber z = new ComplexNumber(0,0);
        ComplexNumber result = instance.sum(z);
        assertEquals(12.3, result.getRe(), delta);
        assertEquals(0, result.getIm(), delta);
    } 
    @Test  //somma tra 2 numeri complessi entrambi con parte reale nulla
    public void testSum8() {
        ComplexNumber instance = new ComplexNumber(0,27.1);
        ComplexNumber z = new ComplexNumber(0,91.4);
        ComplexNumber result = instance.sum(z);
        assertEquals(0, result.getRe(), delta);
        assertEquals(118.5, result.getIm(), delta);
    } 
    @Test  //somma tra 2 numeri complessi di cui uno nullo e uno con parte reale nulla
    public void testSum9() {
        ComplexNumber instance = new ComplexNumber(0,27.1);
        ComplexNumber z = new ComplexNumber(0,0);
        ComplexNumber result = instance.sum(z);
        assertEquals(0, result.getRe(), delta);
        assertEquals(27.1, result.getIm(), delta);
    } 
        @Test  //somma tra 2 numeri complessi entrambi nulli
    public void testSum10() {
        ComplexNumber instance = new ComplexNumber(0,0);
        ComplexNumber z = new ComplexNumber(0,0);
        ComplexNumber result = instance.sum(z);
        assertEquals(0, result.getRe(), delta);
        assertEquals(0, result.getIm(), delta);
    } 

    /**
     * Test of sub method, of class ComplexNumber.
     */
    @Test //differenza tra 2 numeri complessi con parti reali e immaginarie non nulle
    public void testSub() {
        ComplexNumber instance = new ComplexNumber(12.3,27.1);
        ComplexNumber z = new ComplexNumber(74.4,91.4);
        ComplexNumber result = instance.sub(z);
        assertEquals(-62.1, result.getRe(), delta);
        assertEquals(-64.3, result.getIm(), delta);
    }
    @Test //differenza tra 2 numeri complessi di cui uno con parte immaginaria nulla
    public void testSub2() {
        ComplexNumber instance = new ComplexNumber(12.3,27.1);
        ComplexNumber z = new ComplexNumber(74.4,0);
        ComplexNumber result = instance.sub(z);
        assertEquals(-62.1, result.getRe(), delta);
        assertEquals(27.1, result.getIm(), delta);
    }
    @Test  //differenza tra 2 numeri complessi di cui uno con parte reale nulla
    public void testSub3() {
        ComplexNumber instance = new ComplexNumber(12.3,-27.1);
        ComplexNumber z = new ComplexNumber(0, 91.4);
        ComplexNumber result = instance.sub(z);
        assertEquals(12.3, result.getRe(), delta);
        assertEquals(-118.5, result.getIm(), delta);
    } 
    @Test  //differenza tra 2 numeri complessi di cui uno nullo
    public void testSub4() {
        ComplexNumber instance = new ComplexNumber(12.3,27.1);
        ComplexNumber z = new ComplexNumber(0,0);
        ComplexNumber result = instance.sub(z);
        assertEquals(12.3, result.getRe(), delta);
        assertEquals(27.1, result.getIm(), delta);
    } 
    @Test  //differenza tra 2 numeri complessi entrambi con parte immaginaria nulla
    public void testSub5() {
        ComplexNumber instance = new ComplexNumber(12.3,0);
        ComplexNumber z = new ComplexNumber(-74.4,0);
        ComplexNumber result = instance.sub(z);
        assertEquals(86.7, result.getRe(), delta);
        assertEquals(0, result.getIm(), delta);
    } 
    @Test  //differenza tra 2 numeri complessi di cui uno con parte immaginaria nulla e l'altro con parte reale nulla
    public void testSub6() {
        ComplexNumber instance = new ComplexNumber(-12.3,0);
        ComplexNumber z = new ComplexNumber(0,91.4);
        ComplexNumber result = instance.sub(z);
        assertEquals(-12.3, result.getRe(), delta);
        assertEquals(-91.4, result.getIm(), delta);
    } 
    @Test  //differenza tra 2 numeri complessi di cui uno nullo e uno con parte immaginaria nulla
    public void testSub7() {
        ComplexNumber instance = new ComplexNumber(12.3,0);
        ComplexNumber z = new ComplexNumber(0,0);
        ComplexNumber result = instance.sub(z);
        assertEquals(12.3, result.getRe(), delta);
        assertEquals(0, result.getIm(), delta);
    } 
    @Test  //differenza tra 2 numeri complessi entrambi con parte reale nulla
    public void testSub8() {
        ComplexNumber instance = new ComplexNumber(0,27.1);
        ComplexNumber z = new ComplexNumber(0,91.4);
        ComplexNumber result = instance.sub(z);
        assertEquals(0, result.getRe(), delta);
        assertEquals(-64.3, result.getIm(), delta);
    } 
    @Test  //differenza tra 2 numeri complessi di cui uno nullo e uno con parte reale nulla
    public void testSub9() {
        ComplexNumber instance = new ComplexNumber(0,27.1);
        ComplexNumber z = new ComplexNumber(0,0);
        ComplexNumber result = instance.sub(z);
        assertEquals(0, result.getRe(), delta);
        assertEquals(27.1, result.getIm(), delta);
    } 
    @Test  //differenza tra 2 numeri complessi entrambi nulli
    public void testSub10() {
        ComplexNumber instance = new ComplexNumber(0,0);
        ComplexNumber z = new ComplexNumber(0,0);
        ComplexNumber result = instance.sub(z);
        assertEquals(0, result.getRe(), delta);
        assertEquals(0, result.getIm(), delta);
    } 

    /**
     * Test of mol method, of class ComplexNumber.
     */
    @Test //prodotto tra 2 numeri complessi con parti reali e immaginarie non nulle
    public void testMol() {
        ComplexNumber instance = new ComplexNumber(12.3,27.1);
        ComplexNumber z = new ComplexNumber(74.4,91.4);
            ComplexNumber result = instance.mol(z);
        assertEquals(-1561.82, result.getRe(), delta);
        assertEquals(3140.46, result.getIm(), delta);
    }
    @Test //prodotto tra 2 numeri complessi di cui uno con parte immaginaria nulla
    public void testMol2() {
        ComplexNumber instance = new ComplexNumber(12.3,27.1);
        ComplexNumber z = new ComplexNumber(74.4,0);
        ComplexNumber result = instance.mol(z);
        assertEquals(915.12, result.getRe(), delta);
        assertEquals(2016.24, result.getIm(), delta);
    }
    @Test  //prodotto tra 2 numeri complessi di cui uno con parte reale nulla
    public void testMol3() {
        ComplexNumber instance = new ComplexNumber(12.3,-27.1);
        ComplexNumber z = new ComplexNumber(0, 91.4);
        ComplexNumber result = instance.mol(z);
        assertEquals(2476.940, result.getRe(), delta);
        assertEquals(1124.22, result.getIm(), delta);
    } 
    @Test  //prodotto tra 2 numeri complessi di cui uno nullo
    public void testMol4() {
        ComplexNumber instance = new ComplexNumber(12.3,27.1);
        ComplexNumber z = new ComplexNumber(0,0);
        ComplexNumber result = instance.mol(z);
        assertEquals(0, result.getRe(), delta);
        assertEquals(0, result.getIm(), delta);
    } 
    @Test  //prodotto tra 2 numeri complessi entrambi con parte immaginaria nulla
    public void testMol5() {
        ComplexNumber instance = new ComplexNumber(12.3,0);
        ComplexNumber z = new ComplexNumber(-74.4,0);
        ComplexNumber result = instance.mol(z);
        assertEquals(-915.12, result.getRe(), delta);
        assertEquals(0, result.getIm(), delta);
    } 
    @Test  //prodotto tra 2 numeri complessi di cui uno con parte immaginaria nulla e l'altro con parte reale nulla
    public void testMol6() {
        ComplexNumber instance = new ComplexNumber(-12.3,0);
        ComplexNumber z = new ComplexNumber(0,91.4);
        ComplexNumber result = instance.mol(z);
        assertEquals(0, result.getRe(), delta);
        assertEquals(-1124.22, result.getIm(), delta);
    } 
    @Test  //prodotto tra 2 numeri complessi di cui uno nullo e uno con parte immaginaria nulla
    public void testMol7() {
        ComplexNumber instance = new ComplexNumber(12.3,0);
        ComplexNumber z = new ComplexNumber(0,0);
        ComplexNumber result = instance.mol(z);
        assertEquals(0, result.getRe(), delta);
        assertEquals(0, result.getIm(), delta);
    } 
    @Test  //prodotto tra 2 numeri complessi entrambi con parte reale nulla
    public void testMol8() {
        ComplexNumber instance = new ComplexNumber(0,27.1);
        ComplexNumber z = new ComplexNumber(0,91.4);
        ComplexNumber result = instance.mol(z);
        assertEquals(-2476.94, result.getRe(), delta);
        assertEquals(0, result.getIm(), delta);
    } 
    @Test  //prodotto tra 2 numeri complessi di cui uno nullo e uno con parte reale nulla
    public void testMol9() {
        ComplexNumber instance = new ComplexNumber(0,27.1);
        ComplexNumber z = new ComplexNumber(0,0);
        ComplexNumber result = instance.mol(z);
        assertEquals(0, result.getRe(), delta);
        assertEquals(0, result.getIm(), delta);
    } 
    @Test  //prodotto tra 2 numeri complessi entrambi nulli
    public void testMol10() {
        ComplexNumber instance = new ComplexNumber(0,0);
        ComplexNumber z = new ComplexNumber(0,0);
        ComplexNumber result = instance.mol(z);
        assertEquals(0, result.getRe(), delta);
        assertEquals(0, result.getIm(), delta);
    } 
    /**
     * Test of div method, of class ComplexNumber.
     */
     @Test //divisione tra 2 numeri complessi con parti reali e immaginarie non nulle
    public void testDiv() {
        ComplexNumber instance = new ComplexNumber(12.3,27.1);
        ComplexNumber z = new ComplexNumber(74.4,91.4);
        ComplexNumber result = instance.div(z);
        assertEquals(0.244, result.getRe(), delta);
        assertEquals(0.064, result.getIm(), delta);
    }
    @Test //divisione tra 2 numeri complessi di cui uno con parte immaginaria nulla
    public void testDiv2() {
        ComplexNumber instance = new ComplexNumber(12.3,27.1);
        ComplexNumber z = new ComplexNumber(74.4,0);
        ComplexNumber result = instance.div(z);
        assertEquals(0.165, result.getRe(), delta);
        assertEquals(0.364, result.getIm(), delta);
    }
    @Test  //divisione tra 2 numeri complessi di cui uno con parte reale nulla
    public void testDiv3() {
        ComplexNumber instance = new ComplexNumber(12.3,-27.1);
        ComplexNumber z = new ComplexNumber(0, 91.4);
        ComplexNumber result = instance.div(z);
        assertEquals(-0.296, result.getRe(), delta);
        assertEquals(-0.135, result.getIm(), delta);
    } 
    @Test  //divisione tra 2 numeri complessi di cui uno nullo
    public void testDiv4() {
        ComplexNumber instance = new ComplexNumber(12.3,27.1);
        ComplexNumber z = new ComplexNumber(0,0);
        assertThrows(ArithmeticException.class, () -> {
            instance.div(z);
        });
    } 
    @Test  //divisione tra 2 numeri complessi entrambi con parte immaginaria nulla
    public void testDiv5() {
        ComplexNumber instance = new ComplexNumber(12.3,0);
        ComplexNumber z = new ComplexNumber(-74.4,0);
        ComplexNumber result = instance.div(z);
        assertEquals(-0.165, result.getRe(), delta);
        assertEquals(0, result.getIm(), delta);
    } 
    @Test  //divisione tra 2 numeri complessi di cui uno con parte immaginaria nulla e l'altro con parte reale nulla
    public void testDiv6() {
        ComplexNumber instance = new ComplexNumber(-12.3,0);
        ComplexNumber z = new ComplexNumber(0,91.4);
        ComplexNumber result = instance.div(z);
        assertEquals(0, result.getRe(), delta);
        assertEquals(0.134, result.getIm(), delta);
    } 
    @Test  //divisione tra 2 numeri complessi di cui uno nullo e uno con parte immaginaria nulla
    public void testDiv7() {
        ComplexNumber instance = new ComplexNumber(12.3,0);
        ComplexNumber z = new ComplexNumber(0,0);
        assertThrows(ArithmeticException.class, () -> {
            instance.div(z);
        });
    } 
    @Test  //divisione tra 2 numeri complessi entrambi con parte reale nulla
    public void testDiv8() {
        ComplexNumber instance = new ComplexNumber(0,27.1);
        ComplexNumber z = new ComplexNumber(0,91.4);
        ComplexNumber result = instance.div(z);
        assertEquals(0.296, result.getRe(), delta);
        assertEquals(0, result.getIm(), delta);
    } 
    @Test  //divisione tra 2 numeri complessi di cui uno nullo e uno con parte reale nulla
    public void testDiv9() {
        ComplexNumber instance = new ComplexNumber(0,27.1);
        ComplexNumber z = new ComplexNumber(0,0);
        assertThrows(ArithmeticException.class, () -> {
            instance.div(z);
        });
    } 
    @Test  //divisione tra 2 numeri complessi entrambi nulli
    public void testDiv10() {
        ComplexNumber instance = new ComplexNumber(0,0);
        ComplexNumber z = new ComplexNumber(0,0);
        assertThrows(ArithmeticException.class, () -> {
            instance.div(z);
        });
    } 
    /**
     * Test of sqrt method, of class ComplexNumber.
     */
    /**
     * Test of sqrt method, of class ComplexNumber.
     */
    @Test  //caso generale
    public void testSqrt() {
        ComplexNumber instance = new ComplexNumber(4.81,-2.63);
        ComplexNumber result1 = instance        .sqrt();
        assertEquals(2.268, result1.getRe(), delta);
        assertEquals(-0.579, result1.getIm(), delta);
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
    @Test //radice di un numero reale negativo
    public void testSqrt5() {
        ComplexNumber instance = new ComplexNumber(-9,0);
        ComplexNumber result = instance.sqrt();
        assertEquals(0, result.getRe(), delta);
        assertEquals(3, result.getIm(), delta);
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
    }
    
    @Test  //parte reale uguale a 0
    public void testInv2() {
        ComplexNumber instance = new ComplexNumber(0,49.39);
        ComplexNumber result = instance.inv();
        assertEquals(0, result.getRe(), delta);
        assertEquals(-49.39, result.getIm(), delta);
    }
    @Test  //parte immaginaria uguale a 0
    public void testInv3() {
        ComplexNumber instance = new ComplexNumber(-15.82,0);
        ComplexNumber result = instance.inv();
        assertEquals(15.82, result.getRe(), delta);
        assertEquals(0, result.getIm(), delta);
    }

    @Test  //inverso di 0
    public void testInv4() {
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
    @Test  //coniugato di 0
    public void testConj4() {
        ComplexNumber instance = new ComplexNumber(0,0);
        ComplexNumber result = instance.conj();
        assertEquals(0, result.getRe(), delta);
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
        ComplexNumber instance = new ComplexNumber(0,6.3);
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
        ComplexNumber instance = new ComplexNumber(-12.5,0);
        String result = instance.toString();
        assertEquals("-12.5", result);
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
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(4,result.getRe(), delta);
        assertEquals(5,result.getIm(), delta);
    }

    @Test //parte reale positiva e parte immaginaria positiva con numeri decimali
    public void testParseB() throws SyntaxException{
        String instance = "2.4+34.12j";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(2.4,result.getRe(), delta);
        assertEquals(34.12,result.getIm(), delta);
    }

    @Test //parte reale positiva con segno e parte immaginaria positiva
    public void testParse2() throws SyntaxException{
        String instance = "+4+5j";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(4,result.getRe(), delta);
        assertEquals(5,result.getIm(), delta);
    }

    @Test //parte reale positiva con segno e parte immaginaria positiva con numeri decimali
    public void testParse2B() throws SyntaxException{
        String instance = "+2.4+34.12j";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(2.4,result.getRe(), delta);
        assertEquals(34.12,result.getIm(), delta);
    }

    @Test //parte reale positiva e parte immaginaria negativa
    public void testParse3() throws SyntaxException{
        String instance = "4-5j";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(4,result.getRe(), delta);
        assertEquals(-5,result.getIm(), delta);
    }

    @Test //parte reale positiva e parte immaginaria negativa con numeri decimali
    public void testParse3B() throws SyntaxException{
        String instance = "2.4-34.12j";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(2.4,result.getRe(), delta);
        assertEquals(-34.12,result.getIm(), delta);
    }

    @Test //parte reale positiva con segno e parte immaginaria negativa
    public void testParse4() throws SyntaxException{
        String instance = "+4-5j";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(4,result.getRe(), delta);
        assertEquals(-5,result.getIm(), delta);
    }

    @Test //parte reale positiva con segno e parte immaginaria negativa con numero decimale
    public void testParse4B() throws SyntaxException{
        String instance = "+2.4-34.12j";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(2.4,result.getRe(), delta);
        assertEquals(-34.12,result.getIm(), delta);
    }

    @Test //parte reale negativa e parte immaginaria positiva
    public void testParse5() throws SyntaxException{
        String instance = "-4+5j";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(-4,result.getRe(), delta);
        assertEquals(5,result.getIm(), delta);
    }

    @Test //parte reale negativa e parte immaginaria positiva con numero decimale
    public void testParse5B() throws SyntaxException{
        String instance = "-2.4+34.12j";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(-2.4,result.getRe(), delta);
        assertEquals(34.12,result.getIm(), delta);
    }

    @Test //parte reale negativa e parte immaginaria negativa
    public void testParse6() throws SyntaxException{
        String instance = "-4-5j";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(-4,result.getRe(), delta);
        assertEquals(-5,result.getIm(), delta);
    }

    @Test //parte reale negativa e parte immaginaria negativa con numero decimale
    public void testParse6B() throws SyntaxException{
        String instance = "-2.4-34.12j";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(-2.4,result.getRe(), delta);
        assertEquals(-34.12,result.getIm(), delta);
    }

    @Test //parte reale positiva e parte immaginaria nulla
    public void testParse7() throws SyntaxException{
        String instance = "4";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(4,result.getRe(), delta);
        assertEquals(0,result.getIm(), delta);
    }

    @Test //parte reale positiva e parte immaginaria nulla con numero decimale
    public void testParse7B() throws SyntaxException{
        String instance = "4.537";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(4.537,result.getRe(), delta);
        assertEquals(0,result.getIm(), delta);
    }

    @Test //parte reale positiva con segno e parte immaginaria nulla
    public void testParse8() throws SyntaxException{
        String instance = "+4";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(4,result.getRe(), delta);
        assertEquals(0,result.getIm(), delta);
    }

    @Test //parte reale positiva con segno e parte immaginaria nulla con numero decimale
    public void testParse8B() throws SyntaxException{
        String instance = "+4.537";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(4.537,result.getRe(), delta);
        assertEquals(0,result.getIm(), delta);
    }

    @Test //parte reale negativa e parte immaginaria nulla
    public void testParse9() throws SyntaxException{
        String instance = "-4";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(-4,result.getRe(), delta);
        assertEquals(0,result.getIm(), delta);
    }

    @Test //parte reale negativa e parte immaginaria nulla con numero decimale
    public void testParse9B() throws SyntaxException{
        String instance = "-4.537";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(-4.537,result.getRe(), delta);
        assertEquals(0,result.getIm(), delta);
    }

    @Test //parte reale nulla e parte immaginaria positiva
    public void testParse10() throws SyntaxException{
        String instance = "5j";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(0,result.getRe(), delta);
        assertEquals(5,result.getIm(), delta);
    }

    @Test //parte reale nulla e parte immaginaria positiva con numero decimale
    public void testParse10B() throws SyntaxException{
        String instance = "5.85j";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(0,result.getRe(), delta);
        assertEquals(5.85,result.getIm(), delta);
    }

    @Test //parte reale nulla e parte immaginaria positiva con j posta prima
    public void testParse11() throws SyntaxException{
        String instance = "j5";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(0,result.getRe(), delta);
        assertEquals(5,result.getIm(), delta);
    }

    @Test //parte reale nulla e parte immaginaria positiva con j posta prima e numero decimale
    public void testParse11B() throws SyntaxException{
        String instance = "j5.85";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(0,result.getRe(), delta);
        assertEquals(5.85,result.getIm(), delta);
    }

    @Test //parte reale nulla e parte immaginaria positiva con segno
    public void testParse12() throws SyntaxException{
        String instance = "+5j";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(0,result.getRe(), delta);
        assertEquals(5,result.getIm(), delta);
    }

    @Test //parte reale nulla e parte immaginaria positiva con segno e numero decimale
    public void testParse12B() throws SyntaxException{
        String instance = "+5.85j";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(0,result.getRe(), delta);
        assertEquals(5.85,result.getIm(), delta);
    }

    @Test //parte reale nulla e parte immaginaria positiva con segno j posta prima
    public void testParse13() throws SyntaxException{
        String instance = "+j5";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(0,result.getRe(), delta);
        assertEquals(5,result.getIm(), delta);
    }

    @Test //parte reale nulla e parte immaginaria positiva con segno j posta prima e numero decimale
    public void testParse13B() throws SyntaxException{
        String instance = "+j5.85";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(0,result.getRe(), delta);
        assertEquals(5.85,result.getIm(), delta);
    }

    @Test //parte reale nulla e parte immaginaria negativa
    public void testParse14() throws SyntaxException{
        String instance = "-5j";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(0,result.getRe(), delta);
        assertEquals(-5,result.getIm(), delta);
    }

    @Test //parte reale nulla e parte immaginaria negativa con numero decimale
    public void testParse14B() throws SyntaxException{
        String instance = "-5.85j";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(0,result.getRe(), delta);
        assertEquals(-5.85,result.getIm(), delta);
    }

    @Test //parte reale nulla e parte immaginaria negativa con j posta prima
    public void testParse15() throws SyntaxException{
        String instance = "-j5";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(0,result.getRe(), delta);
        assertEquals(-5,result.getIm(), delta);
    }

    @Test //parte reale nulla e parte immaginaria negativa con j posta prima e numero decimale
    public void testParse15B() throws SyntaxException{
        String instance = "-j5.85";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(0,result.getRe(), delta);
        assertEquals(-5.85,result.getIm(), delta);
    }
    
    @Test //parte immaginaria nulla con segno -
    public void testParse16() throws SyntaxException{
        String instance = "27.25-0j";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(27.25,result.getRe(), delta);
        assertEquals(0,result.getIm(), delta);
    }

    @Test //parte reale nulla con segno -
    public void testParse17() throws SyntaxException{
        String instance = "-0-84.346j";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(0,result.getRe(), delta);
        assertEquals(-84.346,result.getIm(), delta);
    }

    @Test //parte reale nulla con segno - e parte immaginaria nulla con segno -
    public void testParse18() throws SyntaxException{
        String instance = "-0-0j";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(0,result.getRe(), delta);
        assertEquals(0,result.getIm(), delta);
    }
    
    @Test //parte reale nulla con segno - e parte immaginaria nulla omessa
    public void testParse19() throws SyntaxException{
        String instance = "-0";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(0,result.getRe(), delta);
        assertEquals(0,result.getIm(), delta);
    }

    @Test //parte reale nulla omessa e parte immaginaria nulla con segno -
    public void testParse20() throws SyntaxException{
        String instance = "-0j";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(0,result.getRe(), delta);
        assertEquals(0,result.getIm(), delta);
    }
    
    @Test //delimitatore non preceduto da numero
    public void testParse21() throws SyntaxException{
        String instance = ".5";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parse(instance);
        });
    }

    @Test //delimitatore non seguito da numero
    public void testParse21B() throws SyntaxException{
        String instance = "6.";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parse(instance);
        });
    }
   
    @Test //solo unità immaginaria
    public void testParse22() throws SyntaxException{
        String instance = "j";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parse(instance);
        });
    }

    @Test //solo unità immaginaria
    public void testParse22B() throws SyntaxException{
        String instance = "+j";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parse(instance);
        });
    }

    @Test //solo unità immaginaria
    public void testParse22C() throws SyntaxException{
        String instance = "-j";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parse(instance);
        });
    }

    @Test //parte reale e solo unità immaginaria
    public void testParse23() throws SyntaxException{
        String instance = "4+j";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parse(instance);
        });
    }

    @Test //unità immaginaria fuori posto
    public void testParse24() throws SyntaxException{
        String instance = "-4+5j3";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parse(instance);
        });
    }

    @Test //più di un segno nella parte immaginaria
    public void testParse25() throws SyntaxException{
        String instance = "-4+-53j";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parse(instance);
        });
    }

    @Test //più di un segno nella parte reale
    public void testParse26() throws SyntaxException{
        String instance = "-+14.1+9.3j";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parse(instance);
        });
    }

    @Test //più di un segno nella parte reale e nella parte immaginaria
    public void testParse27() throws SyntaxException{
        String instance = "-+14.1++9.3j";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parse(instance);
        });
    }

    @Test //più di un segno nella parte reale con parte immaginaria omessa
    public void testParse28() throws SyntaxException{
        String instance = "++-23.34";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parse(instance);
        });
    }

    @Test //più di un segno nella parte immmaginaria con parte reale omessa
    public void testParse29() throws SyntaxException{
        String instance = "++-23.34j";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parse(instance);
        });
    }

    @Test //più di un punto nella parte immaginaria
    public void testParse30() throws SyntaxException{
        String instance = "8.24+368..1j";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parse(instance);
        });
    }

    @Test //più di un punto nella parte reale
    public void testParse31() throws SyntaxException{
        String instance = "8..24+368.1j";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parse(instance);
        });
    }

    @Test //più di un punto nella parte reale e nella parte immaginaria
    public void testParse32() throws SyntaxException{
        String instance = "8..2.4+36.8..1j";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parse(instance);
        });
    }

    @Test //più di un punto nella parte reale con parte immaginaria omessa
    public void testParse33() throws SyntaxException{
        String instance = "35..93";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parse(instance);
        });
    }

    @Test //più di un punto nella parte immmaginaria con parte reale omessa
    public void testParse34() throws SyntaxException{
        String instance = "35..93j";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parse(instance);
        });
    }

    @Test //unità immaginaria ripetuta
    public void testParse35() throws SyntaxException{
        String instance = "457.12-j34j8.61j";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parse(instance);
        });
    }

    @Test //unità immaginaria ripetuta con parte reale omessa
    public void testParse36() throws SyntaxException{
        String instance = "16j.8j";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parse(instance);
        });
    }
    
    @Test //stringa vuota
    public void testParse37() throws SyntaxException{
        String instance = "";
        assertThrows(SyntaxException.class, () -> {
            ComplexNumber.parse(instance);
        });
    }
    
    @Test 
    public void testParse38() throws SyntaxException{
        String instance = "4+j5";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(4,result.getRe());
        assertEquals(5,result.getIm());
    }

    @Test 
    public void testParse38B() throws SyntaxException{
        String instance = "4.3+j5.6";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(4.3,result.getRe());
        assertEquals(5.6,result.getIm());
    }

    @Test 
    public void testParse39() throws SyntaxException{
        String instance = "4-j5";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(4,result.getRe());
        assertEquals(-5,result.getIm());
    }

    @Test 
    public void testParse39B() throws SyntaxException{
        String instance = "4.3-j5.6";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(4.3,result.getRe());
        assertEquals(-5.6,result.getIm());
    }

    @Test 
    public void testParse40() throws SyntaxException{
        String instance = "+4+j5";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(4,result.getRe());
        assertEquals(5,result.getIm());
    }

    @Test 
    public void testParse40B() throws SyntaxException{
        String instance = "+4.3+j5.6";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(4.3,result.getRe());
        assertEquals(5.6,result.getIm());
    }

    @Test 
    public void testParse41() throws SyntaxException{
        String instance = "+4-j5";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(4,result.getRe());
        assertEquals(-5,result.getIm());
    }

    @Test 
    public void testParse41B() throws SyntaxException{
        String instance = "+4.3-j5.6";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(4.3,result.getRe());
        assertEquals(-5.6,result.getIm());
    }

    @Test 
    public void testParse42() throws SyntaxException{
        String instance = "-4+j5";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(-4,result.getRe());
        assertEquals(5,result.getIm());
    }

    @Test 
    public void testParse42B() throws SyntaxException{
        String instance = "-4.3+j5.6";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(-4.3,result.getRe());
        assertEquals(5.6,result.getIm());
    }

    @Test 
    public void testParse43() throws SyntaxException{
        String instance = "-4-j5";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(-4,result.getRe());
        assertEquals(-5,result.getIm());
    }

    @Test 
    public void testParse43B() throws SyntaxException{
        String instance = "-4.3-j5.6";
        ComplexNumber result = ComplexNumber.parse(instance);
        assertEquals(-4.3,result.getRe());
        assertEquals(-5.6,result.getIm());
    }
}
