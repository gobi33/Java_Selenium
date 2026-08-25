package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pagesMakemytrip.LoginPopup;
import pagesMakemytrip.ScrollDown;
import pagesMakemytrip.SelectPlaces;
import pagesMakemytrip.TotalBus;

import org.openqa.selenium.chrome.ChromeOptions;

public class MakemytripTest  {
    public static void main(String[] args)
    throws InterruptedException{

       ChromeOptions options = new ChromeOptions();

       options.addArguments("--ignore-certificate-errors");

       WebDriver driver = new ChromeDriver(options);


        driver.get("https://www.abhibus.com/");

        driver.manage().window().maximize();
        System.out.println("The page title : "+ driver.getTitle());
                                              // alert popup
        LoginPopup loginpopup=new LoginPopup(driver);
        loginpopup.accept();
                                              // scroll page
        ScrollDown scroll=new ScrollDown(driver);
        scroll.down(0,200);
                                              //select places
        SelectPlaces selectplace=new SelectPlaces(driver);
        selectplace.fromandto();
        selectplace.search();
                                                // total bus
        TotalBus totalbus=new TotalBus(driver);
        totalbus.names();




        Thread.sleep(4000);
        driver.quit();
    }
    
}
