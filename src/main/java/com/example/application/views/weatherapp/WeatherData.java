package com.example.application.views.weatherapp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherData {
    private Location location;
    private Current current;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
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

        public void setName(String name) {
            this.name = name;
        }

        @JsonProperty("region")
        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        @JsonProperty("country")
        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        @JsonProperty("lat")
        public double getLat() {
            return lat;
        }
    
        public void setLat(double lat) {
            this.lat = lat;
        }
    
        @JsonProperty("lon")
        public double getLon() {
            return lon;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Current {
        @JsonProperty("temp_c")
        private double temperatureCelsius;
        private Condition condition;

        @JsonProperty("temp_c")
        public double getTemperatureCelsius() {
            return temperatureCelsius;
        }

        public void setTemperatureCelsius(double temperatureCelsius) {
            this.temperatureCelsius = temperatureCelsius;
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
    public static class Condition {
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
