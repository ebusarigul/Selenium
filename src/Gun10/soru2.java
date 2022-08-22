package Gun10;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class soru2 extends BaseStaticDriver {
    public static void main(String[] args) {

        driver.get("https://www.demoblaze.com/index.html");

        WebElement s6 = driver.findElement(By.linkText("Samsung galaxy s6"));
        s6.click();
        WebElement addToCard = driver.findElement(By.linkText("Add to cart"));
        addToCard.click();


        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        WebElement homepage = driver.findElement(By.id("nava"));
        homepage.click();

        BekleKapat();





    }
}
