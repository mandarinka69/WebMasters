package ria.com.tests;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.interactions.Actions;

import ria.com.base.TestBase;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.Step;

public class TestSuiteBase extends TestBase {

    @Parameter
    public String Parametrs;
    public String Parameters;
    public String Link_to_start;
    public String Link_to_end;

    @BeforeMethod
    public void getPage() {


    }


    @Step("Переходим на страницу https://auto.ria.com{0}")
    public void openPage(String url) {
        try {
            driver.get(url);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        } catch (TimeoutException ignore) {
        }
    }

    public void login() throws Exception {
        driver.findElement(By.cssSelector("#identifierId")).sendKeys("iryna.melnik@ria.com");
        Thread.sleep(1500);
//        driver.findElement(By.cssSelector("#next")).click();
        driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
        Thread.sleep(2000);
//        driver.findElement(By.cssSelector("#Passwd")).sendKeys("vtkmybr1991");
        driver.findElement(By.name("password")).sendKeys("bibuhab69");
        Thread.sleep(1500);
//        driver.findElement(By.cssSelector("#signIn")).click();
//        driver.findElement(By.xpath("//div[2]/div[1]/div[2]")).click();
        driver.findElement(By.cssSelector("#passwordNext > content > span")).click();
        Thread.sleep(1500);

    }

}
