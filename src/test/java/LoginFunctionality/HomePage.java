package LoginFunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    // Constructor for initializing the WebDriver and PageFactory
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Page elements
    String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    By usernameField = By.xpath("//input[@placeholder='Username']");
    By passwordField = By.xpath("//input[@placeholder='Password']");
    By loginBtn = By.xpath("//button[@type='submit']");
    By labelMsg = By.cssSelector(".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");
    By errorMessage = By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");

    // Navigate to the homepage
    public void visitHomepage() {
        driver.get(url);
    }

    // Set the username in the login form
    public void setUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    // Set the password in the login form
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    // Click the login button
    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    // Verify successful login by checking if the dashboard is displayed
    public boolean verifyLogin() {
        return driver.findElement(labelMsg).getText().equals("Dashboard");
    }

    // Verify if an error message is displayed for invalid credentials
    public boolean verifyErrorMessage() {
        return driver.findElement(errorMessage).getText().contains("Invalid credentials");
    }
}
