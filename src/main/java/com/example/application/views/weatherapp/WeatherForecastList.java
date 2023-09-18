package com.example.application.views.weatherapp;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecastList {
    @JsonProperty("forecast")
    private Forecast forecast;

    public Forecast getForecast() {
        return forecast;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Forecast {
    @JsonProperty("forecastday")
    private List<ForecastDay> forecastday;

    public List<ForecastDay> getForecastday() {
        return forecastday;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class ForecastDay {
    private String date;
    private Day day;

    public String getDate() {
        return date;
    }

    public Day getDay() {
        return day;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Day {
    @JsonProperty("avgtemp_c")
    private double avgtempC;
    private Condition condition;

    public double getAvgtempC() {
        return avgtempC;
    }

    @JsonProperty("condition")
    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Condition {
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
