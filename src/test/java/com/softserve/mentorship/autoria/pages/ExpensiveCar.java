package com.softserve.mentorship.autoria.pages;

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
        String price = driver.findElement(By.xpath("//div[@class='sticky-15']//div[@class='price_value']")).getText();
        return Double.parseDouble(price.replaceAll("[ |$]", ""));
    }

    private double getCarPriceForBMW() {
//        String price = driver.findElement(By.xpath("//div[@class='price_value']/strong")).getText();
        String price = driver.findElement(By.xpath("//section[@class='price mb-15 mhide']/div[@class='price_value']")).getText();
        price = price.substring(0, price.length() - 1);
        return Double.parseDouble(price.replace(" ", ""));
    }

    private String getCarName() {
        return driver.findElement(By.xpath("//h1[@class='auto-head_title bold mb-15']")).getText();
    }

    public Map<Double, String> priceAndNameOfSelectedMercedes() {
        Map<Double, String> map = new HashMap<>();
        map.put(getCarPriceForMercedes(), getCarName().substring(6));
        log.info("Compare the car names and prices");
        return map;
    }

    public Map<Double, String> priceAndNameOfSelectedBMW() {
        Map<Double, String> map = new HashMap<>();
        map.put(getCarPriceForBMW(), getCarName().substring(6));
        log.info("Compare the car names and prices");
        return map;
    }

    public ExpensiveCar gotoExpensivePage() {
        return new ExpensiveCar(driver);
    }


}
