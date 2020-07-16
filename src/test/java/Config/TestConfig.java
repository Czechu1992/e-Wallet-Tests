package Config;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import static Config.WebDriverSingledon.getInstance;
import static Config.WebDriverSingledon.quit;

public class TestConfig {

    @BeforeTest
    public void setUp() {
        //String baseUrl = "https://czechu1992.github.io/e-Wallet/";
        String baseUrl = "C:\\Users\\czech\\Desktop\\proejkty\\eWallet\\index.html";
        WebDriver driver = getInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @AfterTest
    public void tearDown() {
        quit();
    }
}
