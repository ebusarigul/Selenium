package Gun12;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class soru1 extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {


        driver.get("https://www.youtube.com/");

        WebElement searchBox = driver.findElement(By.xpath("//*[@id='search-input']/input"));
        searchBox.sendKeys("Selenium");

        Bekle(2);

        WebElement buton = driver.findElement(By.cssSelector("[id=search-icon-legacy]"));
        buton.click();

        Bekle(2);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement video = null;

        for (int i = 1; i <= 80; i++) {

            video = driver.findElement(By.xpath("(//a[@class='yt-simple-endpoint style-scope ytd-playlist-renderer' or @id='video-title'])["+i+"]"));
            wait.until(ExpectedConditions.visibilityOf(video));
            jse.executeScript("arguments[0].scrollIntoView()",video);

        }
        System.out.println(" 80. videonun Title'ı = " + video.getAttribute("title"));

        BekleKapat();

    }
}
