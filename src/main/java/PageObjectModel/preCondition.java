package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class preCondition
{
   public WebDriver driver = null;

    @BeforeTest
    public void beforeCondition()
    {
        String chromeDriverPath = System.getProperty("user.dir") + "//Datafiles//chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40000, TimeUnit.SECONDS);
        driver.get(ObjectRepository.URl);
    }

    @AfterTest
    public void quitBrowser() throws InterruptedException
    {
        Thread.sleep(3000);
        driver.quit();
    }
}
