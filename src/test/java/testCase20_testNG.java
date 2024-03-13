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

public class testCase20_testNG {
    WebDriver driver;
    static ArrayList<String> tabs;
    static ArrayList<String> titles = new ArrayList<>();
    static ArrayList<String> titlesCart = new ArrayList<>();
    static ArrayList<String> titlesCartLogin = new ArrayList<>();

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
    public void searchAndVerifyCart() throws InterruptedException {
        //Click on products button
        driver.findElement(By.cssSelector(".navbar-nav li:nth-child(2)")).click();
        //Verify all products page
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/products", "Invalid Products page URL");
        //Search
        driver.findElement(By.id("search_product")).sendKeys("top");
        driver.findElement(By.id("submit_search")).click();
        // Verify SEARCHED PRODUCTS
        Assert.assertTrue(driver.findElement(By.cssSelector("h2[class=\"title text-center\"]")).isDisplayed(), "Searched products Not visible");
        // Verify related products
        List <WebElement> allProductsAddToCart = driver.findElements(By.cssSelector("div[class=\"productinfo text-center\"] a[class=\"btn btn-default add-to-cart\"]"));
        List <WebElement> allProductsTitles = driver.findElements(By.cssSelector(".productinfo p"));
        for (int i = 0;i < 11; i++) {
            titles.add(allProductsTitles.get(i).getText());
            boolean containTop = titles.get(i).contains("Top");
        Assert.assertTrue(containTop,"Not related");
        // Add those products to the cart
        allProductsAddToCart.get(i).click();
        Thread.sleep(600);
        driver.findElement(By.cssSelector(".modal-footer button")).click();
        }
        // Verify products are visible
        driver.findElement(By.cssSelector(".nav a[href=\"/view_cart\"]")).click();
        int prods_cart =  driver.findElements(By.cssSelector("tbody tr")).size();
        for (int i = 1; i <= prods_cart ; i++) {
            titlesCart.add(driver.findElement(By.cssSelector("tbody tr:nth-child("+i+") h4")).getText());;
        }
        Assert.assertEquals(titles,titlesCart, "Product isn't there");
        // Login
        driver.findElement(By.cssSelector("a[href=\"/login\"]")).click();
        driver.findElement(By.cssSelector("input[data-qa=\"login-email\"]")).sendKeys("Mona8@gmail.com");
        driver.findElement(By.cssSelector("input[data-qa=\"login-password\"]")).sendKeys("12345678");
        driver.findElement(By.cssSelector(".login-form .btn.btn-default")).click();
        // Verify again products are visible
        driver.findElement(By.cssSelector(".nav a[href=\"/view_cart\"]")).click();
        for (int i = 1; i <= prods_cart ; i++) {
            titlesCartLogin.add(driver.findElement(By.cssSelector("tbody tr:nth-child("+i+") h4")).getText());
        }
        Assert.assertEquals(titles,titlesCartLogin, "Product isn't there");
    }

    @AfterMethod
    public void quitBrowser() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

}
