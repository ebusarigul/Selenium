package Gun12;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class _01_WindowGiris extends BaseStaticDriver {
    public static void main(String[] args) {


        driver.get("https://www.selenium.dev/");

        List<WebElement> linkler = driver.findElements(By.cssSelector("a[target='_blank']"));

        for (WebElement l : linkler) {

            if (!l.getAttribute("href").contains("mailto"))
                l.click();
        }

        Set<String> windowIDler = driver.getWindowHandles();

        for (String id : windowIDler ){
            System.out.println("id = " + id);
        }

    }
}
