package Projeler.Proje3;

import Utils.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Senaryo4 extends BaseStaticDriver {
    public static void main(String[] args) {

        driver.get("https://shopdemo.e-junkie.com/");

        WebElement demoEbookAddtoCard = driver.findElement(By.xpath("//*[@id=\"products\"]/div[1]/div/div[2]/a/div/div[2]/button"));
        demoEbookAddtoCard.click();

        driver.switchTo().frame(5);

        WebElement debitCard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='Payment-Button CC']")));
        debitCard.click();

        Bekle(2);
        //WebElement iframe = driver.findElement(By.cssSelector("iframe[name='__privateStripeFrame8717']"));
        driver.switchTo().frame(2);

        WebElement cardNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='cardnumber']")));
        cardNumber.sendKeys("1111 1111 1111 1111");

        driver.switchTo().parentFrame();

        WebElement gecersizKartNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='SnackBar']>span")));

        System.out.println("gecersizKartNo.isDisplayed() = " + gecersizKartNo.isDisplayed());
        System.out.println("gecersizKartNo.getText() = " + gecersizKartNo.getText());

        Assert.assertTrue(gecersizKartNo.getText().contains("geçersiz"));

        BekleKapat();

    }
}
