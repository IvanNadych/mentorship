package com.softserve.mentorship.autoria.tests;

import com.softserve.mentorship.autoria.pages.SearchResult;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    @Parameters(value = "url")
    public void setUp(String url) throws Exception {
        log.info("Go to UATORIA website");
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
