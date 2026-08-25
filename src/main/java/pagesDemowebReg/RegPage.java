package pagesDemowebReg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegPage {
    WebDriver driver;
    public RegPage(WebDriver driver){
        this.driver=driver;
    }
    public void goto_regpage(){
        driver.findElement(By.xpath("//div[@class='header-links']/ul/li/a[@href='/register']")).click();
        
    }
    
}
