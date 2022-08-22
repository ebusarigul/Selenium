package Gun11;

import Utils.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class soru1 extends BaseStaticDriver {
    public static void main(String[] args) {


        driver.get("https://testsheepnz.github.io/BasicCalculator.html");

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                WebElement firstNumber = driver.findElement(By.id("number1Field"));
                int s1 = (int) (Math.random() * 100 + 1);
                String s1yazi = String.valueOf(s1);
                firstNumber.sendKeys(s1yazi);

                WebElement secondNumber = driver.findElement(By.id("number2Field"));
                int s2 = (int) (Math.random() * 100 + 1);
                String s2yazi = String.valueOf(s2);
                secondNumber.sendKeys(s2yazi);

                String sonuc = "";

                switch (i){
                    case 0 : sonuc = String.valueOf(s1+s2);break;
                    case 1 : sonuc = String.valueOf(s1-s2);break;
                    case 2 : sonuc = String.valueOf(s1*s2);break;
                    case 3 : sonuc = String.valueOf((double) s1/s2);break;
                    case 4 : sonuc = s1yazi.concat(s2yazi);break;
                }

                WebElement islem = driver.findElement(By.id("selectOperationDropdown"));
                Select ddmenu = new Select(islem);
                ddmenu.selectByIndex(i);

                WebElement calculate = driver.findElement(By.id("calculateButton"));
                calculate.click();

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#numberAnswerField")));

                WebElement sonucKontrol = driver.findElement(By.id("numberAnswerField"));
                String snc = sonucKontrol.getAttribute("value");

                Assert.assertEquals(snc, sonuc);

                firstNumber.clear();
                secondNumber.clear();

            }
        }
        BekleKapat();
    }
}