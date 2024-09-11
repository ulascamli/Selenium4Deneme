package Step;

import Driver.BaseTest;
import WebMethods.Methods;
import com.thoughtworks.gauge.Step;
import lombok.extern.log4j.Log4j;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;
@Log4j

public class StepImplementation {
    Methods methods;
    BaseTest baseTest;
    
    public static int DEFAULT_MAX_ITERATION_COUNT = 75;
    public static int DEFAULT_MILLISECOND_WAIT_AMOUNT = 1500;

    public StepImplementation() {
        methods = new Methods();
        baseTest = new BaseTest();
    }

    @Step("<driver> ile çalıştır")
    public void ilkStep(String driver) {
        baseTest.setDriver(driver, "https://www.youtube.com");
        log.info("Driver başarılı");

    }

    @Step("Driver'ı kapat")
    public void quitDriver() {
        methods.close();
        log.info("driver kapatıldı");
    }

    @Step("<saniye> saniye bekle")
    public void waitBySeconds(Long saniye) {
        methods.waitBySeconds(saniye);
        log.info(""+saniye+" saniye beklendi");
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

