package com.softserve.mentorship.articleproject.test;

import com.softserve.mentorship.articleproject.data.CountryName;
import com.softserve.mentorship.articleproject.data.DataProviders;
import com.softserve.mentorship.articleproject.data.EditFieldsName;
import com.softserve.mentorship.articleproject.data.LabelsName;
import com.softserve.mentorship.articleproject.pages.RegisterNewHotel;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RegisterNewHotelTest extends BaseTest {

    @Test(priority = 1)
    public void verifyThatUserCanOpenNewHotelPage() {
        RegisterNewHotel registerNewHotel = loadRegisterNewHotelPage().gotoRegisterNewHotel();
        //
        Assert.assertEquals(registerNewHotel.getPageHeaderText(), "Register new Hotel");
        log.info("Register new Hotel page is displayed ");
        Assert.assertEquals(registerNewHotel.getSectionText(), "Data:");
        log.info("Data section is displayed on Register new Hotel");
        Assert.assertTrue(registerNewHotel.isSaveButtonDisplayed());
        log.info("Save button is displayed on Register new Hotel");
    }

    @Test(priority = 2, dataProvider = "selectNameLabel", dataProviderClass = DataProviders.class)
    public void verifyThatUserCanEditNameField(LabelsName name, EditFieldsName fieldName) {
        RegisterNewHotel registerNewHotel = loadRegisterNewHotelPage().gotoRegisterNewHotel();
        Assert.assertTrue(registerNewHotel.isFieldDisplayed(name));
        log.info(name.getLabelText() + " field is displayed in Data section ");
        Assert.assertTrue(registerNewHotel.isFieldMarkedWithAsterisk(name));
        log.info(name.getLabelText() + " field is marked with asterisk");
        Assert.assertTrue(registerNewHotel.isFieldEditable(fieldName));
        log.info(name.getLabelText() + " field is editable and Name field allows to input alphanumeric characters");
        Assert.assertTrue(registerNewHotel.isNotPossibleToSaveHotelWithEmptyField(fieldName, name));
        log.info(" It is not possible to save the empty " + name.getLabelText() + " field ");
        Assert.assertTrue(registerNewHotel.isItPossibleToSaveWithValidData(fieldName));
        log.info("It is possible to save the valid " + name.getLabelText() + " field");

    }

    @Test(priority = 3, dataProvider = "selectRateLabel", dataProviderClass = DataProviders.class)
    public void verifyThatUserCanEditGlobalRating(LabelsName name) {
        RegisterNewHotel registerNewHotel = loadRegisterNewHotelPage().gotoRegisterNewHotel();
        Assert.assertTrue(registerNewHotel.isFieldDisplayed(name));
        log.info(name.getLabelText() + " field is displayed in Data section ");
        Assert.assertTrue(registerNewHotel.isGlobalRatingAllowsToRate());
        log.info(name.getLabelText() + " field allows to rating the hotel");
        Assert.assertTrue(registerNewHotel.isItPossibleToSaveValidGlobalRating(2));
        log.info("It is possible to save valid " + name.getLabelText() + " field");
    }

    @Test(priority = 4, dataProvider = "selectDateConstruction", dataProviderClass = DataProviders.class)
    public void verifyThatUserCanSetDateOfConstructionForNewHotel(LabelsName name, EditFieldsName fieldName) {
        RegisterNewHotel registerNewHotel = loadRegisterNewHotelPage().gotoRegisterNewHotel();
        Assert.assertTrue(registerNewHotel.isFieldDisplayed(name));
        log.info(name.getLabelText() + " field is displayed in Data section ");
        Assert.assertTrue(registerNewHotel.isFieldMarkedWithAsterisk(name));
        log.info(name.getLabelText() + " field is marked with asterisk");
        Assert.assertTrue(registerNewHotel.isNotPossibleToSaveIncorrectDateFormat(name));
        log.info(" It is not possible to save incorrect  date format value " + name.getLabelText() + " field");
        Assert.assertTrue(registerNewHotel.isNotPossibleToSaveHotelWithEmptyField(fieldName, name));
        log.info(" It is not possible to save the empty " + name.getLabelText() + " field ");
        Assert.assertTrue(registerNewHotel.isItPossibleToSaveDateConstructionWithValidData());
        log.info("It is possible to save the valid " + name.getLabelText() + " field");
    }

    @Test(priority = 5, dataProvider = "selectCountry", dataProviderClass = DataProviders.class)
    public void verifyThatUserCanAddCountryToNewHotel(LabelsName name, EditFieldsName fieldName, CountryName countryName, CountryName countryName1,
                                                      CountryName countryName2, EditFieldsName editFieldLabel) {
        RegisterNewHotel registerNewHotel = loadRegisterNewHotelPage().gotoRegisterNewHotel();
        Assert.assertTrue(registerNewHotel.isFieldDisplayed(name));
        log.info(name.getLabelText() + " field is displayed in Data section ");
        Assert.assertTrue(registerNewHotel.isFieldMarkedWithAsterisk(name));
        log.info(name.getLabelText() + " field is marked with asterisk");
        Assert.assertTrue(registerNewHotel.isNotPossibleToSaveHotelWithEmptyDropDown(fieldName, name));
        log.info(" It is not possible to save the empty " + name.getLabelText() + " field ");
        Assert.assertTrue(registerNewHotel.isCountryFieldEditable(editFieldLabel, countryName, countryName1));
        log.info(name.getLabelText() + " field is editable ");
        Assert.assertTrue(registerNewHotel.isPossibleToSaveCountryField(editFieldLabel, countryName2));
        log.info("It is possible to save the valid " + name.getLabelText() + " field");

    }

    @Test(priority = 6, dataProvider = "selectCity", dataProviderClass = DataProviders.class)
    public void verifyThatUserCanAddCityToNewHotel(LabelsName name, EditFieldsName fieldName,
                                                   EditFieldsName countryLabel, CountryName countryNameUkraine, EditFieldsName cityLabel, CountryName cityNameKyiv,
                                                   CountryName countryNameUSA, CountryName cityNameDallas, CountryName countryNameUK, CountryName cityNameLondon) {
        RegisterNewHotel registerNewHotel = loadRegisterNewHotelPage().gotoRegisterNewHotel();
        Assert.assertTrue(registerNewHotel.isFieldDisplayed(name));
        log.info(name.getLabelText() + " field is displayed in Data section ");
        Assert.assertTrue(registerNewHotel.isFieldMarkedWithAsterisk(name));
        log.info(name.getLabelText() + " field is marked with asterisk");
        Assert.assertTrue(registerNewHotel.isNotPossibleToSaveHotelWithEmptyDropDown(fieldName, name));
        log.info(" It is not possible to save the empty " + name.getLabelText() + " field ");
        Assert.assertTrue(registerNewHotel.isCityFieldEditable(countryLabel, countryNameUkraine, cityLabel, cityNameKyiv, countryNameUSA, cityNameDallas));
        log.info(name.getLabelText() + " field is editable ");
        Assert.assertTrue(registerNewHotel.isPossibleToSaveValidCityField(countryLabel, countryNameUK, cityLabel, cityNameLondon));
        log.info("It is possible to save the valid " + name.getLabelText() + " field");

    }

    @Test(priority = 7, dataProvider = "selectShortDescription", dataProviderClass = DataProviders.class)
    public void verifyThatUserCanAddShortDescriptionToNewHotel(LabelsName name, EditFieldsName fieldName) {
        RegisterNewHotel registerNewHotel = loadRegisterNewHotelPage().gotoRegisterNewHotel();
        Assert.assertTrue(registerNewHotel.isFieldDisplayed(name));
        log.info(name.getLabelText() + " field is displayed in Data section ");
        Assert.assertTrue(registerNewHotel.isFieldMarkedWithAsterisk(name));
        log.info(name.getLabelText() + " field is marked with asterisk");
        Assert.assertTrue(registerNewHotel.isFieldEditable(fieldName));
        log.info(name.getLabelText() + " field is editable and " + name.getLabelText() + " field allows to input alphanumeric characters");
        Assert.assertTrue(registerNewHotel.isNotPossibleToSaveHotelWithEmptyField(fieldName, name));
        log.info(" It is not possible to save the empty " + name.getLabelText() + " field ");
        Assert.assertTrue(registerNewHotel.isItPossibleToSaveWithValidData(fieldName));
        log.info("It is possible to save the valid " + name.getLabelText() + " field");


    }

    @Test(priority = 8, dataProvider = "selectDescription", dataProviderClass = DataProviders.class)
    public void verifyThatUserCanAddDescriptionToNewHotel(LabelsName name, EditFieldsName fieldName) {
        RegisterNewHotel registerNewHotel = loadRegisterNewHotelPage().gotoRegisterNewHotel();
        Assert.assertTrue(registerNewHotel.isFieldDisplayed(name));
        log.info(name.getLabelText() + " field is displayed in Data section ");
        Assert.assertTrue(registerNewHotel.isFieldMarkedWithAsterisk(name));
        log.info(name.getLabelText() + " field is marked with asterisk");
        Assert.assertTrue(registerNewHotel.isTextAreaEditable(fieldName));
        log.info(name.getLabelText() + " field is editable and " + name.getLabelText() + " field allows to input alphanumeric characters");
        Assert.assertTrue(registerNewHotel.isNotPossibleToSaveHotelWithEmptyTextArea(fieldName, name));
        log.info(" It is not possible to save the empty " + name.getLabelText() + " field ");
        Assert.assertTrue(registerNewHotel.isItPossibleToSaveTextAreaWithValidData(fieldName));
        log.info("It is possible to save the valid " + name.getLabelText() + " field");


    }

    @Test(priority = 9, dataProvider = "selectNotes", dataProviderClass = DataProviders.class)
    public void verifyThatUserCanAddNotesToNewHotel(LabelsName name, EditFieldsName fieldName) {
        RegisterNewHotel registerNewHotel = loadRegisterNewHotelPage().gotoRegisterNewHotel();
        Assert.assertTrue(registerNewHotel.isFieldDisplayed(name));
        log.info(name.getLabelText() + " field is displayed in Data section ");
        Assert.assertTrue(registerNewHotel.isTextAreaEditable(fieldName));
        log.info(name.getLabelText() + " field is editable and " + name.getLabelText() + " field allows to input alphanumeric characters");
        Assert.assertTrue(registerNewHotel.isPossibleToSaveHotelWithEmptyTextArea(fieldName, name));
        log.info(" It is possible to save the empty " + name.getLabelText() + " field ");
        Assert.assertTrue(registerNewHotel.isItPossibleToSaveTextAreaWithValidData(fieldName));
        log.info("It is possible to save the valid " + name.getLabelText() + " field");

    }


}
