import org.testng.annotations.Test;

public class WaitsTest extends BaseTest{
    @Test
    public void presenceOfElementsTest(){
        driver.get("https://the-internet.herokuapp.com/context_menu");

    }
}
