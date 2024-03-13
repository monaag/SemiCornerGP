import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.util.ArrayList;


public class testCase21_testNG {
    WebDriver driver;
    static ArrayList<String> tabs;
    Faker faker = new Faker();

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
    public void addReviewOnProduct() throws InterruptedException {
        //Click on products button
        driver.findElement(By.cssSelector(".navbar-nav li:nth-child(2)")).click();
        //Verify all products page
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/products", "Invalid Products page URL");
        // Verify reviews section
        driver.findElement(By.cssSelector("a[href=\"/product_details/1\"]")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("a[href=\"#reviews\"]")).isDisplayed(), "Reviews section not visible!");
        // Add review
        driver.findElement(By.id("name")).sendKeys(faker.name().firstName());
        driver.findElement(By.id("email")).sendKeys(faker.internet().safeEmailAddress());
        driver.findElement(By.id("review")).sendKeys(faker.lorem().paragraph());
        driver.findElement(By.id("button-review")).click();
        // Verify the success message
        Assert.assertTrue(driver.findElement(By.cssSelector("div[class=\"alert-success alert\"] span")).isDisplayed(), "No success review message!");
    }

    @AfterMethod
    public void quitBrowser() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

}