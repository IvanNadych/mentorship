package com.softserve.mentorship.autoria.testdata;

public enum Sorting {
    DESC("price.desc"),
    ASC("price.asc");


    //
    private String attributeName;

    Sorting(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeName() {
        return attributeName;
    }
}
