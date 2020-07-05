package com.softserve.mentorship.autoria.tests;

import com.softserve.mentorship.autoria.pages.ExpensiveCar;
import com.softserve.mentorship.autoria.pages.SearchResult;
import com.softserve.mentorship.autoria.testdata.CarBrand;
import com.softserve.mentorship.autoria.testdata.Sorting;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.Map;
public class SearchCar extends BaseRunner {

    @DataProvider
    public Object[][] selectMercedes() {
        return new Object[][]{
                {CarBrand.MERCEDES, Sorting.DESC},

        };
    }
    @DataProvider
    public Object[][] selectBMW() {
        return new Object[][]{
                {CarBrand.BMW,Sorting.DESC},

        };
    }

    @Test(priority = 1,dataProvider = "selectMercedes")
    public void ifTheMostExpensiveMercedesSelected(CarBrand mercedes,  Sorting descOrder) throws InterruptedException {
        log.info("Running test for car: " + mercedes);
       SearchResult searchResult = loadApplication()
                            .goToSearchPage().selectCarBrand(mercedes);

        //verify that only mercedes are displayed(Check the Header and car items on hte page)
        Assert.assertTrue(searchResult.getHeaderText().contains(mercedes.getName().toLowerCase()));
        Assert.assertTrue(searchResult.isAllCarsAreMercedes(mercedes));

        //Verify that cars are not sorted in DESC
        Assert.assertFalse(searchResult.ifCarSortedInDesc());
        log.info("Cars are not sorted in: " + descOrder + "order");
        searchResult.setSorting(descOrder);

        //Verifying that cars are sorted now
        Assert.assertTrue(searchResult.ifCarSortedInDesc());
        log.info("Cars are sorted in: " + descOrder + "order");

        Map<Double,String> map = searchResult.priceAndNameOfCarThatBeSelected();
        ExpensiveCar expensiveCar = searchResult.goToMostExpensiveCar();

        //Verify that the most expensive car eas selected
        Assert.assertEquals(expensiveCar.priceAndNameOfSelectedMercedes(),map);

    }
    @Test(priority = 2,dataProvider = "selectBMW")
    public void ifTheMostExpensiveBMWSelected(CarBrand bmw,  Sorting descOrder){
        log.info("Running test for car: " + bmw);
        SearchResult searchResult = loadApplication()
                            .goToSearchPage().selectCarBrand(bmw);

        //verify that only BMW'S are displayed
        Assert.assertTrue(searchResult.getHeaderText().contains(bmw.getName().toLowerCase()));
        Assert.assertTrue(searchResult.isAllCarsAreMercedes(bmw));

        //Verify that cars are not sorted in DESC
        Assert.assertFalse(searchResult.ifCarSortedInDesc());
        log.info("Cars are not sorted in: " + descOrder + "order");
        searchResult.setSorting(descOrder);

        //Verifying that cars are sorted now
        Assert.assertTrue(searchResult.ifCarSortedInDesc());
        log.info("Cars are sorted in: " + descOrder + "order");

        Map<Double,String> map = searchResult.priceAndNameOfCarThatBeSelected();
        ExpensiveCar expensiveCar = searchResult.goToMostExpensiveCar();

        //Verify that the most expensive car eas selected
        Assert.assertEquals(expensiveCar.priceAndNameOfSelectedBMW(),map);


    }

}
