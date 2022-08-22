package Gun13;
import Utils.BaseStaticDriver;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Set;

public class _04_SoruTask extends BaseStaticDriver {
    public static void main(String[] args) throws AWTException {

        driver.get("https://www.google.com/");

        yeniSekmeAc();

        Set<String> windowIDler = driver.getWindowHandles();
        for (String id : windowIDler ){
            driver.switchTo().window(id);
        }
        driver.get("https://www.twitter.com/");

        yeniSekmeAc();

        Set<String> windowIDler2 = driver.getWindowHandles();
        for (String id : windowIDler2 ){
            driver.switchTo().window(id);
        }
        driver.get("https://www.facebook.com/");

    }

    private static void yeniSekmeAc() throws AWTException {
        Robot rbt = new Robot();
        rbt.keyPress(KeyEvent.VK_CONTROL);
        rbt.keyPress(KeyEvent.VK_T);

        rbt.keyRelease(KeyEvent.VK_CONTROL);
        rbt.keyRelease(KeyEvent.VK_T);
        Bekle(1);
    }
}
