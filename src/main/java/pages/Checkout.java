package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Checkout {
    WebDriver driver;
    WebDriverWait wait;

    public Checkout(WebDriver driver) {
        this.driver = driver;
    }

    // locators
    By checkbox = By.id("termsofservice");
    By clickbutton = By.id("checkout");

    // actions
    public void agreeterms() {
       boolean ans= driver.findElement(checkbox).isSelected();
       System.out.println("The check box is : "+ans);

       if(ans==false){
        driver.findElement(checkbox).click();
    }
    }

    public void clickcheckout() {
        driver.findElement(clickbutton).click();
    }
}













