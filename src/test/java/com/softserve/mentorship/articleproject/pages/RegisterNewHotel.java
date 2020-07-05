package com.softserve.mentorship.articleproject.pages;

import com.softserve.mentorship.articleproject.data.CountryName;
import com.softserve.mentorship.articleproject.data.EditFieldsName;
import com.softserve.mentorship.articleproject.data.LabelsName;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class RegisterNewHotel extends BasePage {


    private WebElement pageHeader;
    private WebElement dataSection;
    private WebElement saveButton;
    private WebElement nameField;
    private WebElement editField;
    private WebElement errorMessage;
    private WebElement dateErrorMessage;
    private List<WebElement> rateList;
    private List<WebElement> rateListOn;
    private WebElement ratingValue;
    private WebElement dateToday;
    private WebElement currentDay;
    private WebElement datePickerButton;
    private WebElement dateEditField;
    private WebElement dropDownName;

    private WebDriverWait wait = new WebDriverWait(driver, 10);


    public RegisterNewHotel(WebDriver driver) {
        super(driver);
    }

    private WebElement getPageHeader() {
        return driver.findElement(By.xpath("//h2[contains(text(),'Register new Hotel')]"));
    }

    @Step("Verify that Register new Hotel is displayed")
    public String getPageHeaderText() {
        return getPageHeader().getText().trim();
    }

    private WebElement getDataSection() {
        return driver.findElement(By.xpath("//span[@class='ui-panel-title']"));
    }

    @Step("Verify that Data section is displayed")
    public String getSectionText() {
        return getDataSection().getText().trim();
    }


    private WebElement getSaveButton() {
        return driver.findElement(By.xpath("//span[text()='Save']"));
    }

    private void clickSaveButton() {
        getSaveButton().click();
    }

    @Step("Verify that save button is displayed")
    public boolean isSaveButtonDisplayed() {
        boolean result = false;
        if (getSaveButton().isDisplayed() && getSaveButton().getText().equals("Save")) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    //Field label
    private WebElement getNameField(LabelsName name) {
        return driver.findElement(By.xpath("//div[contains(@class,'ui-panel-content ui-widget-content')]//label[@for='add_hotel:" + name.getNameLabel() + "']"));
    }

    @Step("Verify that {name} is displayed ")
    public boolean isFieldDisplayed(LabelsName name) {
        boolean result = false;
        String fieldText = getNameField(name).getText().trim().substring(0, getNameField(name).getText().length() - 1);

        if (fieldText.equalsIgnoreCase(name.getLabelText()) && getNameField(name).isDisplayed()) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    @Step("Verify that {name} is marked with asterisk")
    public boolean isFieldMarkedWithAsterisk(LabelsName name) {
        boolean result = false;
        if (getNameField(name).getText().trim().contains(name.getLabelText()) && getNameField(name).getText().contains("*")) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    //Edit Input field
    private WebElement getEditField(EditFieldsName fieldName) {
        return driver.findElement(By.xpath("//div[@class='ui-panel-content ui-widget-content']//input[@name='add_hotel:" + fieldName.getFieldName() + "']"));
    }

    private WebElement getTextArea(EditFieldsName fieldName) {
        return driver.findElement(By.xpath("//div[@class='ui-panel-content ui-widget-content']//textarea[@name='add_hotel:" + fieldName.getFieldName() + "']"));
    }

    @Step("Verify that {fieldName} is editable and allows to input alphanumeric characters")
    public boolean isFieldEditable(EditFieldsName fieldName){
        boolean result = false;
        if (getEditField(fieldName).isEnabled()) {
            getEditField(fieldName).click();
            String name = RandomStringUtils.randomAlphanumeric(10);
            getEditField(fieldName).sendKeys(name);
            getEditField(fieldName).clear();
            result = true;
        } else {
            result = false;
        }
        return result;
    }
    @Step("Verify that {fieldName} is editable and allows to input alphanumeric characters")
    public boolean isTextAreaEditable(EditFieldsName fieldName) {
        boolean result = false;
        if (getTextArea(fieldName).isEnabled()) {
            getTextArea(fieldName).click();
            String name = RandomStringUtils.randomAlphanumeric(10);
            getTextArea(fieldName).sendKeys(name);
            getTextArea(fieldName).clear();
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    private WebElement getErrorMessage(LabelsName name) {
        return driver.findElement(By.xpath("//span[@class='ui-message-error-detail' and contains(text(),'" + name.getLabelText() + " Validation Error: Value is required.')]"));
    }

    private String getErrorMessageText(LabelsName name) {
        return getErrorMessage(name).getText().trim();
    }

    @Step("Verify that it is not possible to save the empty {fieldName} ")
    public boolean isNotPossibleToSaveHotelWithEmptyField(EditFieldsName fieldName, LabelsName name) {
        driver.navigate().refresh();
        boolean result = false;
        if (getEditField(fieldName).isEnabled()) {
            getEditField(fieldName).click();
            getEditField(fieldName).clear();
            getSaveButton().click();
            if (getErrorMessage(name).isDisplayed() && getErrorMessageText(name).trim().contains(name.getLabelText() + " Validation Error: Value is required.")) {
                result = true;

            } else {
                result = false;
            }
        }
        return result;
    }
    @Step("Verify that it is not possible to save the empty {fieldName} ")
    public boolean isNotPossibleToSaveHotelWithEmptyTextArea(EditFieldsName fieldName, LabelsName name) {
        driver.navigate().refresh();
        boolean result = false;
        if (getTextArea(fieldName).isEnabled()) {
            getTextArea(fieldName).click();
            getTextArea(fieldName).clear();
            getSaveButton().click();
            if (getErrorMessage(name).isDisplayed() && getErrorMessageText(name).trim().contains(name.getLabelText() + " Validation Error: Value is required.")) {
                result = true;

            } else if(!getErrorMessage(name).isDisplayed()){
                result =false;
            }
        }
        return result;
    }
    @Step("Verify that it is possible to save the empty {fieldName} ")
    public boolean isPossibleToSaveHotelWithEmptyTextArea(EditFieldsName fieldName, LabelsName name) {
        boolean result = false;
        if (getTextArea(fieldName).isEnabled()) {
            getTextArea(fieldName).click();
            getTextArea(fieldName).clear();
            getSaveButton().click();
            try {
                if(getErrorMessage(name).isDisplayed()){
                    result = false;
                }
            }catch ( Exception e){
                if(getTextArea(fieldName).getText().isEmpty()){
                    result =true;
                }

            }
        }
        return result;
    }

    @Step("Verify that it is not possible to save the empty {fieldName} ")
    public boolean isNotPossibleToSaveHotelWithEmptyDropDown(EditFieldsName fieldName, LabelsName name) {
        boolean result = false;
        if (getEditField(fieldName).isEnabled() && getEditField(fieldName).getText().isEmpty()) {
            getSaveButton().click();
            if (getErrorMessage(name).isDisplayed() && getErrorMessageText(name).trim().contains(name.getLabelText() + " Validation Error: Value is required.")) {
                result = true;

            } else {
                result = false;
            }
        }
        return result;
    }

    @Step("Verify that it is possible to save the valid {fieldName}")
    public boolean isItPossibleToSaveWithValidData(EditFieldsName fieldName) {
        boolean result = false;
        String name = RandomStringUtils.randomAlphanumeric(10);
        if (getEditField(fieldName).isEnabled()) {
            getEditField(fieldName).click();
            getEditField(fieldName).clear();
            getEditField(fieldName).sendKeys(name);
            clickSaveButton();
            if (getEditField(fieldName).getAttribute("Value").equalsIgnoreCase(name)) {
                result = true;
            }
        } else {
            result = false;
        }
        return result;
    }
    @Step("Verify that it is possible to save the valid {fieldName}")
    public boolean isItPossibleToSaveTextAreaWithValidData(EditFieldsName fieldName) {
        boolean result = false;
        String name = RandomStringUtils.randomAlphanumeric(10);
        if (getTextArea(fieldName).isEnabled()) {
            getTextArea(fieldName).click();
            getTextArea(fieldName).clear();
            getTextArea(fieldName).sendKeys(name);
            clickSaveButton();
            if (getTextArea(fieldName).getText().equalsIgnoreCase(name)) {
                result = true;
            }
        } else {
            result = false;
        }
        return result;
    }

    private WebElement getDateErrorMessage() {
        return driver.findElement(By.xpath("//span[@class='ui-message-error-detail' and contains(text(),' could not be understood as a date.')]"));
    }

    private String getErrorMessageDateInvalidText() {
        return getDateErrorMessage().getText().trim();
    }

    //Global rating


    private List<WebElement> getRateList() {
        return driver.findElements(By.xpath("//div[@class='ui-rating']/div[@class='ui-rating-star']"));
    }

    private List<WebElement> getRateListOn() {
        return driver.findElements(By.xpath("//div[@class='ui-rating']/div[@class='ui-rating-star ui-rating-star-on']"));
    }

    private WebElement getRatingValue() {
        return driver.findElement(By.xpath("//div[@class='ui-rating']/input"));
    }

    private int getValueOfRate() {
        String value = getRatingValue().getAttribute("value");
        return Integer.parseInt(value);
    }

    @Step("Verify that Global Rating field allows to rating of the hotel ")
    public boolean isGlobalRatingAllowsToRate() {
        boolean result = false;
        getRateList().get(3).click();
        if (getRateListOn().size() == getValueOfRate()) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }

    @Step("Verify that it is possible to save valid Global Rating field")
    public boolean isItPossibleToSaveValidGlobalRating(int number) {
        driver.navigate().refresh();
        boolean result = false;
        getRateList().get(number - 1).click();
        System.out.println("tr");
        if (getRateListOn().size() == number) {
            clickSaveButton();
            if (getRateListOn().size() == getValueOfRate())
                result = true;
        } else {
            result = false;
        }

        return result;
    }


    //Date picker
    private WebElement getDateToday() {
        return driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td[contains(@class,'ui-datepicker-today')]"));

    }

    public void clickDateToday() {
        getDateToday().click();
    }

    private WebElement getCurrentDay() {
        return driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td[contains(@class,'current-day')]"));
    }

    private WebElement getDateEditField() {
        return driver.findElement(By.xpath("//div[@class='ui-panel-content ui-widget-content']//input[contains(@id,'dateOfConstruction_input')]"));
    }

    private WebElement getDatePickerButton() {
        return driver.findElement(By.xpath("//button[contains(@class,'ui-datepicker-trigger')]"));
    }

    public void clickDatePickerButton() {
        getDatePickerButton().click();
    }

    public boolean isDateConstructionEditable() throws ParseException {
        boolean result = false;
        clickDatePickerButton();
        clickDateToday();
        getDateEditField().sendKeys(Keys.ENTER);
        String date = getDateEditField().getText().trim();
        Date date1 = new SimpleDateFormat("mm/dd/yyyy").parse(date);
        if (date1.equals(SimpleDateFormat.getDateTimeInstance())) {
            result = true;
        }
        return result;
    }

    @Step("Verify that it is not possible to save incorrect  date format value Date of Construction field ")
    public boolean isNotPossibleToSaveIncorrectDateFormat(LabelsName name) {
        boolean result = false;
        String date = "12232020";
        getDateEditField().click();
        getDateEditField().sendKeys(date);
        clickSaveButton();
        if (getDateErrorMessage().isDisplayed() && getErrorMessageDateInvalidText().contains(name.getLabelText() + " '" + date + "' could not be understood as a date.")) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    @Step("Verify that it is possible to save valid Date of Construction field")
    public boolean isItPossibleToSaveDateConstructionWithValidData() {
        boolean result = false;
        clickDatePickerButton();
        clickDateToday();
        clickSaveButton();
        String date = getDateEditField().getAttribute("value");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yy");
        LocalDateTime now = LocalDateTime.now();
        if (formatter.format(now).equals(formatter.format(formatter.parse(date)))) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    //Country
    private WebElement getDropDownName(CountryName name) {
        return driver.findElement(By.xpath("//div[@class='ui-selectonemenu-items-wrapper']/ul/li[contains(@data-label,'" + name.getDataLabel() + "')]"));
    }

    private void clickDropDownName(CountryName name) {
        getDropDownName(name).click();
    }

    private WebElement getDropDownLabel(EditFieldsName fieldsName) {
        return driver.findElement(By.xpath("//div[@class='ui-panel-content ui-widget-content']//label[@id='add_hotel:" + fieldsName.getFieldName() + "']"));
    }

    private String getDropDownLabelText(EditFieldsName fieldsName) {
        return getDropDownLabel(fieldsName).getText();
    }

    @Step("Verify that {fieldName} field is editable")
    public boolean isCountryFieldEditable(EditFieldsName fieldName, CountryName name, CountryName name1) {
        boolean result = false;
        getDropDownLabel(fieldName).click();
        clickDropDownName(name);
        if (getDropDownLabelText(fieldName).equals(name.getCountryName())) {
            getDropDownLabel(fieldName).click();
            clickDropDownName(name1);
            if (getDropDownLabelText(fieldName).equals(name1.getCountryName())) {
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

    @Step("Verify that it is possible to save the valid {fieldName} field")
    public boolean isPossibleToSaveCountryField(EditFieldsName fieldName, CountryName name) {
        boolean result = false;
        getDropDownLabel(fieldName).click();
        clickDropDownName(name);
        clickSaveButton();
        if (getDropDownLabelText(fieldName).equals(name.getCountryName())) {
            result = true;

        } else {
            result = false;
        }
        return result;
    }

    //City
    @Step("Verify that {fieldName} field is editable")
    public boolean isCityFieldEditable(EditFieldsName fieldName, CountryName countryName, EditFieldsName fieldName1, CountryName cityName, CountryName countryName1, CountryName cityName1) {
        boolean result = false;
        getDropDownLabel(fieldName).click();
        getDropDownName(countryName).click();
        if (getDropDownLabelText(fieldName).equals(countryName.getCountryName())) {
            getDropDownLabel(fieldName1).click();
            clickDropDownName(cityName);
            if (getDropDownLabelText(fieldName1).equals(cityName.getCountryName())) {
                getDropDownLabel(fieldName).click();
                clickDropDownName(countryName1);
                if (getDropDownLabelText(fieldName).equals(countryName1.getCountryName())) {
                    getDropDownLabel(fieldName1).click();
                    clickDropDownName(cityName1);
                    if (getDropDownLabelText(fieldName1).equals(cityName1.getCountryName())) {
                        result = true;
                    } else {
                        result = false;
                    }
                }
            }
        }
        return result;
    }

    @Step("Verify that it is possible to save the valid {fieldName} field")
    public boolean isPossibleToSaveValidCityField(EditFieldsName fieldName, CountryName countryName, EditFieldsName fieldName1, CountryName cityName) {
        boolean result = false;
        getDropDownLabel(fieldName).click();
        getDropDownName(countryName).click();
        if (getDropDownLabelText(fieldName).equals(countryName.getCountryName())) {
            getDropDownLabel(fieldName1).click();
            clickDropDownName(cityName);
            clickSaveButton();
            if (getDropDownLabelText(fieldName1).equals(cityName.getCountryName())) {
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }


}
