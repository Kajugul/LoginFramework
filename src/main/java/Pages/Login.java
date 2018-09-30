package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * created by : Sandeep Duve
 * crated at: 11:42 PM: 30-9-2018
 *
 * 
 */

public class Login
{
    WebDriver driver;

    public Login(WebDriver driver)
    {
        this.driver = driver;
    }

    public void loginAs(String user, String pass)
    {
        driver.findElement(By.name("username")).clear(); // clear the field
        driver.findElement(By.name("username")).sendKeys(user); // passing username to fields

        driver.findElement(By.name("password")).clear(); // clear the field
        driver.findElement(By.name("password")).sendKeys(pass); // passing password to fields

        // click on submit btn.
        By by = By.xpath("//input[@type='submit']");
        driver.findElement(by).submit();
    }

    public void verifyLogin()
    {
        driver.switchTo().frame(driver.findElement(By.xpath("/html/frameset/frame[2]")));
        WebDriverWait driverWait = new WebDriverWait(driver, 60);

        WebElement isLogoutDisplayed = driver.findElement(By.xpath("//a[@class='topnavlink']/i[@class='fa fa-sign-out icon-2x']"));
        driverWait.until(ExpectedConditions.elementToBeClickable(isLogoutDisplayed));

        Assert.assertTrue(isLogoutDisplayed.isDisplayed(), "Logout button is not available on home page...!!!");
    }
}
