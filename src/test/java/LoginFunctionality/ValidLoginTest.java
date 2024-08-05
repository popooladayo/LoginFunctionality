package LoginFunctionality;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ValidLoginTest {
    WebDriver driver;
    HomePage homePage;

    @BeforeMethod
    public void setup() {
  
//        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        homePage.visitHomepage();
    }

    @Test
    public void testValidLogin() {
        homePage.setUsername("Admin");
        homePage.setPassword("admin123");
        homePage.clickLogin();
        Assert.assertTrue(homePage.verifyLogin(), "Login failed");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
