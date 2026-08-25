package pagesDemPract;

import java.net.http.WebSocket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;      
    }
    public void fillDetials(String mail, String pass){
      WebElement loginbutton=driver.findElement(By.xpath("//a[@class='ico-login']"));
      loginbutton.click();
      WebElement enterEmail=driver.findElement(By.id("Email"));
      enterEmail.sendKeys(mail);
      WebElement enterPass=driver.findElement(By.id("Password"));
      enterPass.sendKeys(pass);
      driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();

    }
    
}
