package Gun10;

import Utils.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class soru1 extends BaseStaticDriver {
    public static void main(String[] args) {


        driver.get("http://demo.seleniumeasy.com/ajax-form-submit-demo.html");

        driver.findElement(By.cssSelector("[id='title']")).sendKeys("Ebubekir");
        driver.findElement(By.cssSelector("[id='description']")).sendKeys("ornek yapiyorum");
        driver.findElement(By.cssSelector("#btn-submit")).click();

        wait.until(ExpectedConditions.textToBe(By.id("submit-control"), "Form submited Successfully!"));

        WebElement text = driver.findElement(By.id("submit-control"));
        System.out.println(text.getText());

        Assert.assertEquals("Form submited Successfully!", text.getText());

        BekleKapat();

    }
}
