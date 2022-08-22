package Projeler.Proje_4;
import Utils.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class proje4 extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("http://demowebshop.tricentis.com/");

        //demoWebShopRegister();
        scenario_1();
        scenario_2();
        scenario_3();
    }
    public static void demoWebShopRegister() {

        WebElement register = wait.until(ExpectedConditions.elementToBeClickable(By.className("ico-register")));
        register.click();

        WebElement gender = driver.findElement(By.id("gender-female"));
        gender.click();

        WebElement firstNameInput = driver.findElement(By.id("FirstName"));
        firstNameInput.sendKeys("Techno");

        WebElement lastNameInput = driver.findElement(By.id("LastName"));
        lastNameInput.sendKeys("Study");

        WebElement emailInput = driver.findElement(By.id("Email"));
        emailInput.sendKeys("techno233@google.com");

        WebElement passwordInput = driver.findElement(By.id("Password"));
        passwordInput.sendKeys("techno1234");

        WebElement passwordInput2 = driver.findElement(By.id("ConfirmPassword"));
        passwordInput2.sendKeys("techno1234");

        WebElement registerBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("register-button")));
        registerBtn.click();

        WebElement successMessage = driver.findElement(By.className("result"));
        Assert.assertTrue(successMessage.getText().contains("completed"));

        WebElement continueBtn = driver.findElement(By.cssSelector("[value='Continue']"));
        continueBtn.click();

        WebElement logOutBtn = driver.findElement(By.className("ico-logout"));
        logOutBtn.click();

    }
    public static void scenario_1() {
        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.className("ico-login")));
        login.click();

        WebElement emailInput = driver.findElement(By.id("Email"));
        emailInput.sendKeys("techno233@google.com");

        WebElement passwordInput = driver.findElement(By.id("Password"));
        passwordInput.sendKeys("techno1234");

        WebElement loginBtn = driver.findElement(By.className("login-button"));
        loginBtn.click();

        WebElement successMessage = driver.findElement(By.className("account"));
        Assert.assertEquals("techno233@google.com", successMessage.getText());

        WebElement logOutBtn = driver.findElement(By.className("ico-logout"));
        logOutBtn.click();
    }
    public static void scenario_2() {
        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.className("ico-login")));
        login.click();

        WebElement emailInput = driver.findElement(By.id("Email"));
        emailInput.sendKeys("techno@google.com");

        WebElement passwordInput = driver.findElement(By.id("Password"));
        passwordInput.sendKeys("techno1234");

        WebElement loginBtn = driver.findElement(By.className("login-button"));
        loginBtn.click();

        WebElement successMessage = driver.findElement(By.className("validation-summary-errors"));
        Assert.assertTrue(successMessage.getText().contains("unsuccessful"));

        WebElement homePage = driver.findElement(By.className("header-logo"));
        homePage.click();
    }
    public static void scenario_3() {
        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.className("ico-login")));
        login.click();

        WebElement emailInput = driver.findElement(By.id("Email"));
        emailInput.sendKeys("techno233@google.com");

        WebElement passwordInput = driver.findElement(By.id("Password"));
        passwordInput.sendKeys("techno1234");

        WebElement loginBtn = driver.findElement(By.className("login-button"));
        loginBtn.click();

        WebElement addToCartBtn =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class=\"product-grid home-page-product-grid\"]>:nth-child(3) [value=\"Add to cart\"]")));
        addToCartBtn.click();

        WebElement shoppingCart = driver.findElement(By.id("topcartlink"));
        shoppingCart.click();

        WebElement terms = driver.findElement(By.id("termsofservice"));
        terms.click();

        WebElement checkOut = driver.findElement(By.id("checkout"));
        checkOut.click();

        WebElement country = driver.findElement(By.id("BillingNewAddress_CountryId"));
        Select selectCountry = new Select(country);
        selectCountry.selectByValue("1");

        WebElement city = driver.findElement(By.id("BillingNewAddress_City"));
        city.sendKeys("NewYork");

        WebElement address = driver.findElement(By.id("BillingNewAddress_Address1"));
        address.sendKeys("NewYork 2");

        WebElement zipCode = driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
        zipCode.sendKeys("22000");

        WebElement phone = driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
        phone.sendKeys("1856745963");

        WebElement continue1 =
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[onclick=\"Billing.save()\"]")));
        continue1.click();

        WebElement continue2 =
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[onclick=\"Shipping.save()\"]")));
        continue2.click();

        WebElement continue3 =
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[onclick=\"ShippingMethod.save()\"]")));
        continue3.click();

        WebElement continue4 =
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[onclick=\"PaymentMethod.save()\"]")));
        continue4.click();

        WebElement continue5 =
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[onclick=\"PaymentInfo.save()\"]")));
        continue5.click();

        WebElement confirmBtn =
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[onclick=\"ConfirmOrder.save()\"]")));
        confirmBtn.click();

        WebElement successMessage = driver.findElement(By.xpath("//*[text()='Your order has been successfully processed!']"));
        Assert.assertTrue(successMessage.getText().contains("successfully"));

        WebElement logOutBtn = driver.findElement(By.className("ico-logout"));
        logOutBtn.click();
    }
}
