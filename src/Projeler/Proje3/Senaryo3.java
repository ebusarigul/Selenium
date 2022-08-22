package Projeler.Proje3;

import Utils.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Senaryo3 extends BaseStaticDriver {
    public static void main(String[] args) {


        driver.get("https://shopdemo.e-junkie.com/");

        WebElement demoEbookAddtoCard = driver.findElement(By.xpath("//*[@id=\"products\"]/div[1]/div/div[2]/a/div/div[2]/button"));
        demoEbookAddtoCard.click();

        driver.switchTo().frame(5);

        WebElement debitCard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='Payment-Button CC']")));
        debitCard.click();

        WebElement payButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='Pay-Button']")));
        payButton.click();

        WebElement invalidMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='SnackBar']/span")));

        Assert.assertTrue(invalidMessage.getText().contains("Invalid"));

        BekleKapat();

    }
}
