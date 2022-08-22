package Gun12;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

/*
   1- https://www.selenium.dev/  sayfasına gidiniz
   2- Sayfadaki bütün yeni sayfa açan linkleri tıklatınız(mailto hariç)
   3- Açılan bütün yeni sayfaları teer teker kapatınız
*/

public class _03_WindowsClosing extends BaseStaticDriver {
    public static void main(String[] args) {

        driver.get("https://www.selenium.dev/");

        List<WebElement> linkler = driver.findElements(By.cssSelector("a[target='_blank']"));

        for (WebElement link : linkler){

            if (!link.getAttribute("href").contains("mailto")){
                link.click();
                Bekle(1);
            }
        }

        Set<String> windowIDler = driver.getWindowHandles();  // acık olan tüm sayfaların ıd leri

        for (String id : windowIDler){

            driver.switchTo().window(id).close();
            Bekle(1);
        }


        Bekle(2);
        BekleKapat();
    }
}
