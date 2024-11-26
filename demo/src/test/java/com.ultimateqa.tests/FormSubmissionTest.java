import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FormSubmissionTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/inputs");
    }

    @Test
    public void testFormSubmission() {
        WebElement inputBox = driver.findElement(By.cssSelector("input[type='number']"));
        inputBox.sendKeys("12345");

        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
        submitButton.click();

        Assert.assertTrue(driver.getPageSource().contains("Successfully submitted"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
