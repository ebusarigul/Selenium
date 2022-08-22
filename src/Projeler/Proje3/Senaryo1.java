package Projeler.Proje3;

import Utils.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Senaryo1 extends BaseStaticDriver {
    public static void main(String[] args) {

        driver.get("https://shopdemo.e-junkie.com/");

        WebElement demoEbookAddtoCard = driver.findElement(By.xpath("//*[@id='products']/div[1]/div/div[1]/a/div/div[2]/button"));
        demoEbookAddtoCard.click();

        driver.switchTo().frame(5);

        WebElement adet = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='tel']")));

        //WebElement adet = driver.findElement(By.xpath("//input[@type='tel']"));
        Assert.assertEquals("1", adet.getAttribute("value"));

        driver.findElement(By.cssSelector("[class='Product-Remove']")).click();

        driver.findElement(By.cssSelector("[class='Continue-Button Close-Cart']")).click();
        driver.switchTo().defaultContent();

        WebElement sepettekiUrunToplam = driver.findElement(By.xpath("(//span[@id='cart_item_nos'])[2]"));
        Assert.assertEquals("0", sepettekiUrunToplam.getText());

        BekleKapat();
    }
}
