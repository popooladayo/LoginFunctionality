package LoginFunctionality;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InvalidLoginTest {
    WebDriver driver;
    HomePage homePage;

    @BeforeMethod
    public void setup() {
        // Using ChromeDriver directly
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        homePage = new HomePage(driver);
        homePage.visitHomepage();
    }

    @Test
    public void testInvalidLogin() throws InterruptedException {
        Thread.sleep(5000);
        homePage.setUsername("invalidUsername");
        homePage.setPassword("admin321");
        homePage.clickLogin();
//        Assert.assertTrue(homePage.verifyErrorMessage(), "Error message not displayed");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
