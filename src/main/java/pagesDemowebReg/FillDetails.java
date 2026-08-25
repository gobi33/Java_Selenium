package pagesDemowebReg;
import org.testng.*;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.*;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class FillDetails {
    WebDriver driver;
    WebDriverWait wait;
    public FillDetails(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public void fillform(String first_name,String last_name,String email ){
        WebElement checkbox=driver.findElement(By.xpath("//input[@id='gender-male']"));
        checkbox.click();
        WebElement firstname=driver.findElement(By.xpath("//input[@class='text-box single-line' and @id='FirstName']"));
        firstname.sendKeys(first_name);
        WebElement lastname=driver.findElement(By.xpath("//input[@class='text-box single-line' and @id='LastName']"));
        lastname.sendKeys(last_name);
        WebElement emailid=driver.findElement(By.xpath("//input[@class='text-box single-line' and @id='Email']"));
        emailid.sendKeys(email);
    }
    public void passwrd(String pass,String confpass){
        WebElement pass_wrd=driver.findElement(By.xpath("//input[@class='text-box single-line password' and @id='Password']"));
        pass_wrd.sendKeys(pass);
        WebElement conf_pass_wrd=driver.findElement(By.xpath("//input[@class='text-box single-line password' and @id='ConfirmPassword']"));
        conf_pass_wrd.sendKeys(confpass);       

        WebElement clickbtn=driver.findElement(By.xpath("//input[@id='register-button']"));
        clickbtn.click();    
    
    if(!pass.equals(confpass)){
        WebElement mis_match=wait.until(ExpectedConditions.
            visibilityOfElementLocated(By.xpath("//span[@class='field-validation-error']/span[@for='ConfirmPassword']")));
            String Mis_Match_Test=mis_match.getText();
            System.out.println(Mis_Match_Test);     
       }
        Assert.assertEquals(pass, confpass,"Both pass are not same");
         System.out.println("Password Validation completed");
 
        String Expected = "";
        String Actual="Your registration completed";
        try{
        WebElement reg_txt=driver.findElement(By.xpath("//div[@class='result']"));
        Expected= reg_txt.getText();
        System.out.println("The Registration completed : "+Expected);
        
        WebElement click_cnt=driver.findElement(By.xpath("//input[@class='button-1 register-continue-button']"));
        click_cnt.click();

        System.out.println("REGISTRATION COMPLETED");

        }catch(Exception e){

            WebElement mail_exists=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='validation-summary-errors']/ul/li")));
            
            String AlreadyExists = mail_exists.getText();
            System.out.println("The Email Already exists ");
            
        }
    }

    public String dynamicdate(){
        WebElement mid=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='header-links']/ul/li//a[@class='account' and contains(text(), '@gmail.com')]")));
        
       //WebElement MailID= driver.findElement(By.xpath("//div[@class='header-links']/ul/li//a[@class='account' and contains(text(), '@gmail.com')]"));

       String Mail=mid.getText();
       System.out.println(Mail+" -> Obtained mail ID");
       return Mail;
    }
    
}
