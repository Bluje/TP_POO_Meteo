package com.example.tp5.request;

public class MeteoData {
    private int day;
    private int tmin;
    private int tmax;
    private int weather;
    private int probrain;

    public MeteoData() {
    }

    public int getProbrain() {
        return probrain;
    }

    public void setProbrain(int probrain) {
        this.probrain = probrain;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getTmin() {
        return tmin;
    }

    public void setTmin(int tmin) {
        this.tmin = tmin;
    }

    public int getTmax() {
        return tmax;
    }

    public void setTmax(int tmax) {
        this.tmax = tmax;
    }

    public int getWeather() {return weather;}

    public void getWeather(int weather) {
        this.weather = weather;
    }

}
