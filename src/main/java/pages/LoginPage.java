//gobinath changes 

package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

import utils.WaitUtil;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    String parent;
    public LoginPage(WebDriver driver) {

        this.driver = driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public void enterCredentials() {
          WaitUtil.WebForElement(driver, By.id("Email")).sendKeys("DemoWebsite@gmail.com");
        WaitUtil.WebForElement(driver, By.id("Password")).sendKeys("Website@123");
    }
    public void clickLogin() {
        WaitUtil.WebForElement(driver, By.xpath("//input[@value='Log in']")).click();
    }
    public void InvalidCredentials(){
        WaitUtil.WebForElement(driver, By.id("Email")).sendKeys("DemoWebsite0@gmail.com");
        WaitUtil.WebForElement(driver, By.id("Password")).sendKeys("Website@1234");    
    }
    public void ErrorMsg(){
       String errormsg= WaitUtil.WebForElement(driver,By.xpath("//div[@class='validation-summary-errors']/span")).getText(); 
       System.out.println(errormsg);
    }
    public void enterCredentials(String email,String pass){
        WaitUtil.WebForElement(driver, By.id("Email")).sendKeys(email);
        WaitUtil.WebForElement(driver, By.id("Password")).sendKeys(pass);
    }
    public void displayResult(){
        if(!driver.findElements(By.xpath("//div[@class='validation-summary-errors']/span")).isEmpty()){
            String errmsg=WaitUtil.WebForElement(driver,By.xpath("//div[@class='validation-summary-errors']/span")).getText();
            System.out.println("Login Failed");
            System.out.println(errmsg);
        }else{
            String accname=WaitUtil.WebForElement(driver,By.xpath("//div[@class='header-links']/ul/li//a[@class='account']")).getText();
            System.out.println("Login Sucessfull");
            System.out.println(accname);
        }
    }
    public void registerDetails(String firsttname, String lastname, String pass, String confpass ){    
        String mail="DemoWebsite"+System.currentTimeMillis()+"@gmail.com";

        WaitUtil.WebForElement(driver,By.id("gender-male")).click();
        WaitUtil.WebForElement(driver,By.id("FirstName")).sendKeys(firsttname);
        WaitUtil.WebForElement(driver,By.id("LastName")).sendKeys(lastname);
        WaitUtil.WebForElement(driver,By.id("Email")).sendKeys(mail);

        Assert.assertEquals(pass, confpass,"Both the Password and conformPassword are not Same");
        System.out.println("Password Validation Completed");
        driver.findElement(By.id("Password")).sendKeys(pass);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(confpass);  
    }
    public void clickregister(){
             WaitUtil.WebForElement(driver,By.id("register-button")).click();
    }
    public void homepage(){
        parent=driver.getWindowHandle();
        String Email=WaitUtil.WebForElement(driver,By.xpath("(//a[@class='account'])[1]")).getText();
        Assert.assertEquals(Email, "demowebsite@gmail.com","Both the Email Id are not same");
        System.out.println(Email+"HomePage Verification");
    }
    public void search(String productName){
      WebElement searchBox= WaitUtil.WebForElement(driver, By.id("small-searchterms"));
      searchBox.clear();
      searchBox.sendKeys(productName);
      WaitUtil.WebForElement(driver,By.xpath("//input[@value='Search']")).click();
    }
    public void addCart(){
        WaitUtil.WebForElement(driver,By.xpath("//input[@value='Add to cart']")).click();
        WaitUtil.WebForElement(driver,By.xpath("//span[@class='cart-qty']")).click();
        WebElement qty=WaitUtil.WebForElement(driver,By.xpath("//input[@class='qty-input']"));
        String qty_txt=qty.getAttribute("value");
        int qty_val=Integer.parseInt(qty_txt);
        if(qty_val>1){
           WebElement update= WaitUtil.WebForElement(driver, By.xpath("//input[@class='qty-input']"));
           update.click();
           update.clear();
           update.sendKeys("1");
           WaitUtil.WebForElement(driver,By.xpath("//input[@name='updatecart']")).click();
        }
        String value=WaitUtil.WebForElement(driver,By.xpath("//span[@class='product-price order-total']")).getText();
        System.out.println("The product price : "+ value);
    }
    public void checkout(){
        WaitUtil.WebForElement(driver,By.id("termsofservice")).click();
        WaitUtil.WebForElement(driver,By.id("checkout")).click();
    }
    public void placeorder(){
       String verify= WaitUtil.WebForElement(driver,By.xpath("//div[@class='page-title']")).getText();
       Assert.assertEquals(verify, "Checkout","NOT SAME");
       System.out.println("CheckOut Validation Passed");
     WebElement country=  WaitUtil.WebForElement(driver,By.xpath("//select[@data-val-required='Country is required.']"));
    Select select = new Select(country);
           select.selectByVisibleText("India");
           String selectedcountry=select.getFirstSelectedOption().getText();
           System.out.println("The Selected country "+ selectedcountry);
           driver.switchTo().window(parent);
           String Email=WaitUtil.WebForElement(driver,By.xpath("(//a[@class='account'])[1]")).getText();
           Assert.assertEquals(Email, "demowebsite@gmail.com","Both the Email Id are not same");
           System.out.println(Email+" - HomePage Verification");
    }
}
