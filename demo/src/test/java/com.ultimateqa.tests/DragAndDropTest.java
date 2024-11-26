import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DragAndDropTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
    }

    @Test
    public void testDragAndDrop() {
        WebElement dragElement = driver.findElement(By.id("column-a"));
        WebElement dropElement = driver.findElement(By.id("column-b"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragElement, dropElement).perform();
        
        String resultText = dropElement.getText();
        Assert.assertEquals(resultText, "A");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
