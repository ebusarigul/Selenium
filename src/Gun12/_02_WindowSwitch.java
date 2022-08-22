package Gun12;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class _02_WindowSwitch extends BaseStaticDriver {
    public static void main(String[] args) {

        driver.get("https://www.selenium.dev/");

        String anasayfa = driver.getWindowHandle(); // bulundugun sayfanın id si

        List<WebElement> linkler = driver.findElements(By.cssSelector("a[target='_blank']"));

        for (WebElement link : linkler){

            if (!link.getAttribute("href").contains("mailto")){
                link.click();
            }
        }

        Set<String> windowIDler = driver.getWindowHandles();  // acık olan tüm sayfaların ıd leri

        for (String id : windowIDler){

            if (!id.equals(anasayfa)){

                System.out.println("id = " + id);
                driver.switchTo().window(id);
                System.out.println(id + " Title() = " + driver.getTitle());

            }
        }

        Bekle(3);
        BekleKapat();
    }
}
