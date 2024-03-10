import org.testng.annotations.*;

@Listeners(Listener.class)
public class BaseTest {
    protected Calculator calculator;

    @BeforeSuite
    public void beforeSuite() {
        calculator = new Calculator();
        System.out.println("Initiating the calculator");
    }

    @BeforeGroups (groups = {"positive", "negative"})
    public void methodBeforeGeneral() {
        calculator = new Calculator();
    }
}

