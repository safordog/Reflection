package com.gmail.safordog;

import java.io.Serializable;

public class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    @Save
    private String brand = "Volvo";
    private String type = "sedan";
    @Save
    private Engine engine;
    @Save
    private int year = 2015;
    private String color = "white";

    public Car() {
    }

    public Car(String brand, String type, Engine engine, int year, String color) {
        this.brand = brand;
        this.type = type;
        this.engine = engine;
        this.year = year;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
