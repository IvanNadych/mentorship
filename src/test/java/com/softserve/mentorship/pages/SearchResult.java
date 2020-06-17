package com.softserve.mentorship.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SearchResult extends CarsPage {

    private WebElement carPage;


    public SearchResult(WebDriver driver) {
      super(driver);
    }


   private void getCarsPage(){
        driver.findElement(By.xpath("//nav[@class='nav-head']/a[2]")).click();

   }

    public SearchResult goToSearchPage(){
        getCarsPage();
        return new SearchResult(driver);
    }



}
