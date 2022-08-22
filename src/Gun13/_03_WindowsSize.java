package Gun13;

import Utils.BaseStaticDriver;
import org.openqa.selenium.Dimension;

import java.awt.*;

public class _03_WindowsSize extends BaseStaticDriver {
    public static void main(String[] args) {

        driver.get("https://www.youtube.com/");

        Dimension dim = new Dimension(516,600);
        driver.manage().window().setSize(dim);

        Bekle(4);









    }
}
