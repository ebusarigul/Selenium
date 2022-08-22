package Gun11;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class _01_IFrameGiris extends BaseStaticDriver {
    public static void main(String[] args) {

        driver.get("https://chercher.tech/practice/frames");

        driver.switchTo().frame(0);

        WebElement input = driver.findElement(By.cssSelector("#topic+input"));
        input.sendKeys("Türkiye");

        driver.switchTo().frame(0);
        WebElement checkBox = driver.findElement(By.id("a")); // checkBox click.// sıfırıncı frame in sıfırıncı frame i
        checkBox.click();

        driver.switchTo().defaultContent();

        driver.switchTo().frame(1);
        WebElement menu = driver.findElement(By.cssSelector("#animals"));
        Select select = new Select(menu);
        select.selectByValue("avatar");


        BekleKapat();

    }
}
