package org.example.stepDefs;
import java.time.Duration;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;



public class Hooks {
    public static WebDriver driver;

    @Before
    public static void open() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //https://wuzzuf.net/jobs/egypt
        //https://www.talabat.com/egypt
        driver.get( "https://www.talabat.com/egypt");
    }
    @After
    public static void quit() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}