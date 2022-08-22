package Mentoring;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class youtube_odevi extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("https://www.youtube.com/");
        /*
            Search for selenium
            Find the 80th video in page then print it.
         */

        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#search")));
        search.sendKeys("Selenium");

        Bekle(3);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#search-icon-legacy")));
        button.click();

        List<WebElement> videos = driver.findElements(By.cssSelector("[id='img'][draggable='false'][class='style-scope yt-img-shadow'][width='360']"));

        while (videos.size() <= 80) {

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1500)");

            videos = (driver.findElements(By.cssSelector("[id='img'][draggable='false'][class='style-scope yt-img-shadow'][width='360']")));
        }

        List<WebElement> titles = driver.findElements(By.cssSelector("[id='video-title'][class='yt-simple-endpoint style-scope ytd-video-renderer']"));
        System.out.println(titles.get(titles.size() - 1).getAttribute("title"));
        System.out.println(videos.size());

        BekleKapat();
    }
}
