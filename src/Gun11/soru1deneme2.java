package Gun11;

import Utils.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class soru1deneme2 extends BaseStaticDriver {
    public static void main(String[] args) {

        for (int i = 0; i < 5 ; i++) {

            driver.get("https://testsheepnz.github.io/BasicCalculator.html");

            int random1 = (int) (Math.random() * 100 + 1);
            String rndm1 = String.valueOf(random1);
            WebElement number1 = driver.findElement(By.cssSelector("#number1Field"));
            number1.sendKeys(rndm1);

            int random2 = (int) (Math.random() * 100 + 1);
            String rndm2 = String.valueOf(random2);
            WebElement number2 = driver.findElement(By.cssSelector("#number2Field"));
            number2.sendKeys(rndm2);

            WebElement islem = driver.findElement(By.cssSelector("#selectOperationDropdown"));
            Select islemMenu = new Select(islem);

            for (int j = 0; j < islemMenu.getOptions().size() ; j++) {
                Bekle(1);
                islemMenu.selectByIndex(j);
                Bekle(1);

                WebElement calculate = driver.findElement(By.cssSelector("#calculateButton"));
                calculate.click();

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#numberAnswerField")));

                WebElement sonuc = driver.findElement(By.cssSelector("#numberAnswerField"));
                String actualResult = sonuc.getAttribute("value");
                String expectedResult = "";

                switch (j){
                    case 0 : expectedResult = String.valueOf(random1+random2);break;
                    case 1 : expectedResult = String.valueOf(random1-random2);break;
                    case 2 : expectedResult = String.valueOf(random1*random2);break;
                    case 3 : expectedResult = String.valueOf((double) random1/random2);break;
                    case 4 : expectedResult = rndm1+rndm2;break;
                }

                Assert.assertEquals(expectedResult,actualResult);

            }
        }
        BekleKapat();
    }
}
