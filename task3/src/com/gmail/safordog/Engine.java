package com.gmail.safordog;

import java.io.Serializable;

public class Engine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Save
    private String type = "diesel";
    @Save
    private double capacity = 3.2;
    private int power = 240;

    public Engine() {
    }

    public Engine(String type, double capacity, int power) {
        this.type = type;
        this.capacity = capacity;
        this.power = power;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
