package Mentoring;

import Utils.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.nio.file.Watchable;

public class soru1 extends BaseStaticDriver {
    public static void main(String[] args) throws AWTException {

        driver.get("http://automationpractice.com/index.php");

        WebElement bluz = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[2]//img"));

        Actions aksiyonlar = new Actions(driver);
        aksiyonlar.moveToElement(bluz).build().perform();

        WebElement addToCard = driver.findElement(By.xpath("(//a[@title=\"Add to cart\"]/span)[2]"));
        aksiyonlar.moveToElement(addToCard).click().perform();

        WebElement proCheckOut = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id=\"layer_cart\"] a")));
        aksiyonlar.moveToElement(proCheckOut).click().perform();

        WebElement searchBox = driver.findElement(By.id("search_query_top"));
        aksiyonlar.keyDown(searchBox, Keys.SHIFT).sendKeys("c").keyUp(Keys.SHIFT).sendKeys("omputer").perform();

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        WebElement result = driver.findElement(By.cssSelector("[id=\"center_column\"]  p"));
        System.out.println("result.isDisplayed() = " + result.isDisplayed());

        Assert.assertTrue(result.getText().contains("No results were found for your search"));

        BekleKapat();


    }
}
