package denistr.springcalculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class CalcServiceImplParamTest {
    private final CalcServiceImpl out = new CalcServiceImpl();
    static int a1, b1, a2, b2;
    @BeforeAll
    static void setUp() {
        a1 = 5;
        b1 = 3;
        a2 = -5;
        b2 = -3;
    }
    public static Stream<Arguments> provideParamsForDivideTest() {
        return Stream.of(
                Arguments.of(a1,b1,1),
                Arguments.of(a2,b2,1),
                Arguments.of(a1,b2,-1),
                Arguments.of(a2,b1,-1)
        );
    }
    public static Stream<Arguments> provideParamsForMultiplyTest() {
        return Stream.of(
                Arguments.of(a1,b1,15),
                Arguments.of(a2,b2,15),
                Arguments.of(a1,b2,-15),
                Arguments.of(a2,b1,-15)
        );
    }
    public static Stream<Arguments> provideParamsForPlusTest() {
        return Stream.of(
                Arguments.of(a1,b1,8),
                Arguments.of(a2,b2,-8),
                Arguments.of(a1,b2,2),
                Arguments.of(a2,b1,-2)
        );
    }
    public static Stream<Arguments> provideParamsForMinusTest() {
        return Stream.of(
                Arguments.of(a1,b1,2),
                Arguments.of(a2,b2,-2),
                Arguments.of(a1,b2,8),
                Arguments.of(a2,b1,-8)
        );
    }
    @ParameterizedTest
    @MethodSource("provideParamsForPlusTest")
    void mustReturnSum(int a, int b, int expected) {
        assertEquals(expected, out.calcPlus(a,b));
    }
    @ParameterizedTest
    @MethodSource("provideParamsForMinusTest")
    void mustReturnDiff(int a, int b, int expected) {
        assertEquals(expected, out.calcMinus(a,b));
    }
    @ParameterizedTest
    @MethodSource("provideParamsForMultiplyTest")
    void mustReturnMultiply(int a, int b, int expected) {
        assertEquals(expected, out.calcMultiply(a,b));
    }
    @ParameterizedTest
    @MethodSource("provideParamsForDivideTest")
    void mustReturnDivide(int a, int b, int expected) {
        assertEquals(expected, out.calcDivide(a,b));
    }
}