package Step;

import Driver.BaseTest;
import WebMethods.Methods;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class StepImplementation {
    Methods methods;
    BaseTest baseTest;
    public static int DEFAULT_MAX_ITERATION_COUNT = 75;
    public static int DEFAULT_MILLISECOND_WAIT_AMOUNT = 1500;

    public StepImplementation() {
        methods = new Methods();
        baseTest = new BaseTest();
    }

    @Step("Selamın hello")
    public void ilkStep() {
        baseTest.setDriver("Chrome", "https://www.youtube.com");
        System.out.println("Driver başarılı");
    }

    @Step("Driver'ı kapat")
    public void quitDriver() {
        methods.close();
    }

    @Step("<saniye> saniye bekle")
    public void waitBySeconds(Long saniye) {
        methods.waitBySeconds(saniye);
    }

    @Step("<url> adresine git")
    public void navigateToUrl(String url) {
        methods.navigateTo(url);
    }
    @Step("Sitede geri git")
    public void navigateToBack() {
        methods.navigateToBack();
    }
    @Step("Sayfanın yüklenmesi beklenir")
    public void waitPageLoad(){
        methods.waitPageLoad();
    }

}

