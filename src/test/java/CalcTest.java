import com.sun.net.httpserver.Authenticator;
import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import org.testng.annotations.Optional;


public class CalcTest extends BaseTest {

    @Test(testName = "Positive test of dividing two numbers (int/int)", description = "This is the description that you " +
            "will see in the report", dataProvider = "dataForDivPosInt", dataProviderClass = StaticProvider.class,
            threadPoolSize = 3, groups = "positive", timeOut = 500, priority = 1)
    public void divIntPosTest(int a, int b, double expectedResult) {
        Assert.assertEquals(calculator.div(a, b), expectedResult, "Wrong result of dividing two numbers (int)");
    }
    @Test(testName = "Negative test of dividing by zero (int/0)",
            expectedExceptions = ArithmeticException.class, dataProvider = "dataForDivNegInt",
            dataProviderClass = StaticProvider.class, threadPoolSize = 3, groups = "negative",
            invocationCount = 2, invocationTimeOut = 1000, dependsOnMethods = "divIntPosTest")
    public void divIntNegTest(int a, int b, double expectedResult) {
        Assert.assertEquals(calculator.div(a, b), expectedResult, "Dividing by zero is nor allowed");
    }

    @Test(testName = "Positive test of dividing two numbers (double/double)", dataProvider = "dataForDivPosDouble",
            dataProviderClass = StaticProvider.class, groups = "positive",
            invocationCount = 2, threadPoolSize = 2)
    public void divDoublePosTest(double a, double b, double expectedResult) {
        Assert.assertEquals(calculator.div(a, b), expectedResult, "Wrong result of dividing two numbers (double)");
    }

    @Test(testName = "Negative test of dividing by zero (double/0)", dataProvider = "dataForDivNegDouble",
            dataProviderClass = StaticProvider.class, threadPoolSize = 3, groups = "negative", dependsOnMethods =
            "divDoublePosTest")
    public void divDoubleNegTest(double a, double b, double expectedResult) {
        Assert.assertEquals(calculator.div(a, b), expectedResult, "Dividing by zero is nor allowed");
    }

    @Test(testName = "Positive test of dividing two numbers (int/double)", dataProvider = "dataForDivPosIntByDouble",
            dataProviderClass = StaticProvider.class, groups = "positive", enabled = false)
    public void divIntByDoublePosTest(int a, double b, double expectedResult) {
        Assert.assertEquals(calculator.div(a, b), expectedResult, "Wrong result of dividing two numbers (int/double)");
    }

    @Test(testName = "Positive test of dividing two numbers (double/int)", dataProvider = "dataForDivPosDoubleByInt",
            dataProviderClass = StaticProvider.class, threadPoolSize = 3, groups = "positive")
    public void divDoubleByIntPosTest(double a, int b, double expectedResult) {
        Assert.assertEquals(calculator.div(a, b), expectedResult, "Wrong result of dividing two numbers (double/int)");
    }
    @Parameters({"dividend", "divisor", "expected-result"})
    @Test(testName = "Parameters use (int/int)")
    public void divIntPosParamTest(@Optional("20") int dividend, @Optional("2") int divisor, @Optional("10.0") double expectedResult) {
        Assert.assertEquals(calculator.div(dividend, divisor), expectedResult);

    }

    @Test(testName = "retryAnalyzer", retryAnalyzer = Retry.class)
    public void retryTest() {
        Assert.assertEquals(calculator.div(100, 5), 25);
    }

}
