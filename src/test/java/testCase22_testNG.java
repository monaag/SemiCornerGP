import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;


public class testCase22_testNG {
    WebDriver driver;
    static ArrayList<String> tabs;
    WebDriverWait wait;

    @BeforeMethod
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addExtensions(new File("src/main/resources/GIGHMMPIOBKLFEPJOCNAMGKKBIGLIDOM_5_13_0_0.crx"));
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.get( "http://automationexercise.com");
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

    @Test
    public void addToCartFromRecommendation() throws InterruptedException {
        // Verify home page
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/", "Invalid home page URL");
        // Verify recommended items section
        Assert.assertTrue(driver.findElement(By.cssSelector("div[class=\"recommended_items\"] h2:nth-child(1)")).isDisplayed(), "No recommended items");
        // Add product from recommended items section
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".carousel-inner:nth-child(1) .item.active div[class=\"col-sm-4\"]:nth-child(2) a"))));
        String prodName = driver.findElement(By.cssSelector(".carousel-inner:nth-child(1) .item.active div[class=\"col-sm-4\"]:nth-child(2) p")).getText();
        product.click();
        Thread.sleep(600);
        driver.findElement(By.cssSelector(".modal-footer button")).click();
        driver.findElement(By.cssSelector(".nav a[href=\"/view_cart\"]")).click();
        // Verify the product
        Assert.assertEquals(driver.findElement(By.cssSelector("tbody tr:nth-child(1) h4")).getText(), prodName, "Names aren't the same!");
    }

    @AfterMethod
    public void quitBrowser() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

}