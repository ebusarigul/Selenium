package Projeler.Proje4_1;

import Utils.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class proje4_1 extends BaseStaticDriver {
    public static void main(String[] args) {

        driver.get("http://demowebshop.tricentis.com/");

        //register();
        positiveLogin();
        logOut();
        negativeLogin();
        positiveLogin();
        buyProduct();
        BekleKapat();

    }

    private static void buyProduct() {

        WebElement computer = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[@class='inactive']/a)[2]")));
        Actions actions = new Actions(driver);
        actions.moveToElement(computer).click().build().perform();

        WebElement desktop = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title=\"Show products in category Desktops\"]>img")));
        actions.moveToElement(desktop).click().build().perform();

        WebElement expensivePc = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@value=\"Add to cart\"])[3]")));
        actions.moveToElement(expensivePc).click().build().perform();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button-74"))).click();

        WebElement content = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class=\"content\"]")));
        Assert.assertTrue(content.isDisplayed());

        WebElement shoppingCart = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id=\"topcartlink\"]>a>span")));
        actions.moveToElement(shoppingCart).build().perform();

        Bekle(2);

        WebElement goToCart = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[value=\"Go to cart\"]")));
        actions.moveToElement(goToCart).click().build().perform();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name=\"removefromcart\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("termsofservice"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout"))).click();

        WebElement menu = driver.findElement(By.id("billing-address-select"));
        Select select1 = new Select(menu);
        select1.selectByVisibleText("New Address");

        WebElement ulkeMenu = driver.findElement(By.id("BillingNewAddress_CountryId"));
        Select select = new Select(ulkeMenu);
        wait.until(ExpectedConditions.visibilityOfAllElements(ulkeMenu));
        select.selectByValue("77");

        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Bursa");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("Nilufer");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("16130");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("53184132146");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id=\"billing-buttons-container\"]>input"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id=\"shipping-buttons-container\"]>input"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id=\"shipping-method-buttons-container\"]>input"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id=\"payment-method-buttons-container\"]>input"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id=\"payment-info-buttons-container\"]>input"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id=\"confirm-order-buttons-container\"]>input"))).click();

        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Your order has been successfully processed!']")));
        System.out.println(result.getText());
        Assert.assertEquals("Your order has been successfully processed!", result.getText());

    }

    private static void logOut() {
        WebElement logOut = driver.findElement(By.linkText("Log out"));
        logOut.click();
    }

    private static void negativeLogin() {
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("Email")).sendKeys("esargl147@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("123457");
        driver.findElement(By.cssSelector("[value=\"Log in\"]")).click();

        WebElement message = driver.findElement(By.cssSelector(".validation-summary-errors li"));
        Assert.assertTrue(message.isDisplayed());
        Assert.assertTrue(message.getText().contains("The credentials provided are incorrect"));


    }

    public static void positiveLogin() {
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("Email")).sendKeys("esargl147@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("123456");
        driver.findElement(By.cssSelector("[value=\"Log in\"]")).click();
        WebElement logOut = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logOut.isDisplayed());
    }

    private static void register() {
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("ebubekir");
        driver.findElement(By.id("LastName")).sendKeys("sarigul");
        driver.findElement(By.id("Email")).sendKeys("esargl147@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("123456");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("123456");
        driver.findElement(By.id("register-button")).click();

        WebElement result = driver.findElement(By.cssSelector("[class=\"result\"]"));
        Assert.assertTrue(result.getText().contains("Your registration completed"));

        driver.findElement(By.cssSelector("[value=\"Continue\"]")).click();

    }


}
