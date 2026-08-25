package stepdefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setup(){
        System.out.println("Opening Browser");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    @After
    public void teardown(Scenario scenario) throws IOException {
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
