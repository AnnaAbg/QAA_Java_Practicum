import io.qameta.allure.*;
import org.example.Writter;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Writter Module")
@Feature("Text Retrieval")
public class WritterTest {

    @Severity(SeverityLevel.CRITICAL)
    @Story("Ensure getText method returns correct text")
    @Step("Executing test for getText method")
    @Test(description = "Test the getText method")
    public void testGetText(){
        Assert.assertEquals(Writter.getText(),"Hello World!");
    }
}
