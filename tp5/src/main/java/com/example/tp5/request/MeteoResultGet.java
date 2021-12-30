package com.example.tp5.request;

public class MeteoResultGet {
    private MeteoData forecast[];

    public MeteoResultGet() {
    }

    public MeteoData[] getForecast() {
        return forecast;
    }

    public void setForecast(MeteoData forecast[]) {
        this.forecast = forecast;
    }

}
