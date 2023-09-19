package com.example.application.views.weatherapp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherData {
    private Location location;
    private Current current;

    public Location getLocation() {
        return location;
    }

    public Current getCurrent() {
        return current;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Location {
        private String name;
        private String region;
        private String country;
        private double lat;
        private double lon;

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("region")
        public String getRegion() {
            return region;
        }

        @JsonProperty("country")
        public String getCountry() {
            return country;
        }

        @JsonProperty("lat")
        public double getLat() {
            return lat;
        }

        @JsonProperty("lon")
        public double getLon() {
            return lon;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Current {
        private double temperatureCelsius;
        private Condition condition;
        // private 
        @JsonProperty("temp_c")
        public double getTemperatureCelsius() {
            return temperatureCelsius;
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
