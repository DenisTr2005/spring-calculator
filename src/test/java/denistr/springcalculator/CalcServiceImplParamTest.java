package denistr.springcalculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class CalcServiceImplParamTest {
    private final CalcService out = new CalcServiceImpl();
    static int a1, b1, a2, b2;
    @BeforeAll
    static void setUp() {
        a1 = 5;
        b1 = 3;
        a2 = -5;
        b2 = -3;
    }
    public static Stream<Arguments> provideParamsForTest() {
        return Stream.of(
                Arguments.of(a1,b1),
                Arguments.of(a2,b2),
                Arguments.of(a1,b2),
                Arguments.of(a2,b1)
        );
    }
    @ParameterizedTest
    @MethodSource("provideParamsForTest")
    void mustReturnSum(int a, int b) {
        assertEquals(a+b, out.calcPlus(a,b));
    }
    @ParameterizedTest
    @MethodSource("provideParamsForTest")
    void mustReturnDiff(int a, int b) {
        assertEquals(a-b, out.calcMinus(a,b));
    }
    @ParameterizedTest
    @MethodSource("provideParamsForTest")
    void mustReturnMultiply(int a, int b) {
        assertEquals(a*b, out.calcMultiply(a,b));
    }
    @ParameterizedTest
    @MethodSource("provideParamsForTest")
    void mustReturnDivide(int a, int b) {
        assertEquals(a/b, out.calcDivide(a,b));
    }
}