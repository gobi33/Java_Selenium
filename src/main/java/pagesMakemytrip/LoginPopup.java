package pagesMakemytrip;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPopup {
    WebDriver driver;
    WebDriverWait wait;
    public LoginPopup(WebDriver driver){
        this.driver=driver;
    }
    public void accept(){
        try{

      WebElement closeclick=  driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(closeclick));
        closeclick.click();

        System.out.println("Popup closed");
        }catch(Exception e){
            System.out.println("No pop present");
        }

    }
    
}
