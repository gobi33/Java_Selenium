package stepdefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import stepdefinitions.Reports.ExtentManager;

public class Hooks {
    public static WebDriver driver;
    static ExtentReports extent= ExtentManager.getReport();
    static ExtentTest test;

    @Before
    public void setup(Scenario scenario){
        test=extent.createTest(scenario.getName());

        System.out.println("Opening Browser");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    @After
    public void teardown(Scenario scenario) throws IOException {
        if(scenario.isFailed()){
            test.fail("Failed");
        }else{
            test.pass("Passed");
        }
        extent.flush();
        if(scenario.isFailed()){
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String FileName=scenario.getName()+".png";
            File destination=new File("target/screenshots/"+FileName);
            destination.getParentFile().mkdirs();
            Files.copy(source.toPath(), destination.toPath(),StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot Saved "+ destination.getAbsolutePath());
        }
        System.out.println("Closing Browser");
        driver.quit();
    }
    
}
