package com.diyandroid.tourguideapp;

public class ListPlaces {
    private String name;
    private int resourseId;

    ListPlaces(String name, int resourseId) {
        this.name = name;
        this.resourseId = resourseId;
    }

    public String getName() {
        return name;
    }

    public int getResourseId() {
        return resourseId;
    }

}
