package Driver;

import WebMethods.Methods;
import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    public WebDriverWait webDriverWait;
    public static WebDriver webDriver;
    public String baseUrl;
    public JavascriptExecutor js;
    Methods methods;
    public BaseTest() {
        methods = new Methods();
    }

    @Before
    public void setDriver(String browser,String url) {

        switch (browser) {
            case "Chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver(chromeOptions);
                System.out.println("Chrome Tarayıcısı başlatıldı");
                baseUrl = "" + url + "";
                webDriver.navigate().to(baseUrl);
                webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                webDriver.manage().deleteAllCookies();
                webDriver.manage().window().maximize();
                break;

            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                System.out.println("Firefox tarayıcısı başlatıldı");
                baseUrl = "" + url + "";
                webDriver.navigate().to(baseUrl);
                webDriver.manage().deleteAllCookies();
                webDriver.manage().window().maximize();
                webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                break;
        }
        methods.setDriver(webDriver);
    }
    @After
    public void driverQuit(){
        webDriver.quit();
    }
}
