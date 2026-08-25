package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pagesDemPract.Desktop;
import pagesDemPract.LoginPage;

public class DemPract {
    public static void main(String [] args)
    throws InterruptedException{
        WebDriver driver=new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");

        LoginPage login=new LoginPage(driver);
        login.fillDetials("demowebsite@gmail.com","Website@123");

        Desktop desktop=new Desktop(driver);
        desktop.goTo();
        desktop.LowestPrice();
        desktop.addtocart();


        Thread.sleep(6000);
        driver.quit();
    }
    
}
