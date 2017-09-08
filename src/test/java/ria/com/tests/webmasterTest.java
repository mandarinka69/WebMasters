package ria.com.tests;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class webmasterTest extends TestSuiteBase {

    String Date;
    int Count;


    @Test(priority = 1)
    public void test1_webmasters() throws Exception {
        openPage("https://www.google.com/webmasters/tools/crawl-errors?hl=ru&siteUrl=https://auto.ria.com/#t2=5");

        login();

        openPage("https://www.google.com/webmasters/tools/crawl-errors?hl=ru&siteUrl=https://auto.ria.com/#t2=5");

        Thread.sleep(1500);

        Count = Integer.parseInt(driver.findElements(By.cssSelector(" div.gwt-Label.wmt-legend-count")).get(1).getText());
        Date = driver.findElements(By.cssSelector("div.header-subtitle.goog-inline-block")).get(1).getText();


        System.out.println(Count);
        System.out.println(Date);

        openPage("https://script.google.com/a/macros/ria.com/s/AKfycbwMl8BIhwzGoBnjG0wNWG7tBzKwTS9OoSJEI3__G7ptTFa0dtLe/exec?" +
                "Count="+Count+"&Count="+Count+"");
    }


}
