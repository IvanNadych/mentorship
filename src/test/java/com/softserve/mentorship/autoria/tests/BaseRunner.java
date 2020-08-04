package com.softserve.mentorship.autoria.tests;

import com.softserve.mentorship.autoria.pages.SearchResult;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public abstract class BaseRunner {
    protected static WebDriver driver;
    public static Logger log = Logger.getLogger("LOGGER:");

    @BeforeSuite
    public void beforeSuite() {
        log.info("Setup browser");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    @Parameters(value = "implicitWait")
    public void setUpBeforeClass(int time) {
        log.info("Set time out nad browser window size");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    @BeforeMethod
    @Parameters(value = "url")
    public void setUp(String url) throws Exception {
        log.info("Go to UATORIA website");
//        driver.get("https://auto.ria.com/");
        driver.get(url);
    }


    public SearchResult loadApplication() {
        return new SearchResult(driver);
    }

    @AfterMethod
    public void tearDown() {
        log.info("Clear cookies");
        driver.manage().deleteAllCookies();

    }
    @AfterClass(alwaysRun = true)
    public void tearDownAfterClass() throws Exception {
        log.info("Close browser");
        driver.quit();
    }



}
