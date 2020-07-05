package com.softserve.mentorship.articleproject.data;

public enum  EditFieldsName {
    EDIT_FIELD_NAME("name"),
    EDIT_FIELD_DATE_CONSTRUCTION("dateOfConstruction_input"),
    EDIT_FIELD_COUNTRY("country_focus"),
    EDIT_FIELD_CITY("city_focus"),
    EDIT_FIELD_SHORT_DESCRIPTION("short_description"),
    EDIT_FIELD_DESCRIPTION("description"),
    EDIT_FIELD_NOTES("notes"),

    EDIT_FIELD_COUNTRY_LABEL("country_label"),
    EDIT_FIELD_CITY_LABEL("city_label");

    private String fieldName;

    EditFieldsName(String fieldName){
        this.fieldName=fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
