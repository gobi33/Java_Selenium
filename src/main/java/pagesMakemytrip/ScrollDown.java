package pagesMakemytrip;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ScrollDown {
    WebDriver driver;
    public ScrollDown(WebDriver driver){
      this.driver=driver;
    }
    public void down(int x, int y) {

    JavascriptExecutor js =(JavascriptExecutor) driver;

    js.executeScript("window.scrollBy(arguments[0], arguments[1])", x, y);
}
    
}
