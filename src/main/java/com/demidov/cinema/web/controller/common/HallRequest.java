package com.demidov.cinema.web.controller.common;

public class HallRequest {
    private String name;
    private Integer hallNumber;
    private Integer[][] places;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(Integer hallNumber) {
        this.hallNumber = hallNumber;
    }

    public Integer[][] getPlaces() {
        return places;
    }

    public void setPlaces(Integer[][] places) {
        this.places = places;
    }
}
