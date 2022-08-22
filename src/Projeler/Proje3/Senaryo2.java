package Projeler.Proje3;

import Utils.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class Senaryo2 extends BaseStaticDriver {
    public static void main(String[] args) throws AWTException {


        driver.get("https://shopdemo.e-junkie.com/");

        WebElement demoEbookAddtoCard = driver.findElement(By.xpath("//*[@id='products']/div[1]/div/div[1]/a/div/div[2]/button"));
        demoEbookAddtoCard.click();

        driver.switchTo().frame(5);

        WebElement buttonAdd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class$='Show-Promo-Code-Button']")));
        buttonAdd.click();

        WebElement promoCode = driver.findElement(By.cssSelector("input[class='Promo-Code-Value']"));
        promoCode.sendKeys("123456789");

        Robot rbt = new Robot();
        rbt.keyPress(KeyEvent.VK_TAB);
        rbt.keyRelease(KeyEvent.VK_TAB);

        List<WebElement> hataMesaj = driver.findElements(By.xpath("//span[contains(text(),'Invalid promo code')]"));
        Assert.assertTrue(hataMesaj.size() > 0);

        BekleKapat();


    }
}
