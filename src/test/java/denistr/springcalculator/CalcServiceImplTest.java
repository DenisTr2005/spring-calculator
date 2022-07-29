package denistr.springcalculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalcServiceImplTest {
    private final CalcService out = new CalcServiceImpl();
    private final String HELLO = "Добро пожаловать в калькулятор";
    private static int a1, b1, a2, b2;
    @BeforeAll
    static void setUp() {
        a1 = 5;
        b1 = 3;
        a2 = -5;
        b2 = -3;
    }
    @Test
    public void mustReturnHelloMessage() {
        assertEquals(HELLO,out.helloCalc());
    }
    @Test
    public void mustReturnSum() {
        assertEquals(8, out.calcPlus(a1,b1));
        assertEquals(-8, out.calcPlus(a2,b2));
    }
    @Test
    public void mustReturnDiff() {
        assertEquals(2, out.calcMinus(a1,b1));
        assertEquals(-2, out.calcMinus(a2,b2));
    }
    @Test
    public void mustReturnMultiply() {
        assertEquals(15, out.calcMultiply(a1,b1));
        assertEquals(15, out.calcMultiply(a2,b2));
    }
    @Test
    public void mustReturnDivide() {
        assertEquals(1, out.calcDivide(a1,b1));
        assertEquals(1, out.calcDivide(a2,b2));
    }
    @Test
    public void mustThrowsWithZero() {
        assertThrows(IllegalArgumentException.class, () -> out.calcDivide(1, 0));
    }
}