package tests;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pagesDemowebReg.RegPage;
import pagesDemowebReg.FillDetails;

public class DemowebRegTest {

    public static void main(String [] args)
           throws   InterruptedException {
        long num=System.currentTimeMillis();
        String Mail="demowebsite"+num+"@gmail.com";      //Dynamic emailID


        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
                                           // reg page
        RegPage regpage=new RegPage(driver);
        regpage.goto_regpage();
                                            //fill details
        FillDetails data=new FillDetails(driver);
      //  data.fillform("Demo","Website","demowebsite@gamil.com");
        data.fillform("Demo","Website",Mail);
        data.passwrd("Website@123","Website@12356");
       String MailData= data.dynamicdate();

        Assert.assertEquals(Mail, MailData,"Both MailId are not same");
        System.out.println("Login Sucessfully with correct mail ID used for registeration");
        
         Thread.sleep(6000);
        driver.quit();
    }
    
}
