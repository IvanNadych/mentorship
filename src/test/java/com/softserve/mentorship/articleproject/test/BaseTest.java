package com.softserve.mentorship.articleproject.test;

import com.softserve.mentorship.articleproject.pages.RegisterNewHotel;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public abstract class BaseTest {
    protected WebDriver driver;
    public static Logger log = Logger.getLogger("LOGGER:");

    @BeforeClass
    public void beforeClass() {

            WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"url","implicitWait"})
    public void setBrowserProperties(String url, int time) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);

    }

    public RegisterNewHotel loadRegisterNewHotelPage() {
        return new RegisterNewHotel(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }

}
