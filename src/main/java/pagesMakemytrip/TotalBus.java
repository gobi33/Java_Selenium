package pagesMakemytrip;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TotalBus {

    WebDriver driver;

    public TotalBus(WebDriver driver) {
        this.driver = driver;
    }

    public void names() {

        List<WebElement> busname =
                driver.findElements(
                        By.xpath("//span[@style='vertical-align: middle;']"));

        List<WebElement> busprice =
                driver.findElements(
                        By.xpath("//span[@class='fare text-neutral-800']"));

        int count = Math.min(busname.size(), busprice.size());

        System.out.println("Total Bus Count : " + count);

        for (int i = 0; i < count; i++) {

            String travels =
                    busname.get(i).getText();

            String travelsPrice =
                    busprice.get(i).getText();

            String numericPrice =
                    travelsPrice.replaceAll("[^0-9]", "");

            int price =
                    numericPrice.isEmpty()
                    ? 0
                    : Integer.parseInt(numericPrice);

            System.out.println(
                    (i + 1)
                    + ". "
                    + travels
                    + " = "
                    + price);
        }
    }
}
