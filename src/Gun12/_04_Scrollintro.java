package Gun12;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
/*
 Selenium da Sayfayı aşağı kaydırılması gereken durumlar vardır:
    Bunlar , sayfa kaydırıldıkça yüklenen elemanlar için

    Bu işlem javascriptexecuter ile yapılır.Bu interface sayesinde
    sayfa kaydırma işlemi ve javascript komutları çalıştırılabilir
    sayfa üzerinde.

*/

public class _04_Scrollintro extends BaseStaticDriver {
    public static void main(String[] args) {

        driver.get("https://triplebyte.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,1500)"); //  y ekseninde 1500 px kadar asagı kaydıracak"window.scrollBy(0,1500)");

        //  (0,1500)    --->  (x,y) sayfayı x ybirim kadar saga y birim kadar assagı kaydırır

        Bekle(1);

        js.executeScript(   "window.scrollBy(0,-500)");  //  y ekseninde 500 px kadar yukarı kaydıracak

        Bekle(1);

        //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");  // sayfanın sonuna kadar gider

        Bekle(1);

        WebElement element = driver.findElement(By.linkText("Take a quiz"));
        js.executeScript("arguments[0].scrollIntoView()", element);   // elemente kadar scroll yapar

        Bekle(1);

        js.executeScript("arguments[0].click()",element);  // elemente click yapma

        BekleKapat();
    }
}
