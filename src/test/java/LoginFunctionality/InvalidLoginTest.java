package LoginFunctionality;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class InvalidLoginTest {
    WebDriver driver;
    HomePage homePage;  // Fixed the class name from "Homepage" to "HomePage"

    @BeforeMethod
    public void setup() {
        // Using ChromeDriver with ChromeOptions
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // Initialize the HomePage object
        homePage = new HomePage(driver);
        homePage.visitHomepage();
    }

    @Test
    public void testInvalidLogin() {
        // Set an invalid username and password, then click login
        homePage.setUsername("invalidUsername");
        homePage.setPassword("admin321");
        homePage.clickLogin();

        // Assert that the error message is displayed
        Assert.assertTrue(homePage.verifyErrorMessage(), "Error message not displayed");
        System.out.println("Test Passed....!");
    }

    @AfterMethod
    public void tearDown() {
        // Quit the driver after the test is done
        if (driver != null) {
            driver.quit();
        }
    }
}
