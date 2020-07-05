package com.softserve.mentorship.articleproject.data;

public enum CountryName {
    COUNTRY_NAME_USA("USA","USA"),
    COUNTRY_NAME_UK("UK","UK"),
    COUNTRY_NAME_UKRAINE("Ukraine","Ukraine"),
    CITY_NAME_USA_DALLAS("Dallas","Dallas"),
    CITY_NAME_UK_LONDON("London","London"),
    CITY_NAME_UKRAINE_KYIV("Kyiv","Kyiv");


    private String countryName;
    private String dataLabel;

    CountryName(String countryName, String dataLabel) {
        this.countryName = countryName;
        this.dataLabel = dataLabel;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getDataLabel() {
        return dataLabel;
    }
}
