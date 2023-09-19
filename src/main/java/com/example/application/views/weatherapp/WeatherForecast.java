package com.example.application.views.weatherapp;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecast {
    @JsonProperty("forecast")
    private Forecast forecast;

    public Forecast getForecast() {
        return forecast;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Forecast {
        @JsonProperty("forecastday")
        private List<ForecastDay> forecastday;

        public List<ForecastDay> getForecastday() {
            return forecastday;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ForecastDay {
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
    public static class Day {
        private double avgtempC;
        private int precipitation;
        private double avgHumidity;
        private double maxWindKph;
        private Condition condition;

        @JsonProperty("avgtemp_c")
        public double getAvgtempC() {
            return avgtempC;
        }

        @JsonProperty("daily_chance_of_rain")
        public int getPrecipitation() {
            return precipitation;
        }

        @JsonProperty("avghumidity")
        public double getAvgHumidity() {
            return this.avgHumidity;
        }

        @JsonProperty("maxwind_kph")
        public double getMaxWindKph() {
            return this.maxWindKph;
        }

        @JsonProperty("condition")
        public Condition getCondition() {
            return condition;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Condition {
        private String text;
        private int code;

        @JsonProperty("text")
        public String getText() {
            return text;
        }

        @JsonProperty("code")
        public int getCode() {
            return code;
        }
    }
}
