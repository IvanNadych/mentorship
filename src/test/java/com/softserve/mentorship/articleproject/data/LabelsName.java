package com.softserve.mentorship.articleproject.data;

public enum LabelsName {
    LABEL_NAME("name","Name:"),
    LABEL_RATING("rate","Global Rating"),
    LABEL_DATE_CONSTRUCTION("dateOfConstruction_input","Date of Construction:"),
    LABEL_COUNTRY("country_input","Country:"),
    LABEL_CITY("city_input","City:"),
    LABEL_SHORT_DESCRIPTION("short_description","Short Description:"),
    LABEL_DESCRIPTION("description","Description:"),
    LABEL_NOTES("notes","Notes");


    private String nameLabel;
    private String labelText;

    LabelsName(String nameLabel, String labelText){
        this.nameLabel=nameLabel;
        this.labelText = labelText;


    }

    public String getNameLabel() {
        return nameLabel;
    }

    public String getLabelText() {
        return labelText;
    }
}
