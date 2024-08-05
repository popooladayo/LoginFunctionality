package LoginFunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
//    By usernameField = By.xpath("//input[@placeholder='Username']");
    By passwordField = By.xpath("//input[@placeholder='Password']");

    By loginBtn = By.xpath("//button[@type='submit']");
    By labelMsg = By.cssSelector(".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");
    By errorMessage = By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");

    public void visitHomepage() {
        driver.get(url);
    }

    public void setUsername(String username) {

        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement( By.xpath("//input[@placeholder='Password']")).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement( By.xpath("//button[@type='submit']")).click();
    }

    public boolean verifyLogin() {
        return driver.findElement(labelMsg).getText().equals("Dashboard");
    }

    public boolean verifyErrorMessage() {
        return driver.findElement(errorMessage).getText().contains("Invalid credentials");
    }
}
