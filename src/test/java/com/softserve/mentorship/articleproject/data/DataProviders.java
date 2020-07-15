package com.softserve.mentorship.articleproject.data;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider
    public Object[][] selectNameLabel() {
        return new Object[][]{
                {LabelsName.LABEL_NAME, EditFieldsName.EDIT_FIELD_NAME},

        };
    }

    @DataProvider
    public Object[][] selectRateLabel() {
        return new Object[][]{
                {LabelsName.LABEL_RATING},

        };
    }

    @DataProvider
    public Object[][] selectDateConstruction() {
        return new Object[][]{
                {LabelsName.LABEL_DATE_CONSTRUCTION, EditFieldsName.EDIT_FIELD_DATE_CONSTRUCTION},

        };
    }

    @DataProvider
    public Object[][] selectCountry() {
        return new Object[][]{
                {LabelsName.LABEL_COUNTRY, EditFieldsName.EDIT_FIELD_COUNTRY,
                        CountryName.COUNTRY_NAME_USA, CountryName.COUNTRY_NAME_UK,
                        CountryName.COUNTRY_NAME_UKRAINE, EditFieldsName.EDIT_FIELD_COUNTRY_LABEL},

        };
    }

    @DataProvider
    public Object[][] selectCity() {
        return new Object[][]{
                {LabelsName.LABEL_CITY, EditFieldsName.EDIT_FIELD_CITY,
                        EditFieldsName.EDIT_FIELD_COUNTRY_LABEL, CountryName.COUNTRY_NAME_UKRAINE,
                        EditFieldsName.EDIT_FIELD_CITY_LABEL, CountryName.CITY_NAME_UKRAINE_KYIV,
                        CountryName.COUNTRY_NAME_USA, CountryName.CITY_NAME_USA_DALLAS,
                        CountryName.COUNTRY_NAME_UK, CountryName.CITY_NAME_UK_LONDON,
                },

        };
    }

    @DataProvider
    public Object[][] selectShortDescription() {
        return new Object[][]{
                {LabelsName.LABEL_SHORT_DESCRIPTION, EditFieldsName.EDIT_FIELD_SHORT_DESCRIPTION},

        };
    }
    @DataProvider
    public Object[][] selectDescription() {
        return new Object[][]{
                {LabelsName.LABEL_DESCRIPTION, EditFieldsName.EDIT_FIELD_DESCRIPTION},

        };
    }
    @DataProvider
    public Object[][] selectNotes() {
        return new Object[][]{
                {LabelsName.LABEL_NOTES, EditFieldsName.EDIT_FIELD_NOTES},

        };
    }
}
