package com.softserve.mentorship.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class ExpensiveCar extends CarsPage {
    private WebElement carPrice;
    private WebElement carName;


    public ExpensiveCar(WebDriver driver) {
        super(driver);
    }

    //Get price
    private double getCarPriceForMercedes() {
        String price = driver.findElement(By.xpath("//div[@class='price_value--additional']//span[@data-currency='USD']")).getText();
        return Double.parseDouble(price.replace(" ", ""));
    }

    private double getCarPriceForBMW() {
        String price = driver.findElement(By.xpath("//div[@class='price_value']/strong")).getText();
        price = price.substring(0, price.length() - 1);
        return Double.parseDouble(price.replace(" ", ""));
    }

    private String getCarName() {
        return driver.findElement(By.xpath("//div[@class='heading']//h1")).getText();
    }

    public Map<Double, String> priceAndNameOfSelectedMercedes() {
        Map<Double, String> map = new HashMap<>();
        map.put(getCarPriceForMercedes(), getCarName());
        log.info("Compare the car names and prices");
        return map;
    }

    public Map<Double, String> priceAndNameOfSelectedBMW() {
        Map<Double, String> map = new HashMap<>();
        map.put(getCarPriceForBMW(), getCarName());
        log.info("Compare the car names and prices");
        return map;
    }

    public ExpensiveCar gotoExpensivePage() {
        return new ExpensiveCar(driver);
    }


}
