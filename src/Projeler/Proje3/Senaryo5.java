package Projeler.Proje3;

import Utils.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Senaryo5 extends BaseStaticDriver {
    public static void main(String[] args) {

        driver.get("https://shopdemo.e-junkie.com/");

        WebElement demoEbookAddtoCard = driver.findElement(By.xpath("//*[@id=\"products\"]/div[1]/div/div[2]/a/div/div[2]/button"));
        demoEbookAddtoCard.click();

        driver.switchTo().frame(5);

        WebElement debitCard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='Payment-Button CC']")));
        debitCard.click();

        WebElement email = driver.findElement(By.cssSelector("[placeholder=\"Email\"]"));
        email.sendKeys("esargl147@gmail.com");

        WebElement confirmEmail = driver.findElement(By.cssSelector("[placeholder=\"Confirm Email\"]"));
        confirmEmail.sendKeys("esargl147@gmail.com");

        WebElement nameOnCard = driver.findElement(By.cssSelector("[placeholder=\"Name On Card\"]"));
        nameOnCard.sendKeys("Ebubekir Sarıgül");

        Bekle(2);

        driver.switchTo().frame(2);

        WebElement cardNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='cardnumber']")));
        cardNumber.sendKeys("4242 4242 4242 4242");

        WebElement exp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='exp-date']")));
        exp.sendKeys("12/22");

        WebElement cvv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name=\"cvc\"]")));
        cvv.sendKeys("000");

        driver.switchTo().parentFrame();

        WebElement payButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class=\"Pay-Button\"]")));
        payButton.click();

        wait.until(ExpectedConditions.urlContains("fatfreecartpro.com"));

        WebElement thanksPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class=\"green_text_margin\"]")));
        System.out.println("thanksPage.isDisplayed() = " + thanksPage.isDisplayed());
        System.out.println("thanksPage.getText() = " + thanksPage.getText());

        Assert.assertTrue(thanksPage.getText().contains("Thank you!"));

        BekleKapat();


    }
}
