package com.softserve.mentorship.articleproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.logging.Logger;

public abstract class BasePage {

    protected WebDriver driver;
    public static Logger log = Logger.getLogger("LOGGER:");

    //
    private WebElement articleDropDown;
    private WebElement newDropDown;
    private WebElement hotelElement;
    private WebElement closeButton;


    //
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    private void getArticleDropDown(){
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Article')]"));
        actions.moveToElement(element).perform();
    }

    private void getNewDropdown(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//li[contains(@class,'ui-widget ui-menuitem ui-corner-all')]//span[text()='New']"))).perform();
    }
    private void clickHotelOption(){
        driver.findElement(By.xpath("//li[contains(@class,'ui-menuitem ui-widget')]//span[text()='Hotel']")).click();
    }

    //
    public RegisterNewHotel gotoRegisterNewHotel(){
        getArticleDropDown();
        getNewDropdown();
        clickHotelOption();
        return new RegisterNewHotel(driver);
    }
    private WebElement getCloseButton() {
        return driver.findElement(By.xpath("//span[@class='ui-menuitem-icon ui-icon ui-icon-close']"));
    }
    public void clickCloseButton(){
        getCloseButton().click();
    }

}
