package Gun13;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class _01_RobotGiris extends BaseStaticDriver {
    public static void main(String[] args) throws AWTException {

        driver.get("https://demo.guru99.com/test/upload/");

        Robot rbt = new Robot();

        for (int i = 0; i < 13 ; i++) {
            rbt.keyPress(KeyEvent.VK_TAB);  // TAB a basıldı  down
            rbt.keyRelease(KeyEvent.VK_TAB);  // TAB bırakıldı   up
            Bekle(1);
        }
        rbt.keyPress(KeyEvent.VK_ENTER);
        rbt.keyRelease(KeyEvent.VK_ENTER);

        // Stringi hafızaya-clipboard a kopyalama kodu
        StringSelection stringSelection = new StringSelection("\"C:\\Users\\user\\Desktop\\ornek.txt\"");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection , null);
        // Verilen stringi clipboard a set ediyor.

        Bekle(1);

        rbt.keyPress(KeyEvent.VK_CONTROL);
        rbt.keyPress(KeyEvent.VK_V);

        Bekle(1);

        rbt.keyRelease(KeyEvent.VK_CONTROL);
        rbt.keyRelease(KeyEvent.VK_V);

        for (int i = 0; i <2 ; i++) {
            rbt.keyPress(KeyEvent.VK_TAB);  // TAB a basıldı  down
            rbt.keyRelease(KeyEvent.VK_TAB);  // TAB bırakıldı   up
            Bekle(1);
        }
        rbt.keyPress(KeyEvent.VK_ENTER);   // ENTERE BASTIK
        rbt.keyRelease(KeyEvent.VK_ENTER);

        WebElement submit = driver.findElement(By.id("submitbutton"));
        submit.click();

        BekleKapat();



    }
}
