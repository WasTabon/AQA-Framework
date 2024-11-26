import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MobileLoginTest {
    private AppiumDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("app", "path/to/app.apk");

        driver = new AndroidDriver<>(caps);
    }

    @Test
    public void testLogin() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login"));

        usernameField.sendKeys("tomsmith");
        passwordField.sendKeys("SuperSecretPassword!");
        loginButton.click();

        WebElement homePage = driver.findElement(By.id("homePage"));
        Assert.assertTrue(homePage.isDisplayed());
    }

    @Test
    public void testDropdown() {
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        dropdown.click();
        WebElement option1 = driver.findElement(By.xpath("//option[@value='1']"));
        option1.click();
    
        // Verify that the selection was made
        Assert.assertEquals(option1.getText(), "Option 1");
    }

    @Test
    public void testFileUpload() {
        WebElement fileInput = driver.findElement(By.id("file-upload"));
        fileInput.sendKeys("/path/to/file");
    
        WebElement uploadButton = driver.findElement(By.id("upload-button"));
        uploadButton.click();
    
        WebElement successMessage = driver.findElement(By.id("upload-success"));
        Assert.assertTrue(successMessage.isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
