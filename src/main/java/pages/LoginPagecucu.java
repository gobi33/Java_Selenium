// package pages;

// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;

// public class LoginPagecucu {

//     WebDriver driver;

//     public LoginPagecucu(WebDriver driver) {

//         this.driver = driver;
//     }

//     public void enterCredentials() {

//         driver.findElement(By.id("Email"))
//               .sendKeys("DemoWebsite@gmail.com");

//         driver.findElement(By.id("Password"))
//               .sendKeys("Website@123");
//     }

//     public void clickLogin() {

//         driver.findElement(
//                 By.xpath("//input[@value='Log in']"))
//                 .click();
//     }
// }


package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPagecucu {

    WebDriver driver;

    public LoginPagecucu(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By loginLink = By.className("ico-login");
    By email = By.id("Email");
    By password = By.id("Password");
    By loginButton = By.xpath("//input[@class='button-1 login-button']");

    // Actions
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    public void enterEmail(String mail) {
        driver.findElement(email).sendKeys(mail);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}