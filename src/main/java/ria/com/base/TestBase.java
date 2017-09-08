package ria.com.base;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import ru.stqa.selenium.factory.WebDriverFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class TestBase {

    public RemoteWebDriver driver;
    public Properties URL = null;
    public DesiredCapabilities capability;
    public String id_user;

    @Parameters({"browser", "os"})
    @BeforeTest
//    public void setUp(@Optional("chrome") String browser, @Optional("WINDOWS") String os, final ITestContext context) throws Exception {
    public void setUp(@Optional("chrome") String browser, @Optional("LINUX") String os, final ITestContext context) throws Exception {
        if (browser.equalsIgnoreCase("firefox")) {
            System.out.println("OPENING FIREFOX");
            capability = DesiredCapabilities.firefox();
            capability.setBrowserName("firefox");
            capability.setPlatform(Platform.valueOf(os));

        } else if (browser.equalsIgnoreCase("chrome")) {
            System.out.println("OPENING CHROME");
            capability = DesiredCapabilities.chrome();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("test-type");
            capability.setCapability(ChromeOptions.CAPABILITY, options);
            capability.setBrowserName("chrome");
            capability.setPlatform(Platform.valueOf(os));
        }

        /**new gecko*/
        else if (browser.equalsIgnoreCase("geckodriver")) {
            System.out.println("RUN GECKO DRIVER");
            capability = DesiredCapabilities.firefox();
            capability.setCapability("webdriver.gecko.driver", "C:/selenium/geckodriver.exe");
            capability.setCapability("marionette", true);
            capability.setBrowserName("firefox");
            capability.setPlatform(Platform.WINDOWS);
        }


        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
//        this.driver = (RemoteWebDriver) WebDriverFactory.getDriver("http://localhost:4444/wd/hub", capability);
        driver.manage().window().maximize();
        context.setAttribute("driverKey", driver);
        driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterTest(alwaysRun = true)
    public void BrowserCloset() {

        driver.quit();
//		WebDriverFactory.dismissAll();
        System.out.println("CLOSE BROWSER");
    }

}
