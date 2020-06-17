package com.softserve.mentorship.pages;

import com.softserve.mentorship.testdata.CarBrand;
import com.softserve.mentorship.testdata.Sorting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.*;
import java.util.logging.Logger;

public abstract class CarsPage {

    public static Logger log = Logger.getLogger("LOGGER:");

    protected WebDriver driver;
    //
    private WebElement carBrand;
    private WebElement carType;
    private WebElement searchButton;
    private WebElement dropdownComponent;
    private List<WebElement> carsBrandList;
    private List<WebElement> carName;
    private List<WebElement> carPrice;
    private WebElement sorting;
    private String price;


    private List<WebElement> sortingOption;
    private WebElement headerText;

    public CarsPage(WebDriver driver) {
        this.driver = driver;
    }

    //carType
    private WebElement getCarType() {
        return driver.findElement(By.xpath("//div[@class='m-rows']/select[@id='categories']"));
    }

    public void clickCarType() {
        getCarType().click();
    }

    //carBrand
    private WebElement getCarBrand() {
        return driver.findElement(By.xpath("//div[@class='m-rows']//label[@for='brandTooltipBrandAutocompleteInput-brand']"));
    }

    public void clickCarBrand() {
        getCarBrand().click();
        log.info("Click Car Brand Dropdown");
    }

    private List<WebElement> getCarsBrandList(CarBrand carName) {
        return driver.findElements(By.xpath("//div[@id='brandTooltipBrandAutocomplete-brand']/ul/li/a[contains(text(),'" + carName.getName() + "')]"));
    }

    public void clickSelectedCarBrand(CarBrand carName) {
        getCarsBrandList(carName).get(0).click();
        log.info("Select car from dropdown: " + carName);
    }

    //SearchButton
    private WebElement getSearchButton() {
        return driver.findElement(By.xpath("//button[@class='button']"));
    }

    public void clickSearchButton() {
        getSearchButton().click();
        log.info("Click Search button");
    }


    public String getHeaderText() {
        return driver.findElement(By.xpath("//div[@class='header-page']")).getText().toLowerCase().trim();
    }


    //Car price and name
    public List<WebElement> getCarPrice() {
        return driver.findElements(By.xpath("//div[@class='price-ticket']/span[@class='size15']/span[@data-currency='USD']"));

    }

    private List<WebElement> getCarName() {
        return driver.findElements(By.xpath("//div[@class='item ticket-title']//a"));

    }

    public double getHighestPrice() {
        double maxPrice = 0;
        List<Double> list = new ArrayList<>();
        List<String> prices = new ArrayList<>();
        for (WebElement element : getCarPrice()) {
            prices.add(element.getText().trim().replace(" ", ""));
            prices.removeIf(e -> e.startsWith("д") || e.startsWith("{") || e.equals(""));
        }
        for (String str : prices) {
            list.add(Double.parseDouble(str));
        }
        maxPrice = Collections.max(list);
        return maxPrice;
    }

    public String getMostExpensiveCarName() {
        List<String> list = new ArrayList<>();
        for (WebElement element : getCarName()) {
            list.add(element.getText());
            list.removeIf(e -> e.equals(""));
        }
        return list.get(0);
    }

    public Map<Double, String> priceAndNameOfCarThatBeSelected() {
        Map<Double, String> map = new HashMap<>();
        map.put(getHighestPrice(), getMostExpensiveCarName());
        log.info("Remember the name: " + map.values() + " of the car");
        return map;
    }

    //List with all cars name.
    public boolean isAllCarsAreMercedes(CarBrand carName) {
        boolean result = false;
        List<String> list = new ArrayList<>();
        for (WebElement element : getCarName()) {
            list.add(element.getText().trim());
            list.removeIf(e -> e.startsWith("{"));

        }
        for (String str : list) {
            if (str.contains(carName.getName().trim())) {
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }


    //Sorting
    private WebElement getSorting() {
        return driver.findElement(By.xpath("(//div[@id='sortFilter']/span[@class='element-select'])[1]"));
    }

    public void clickSorting() {
        getSorting().click();
        log.info("Click sorting dropdown");
    }

    private List<WebElement> getSortingOption(Sorting attributeName) {

        return driver.findElements(By.xpath("//span/a[@data-value='" + attributeName.getAttributeName() + "']"));
    }

    public void clickSelectedSortingOption(Sorting attributeName) {
        getSortingOption(attributeName).get(0).click();
        log.info("Select sorting order from dropdown: " + attributeName);
    }
    public boolean ifCarSortedInDesc() {
        boolean result = false;
        List<Double> list = new ArrayList<>();
        List<String> prices = new ArrayList<>();
        for (WebElement element : getCarPrice()) {
            prices.add(element.getText().trim().replace(" ", ""));
            prices.removeIf(e -> e.startsWith("д") || e.startsWith("{") || e.equals(""));
        }
        for (String str : prices) {
            list.add(Double.parseDouble(str));
        }
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                result = true;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }

    public void setSorting(Sorting descOrder) {
        clickSorting();
        clickSelectedSortingOption(descOrder);
        Actions actions = new Actions(driver);
        actions.pause(3).perform();
    }


    //Business logic
    public ExpensiveCar goToMostExpensiveCar() {
        getCarName().get(0).click();
        log.info("Click the most expensive car and navigate to it");
        return new ExpensiveCar(driver);

    }

    public SearchResult selectCarBrand(CarBrand carName) {
        clickCarBrand();
        clickSelectedCarBrand(carName);
        clickSearchButton();
        return new SearchResult(driver);
    }

}
