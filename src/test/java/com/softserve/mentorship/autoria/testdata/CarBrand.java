package com.softserve.mentorship.autoria.testdata;

public enum CarBrand {
    BMW("BMW"),
    MERCEDES("Mercedes-Benz");


    //
    private String name;

    CarBrand(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }
}
