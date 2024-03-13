import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class test {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.get( "https://www.spicejet.com/");
    }

    @Test
    public void testtt(){
        driver.findElement(By.cssSelector("div[class=\"css-1dbjc4n r-1d09ksm r-1inuy60 r-m611by\"]"));

    }

    @AfterMethod
    public void quitBrowser() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

}
