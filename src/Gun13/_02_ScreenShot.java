package Gun13;

import Utils.BaseStaticDriver;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class _02_ScreenShot extends BaseStaticDriver {
    public static <tarih1> void main(String[] args) throws IOException {


        driver.get("https://opensource-demo.orangehrmlive.com/");

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Admin12");
        driver.findElement(By.id("btnLogin")).click();

        List<WebElement> spanMessage = driver.findElements(By.id("spanMessage"));

        if (spanMessage.size()>0){   // login olamadım hata ekran görüntüsünü alıp saklayalım.

            System.out.println("Login olamadı. Hata mesajı gözüktü");

            // Ekran görüntüsünü alalım
            TakesScreenshot ts = (TakesScreenshot) driver;  //1.Aşama    ekran görüntüsü alma degiskenini tanımladım
            File dosyaHali = ts.getScreenshotAs(OutputType.FILE);   // 2.Aşama    saklama tipi secildi (Dosya olarak secildi) veritabanında sakla olarakta secebilriz.
            // dosyaHali  ->  dosya olarak (jpeg,png,bmp) kaydedecegiz.

            LocalDateTime dt= LocalDateTime.now();
            DateTimeFormatter ozelFormat=DateTimeFormatter.ofPattern("_dd_MM_yyyy hh.mm.ss");
            String tarih = dt.format(ozelFormat);

            FileUtils.copyFile(dosyaHali, new File("ekranGoruntuleri/LoginCheck"+tarih+".png"));
            BekleKapat();



        }











    }
}
