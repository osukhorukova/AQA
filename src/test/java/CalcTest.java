import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CalcTest extends BaseTest {

    @Test(testName = "Positive test of dividing two numbers (int/int)", dataProvider = "dataForDivPosInt",
            dataProviderClass = StaticProvider.class, threadPoolSize = 3)
    public void divIntPosTest(int a, int b, double expectedResult) {
        Assert.assertEquals(calculator.div(a, b), expectedResult, "Wrong result of dividing two numbers (int)");
    }

    @Test(testName = "Negative test of dividing by zero (int/0)",
            expectedExceptions = ArithmeticException.class, dataProvider = "dataForDivNegInt",
            dataProviderClass = StaticProvider.class, threadPoolSize = 3)
    public void divIntNegTest(int a, int b, double expectedResult) {
        Assert.assertEquals(calculator.div(a, b), expectedResult, "Dividing by zero is nor allowed");
    }

    @Test(testName = "Positive test of dividing two numbers (double/double)", dataProvider = "dataForDivPosDouble",
            dataProviderClass = StaticProvider.class, threadPoolSize = 3)
    public void divDoublePosTest(double a, double b, double expectedResult) {
        Assert.assertEquals(calculator.div(a, b), expectedResult, "Wrong result of dividing two numbers (double)");
    }

    @Test(testName = "Negative test of dividing by zero (double/0)", dataProvider = "dataForDivNegDouble",
            dataProviderClass = StaticProvider.class, threadPoolSize = 3)
    public void divDoubleNegTest(double a, double b, double expectedResult) {
        Assert.assertEquals(calculator.div(a, b), expectedResult, "Dividing by zero is nor allowed");
    }

    @Test(testName = "Positive test of dividing two numbers (int/double)", dataProvider = "dataForDivPosIntByDouble",
            dataProviderClass = StaticProvider.class, threadPoolSize = 3)
    public void divIntByDoublePosTest(int a, double b, double expectedResult) {
        Assert.assertEquals(calculator.div(a, b), expectedResult, "Wrong result of dividing two numbers (int/double)");
    }

    @Test(testName = "Positive test of dividing two numbers (double/int)", dataProvider = "dataForDivPosDoubleByInt",
            dataProviderClass = StaticProvider.class, threadPoolSize = 3)
    public void divDoubleByIntPosTest(double a, int b, double expectedResult) {
        Assert.assertEquals(calculator.div(a, b), expectedResult, "Wrong result of dividing two numbers (double/int)");
    }

}
