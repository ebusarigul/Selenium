package Gun12;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class soru1deneme2 extends BaseStaticDriver {
    public static void main(String[] args) {

        driver.get("https://www.youtube.com/");

        WebElement searchBox = driver.findElement(By.xpath("//*[@id='search-input']/input"));
        searchBox.sendKeys("Selenium");

        WebElement buton = driver.findElement(By.cssSelector("[id=search-icon-legacy]"));
        buton.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        List<WebElement> videolar = driver.findElements(By.xpath("//a[@class='yt-simple-endpoint style-scope ytd-playlist-renderer' or @id='video-title']"));

        for (int i = 1; i <=80 ; i++) {

            videolar = driver.findElements(By.xpath("//a[@class='yt-simple-endpoint style-scope ytd-playlist-renderer' or @id='video-title']"));
            js.executeScript("arguments[0].scrollIntoView()",videolar.get(i));
            if (i == 80){
                System.out.println("80. Videonun Title'i = " + videolar.get(80).getText());
                break;
            }
        }

        BekleKapat();
    }
}
