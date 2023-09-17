package com.example.application.views.weatherapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.lang3.ObjectUtils.Null;

import com.example.application.views.weatherapp.WeatherData.Location;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WeatherService {
    private String apiKey;
    private String location;
    private WeatherData weatherData;

    public WeatherService(String apiKey, String location) {
        this.apiKey = apiKey;
        this.location = location;
        this.weatherData = fetchData();
    }

    private WeatherData fetchData() {
        try {
            // Create the URL for the API request
            String apiUrl = "http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + location + "&aqi=no";

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();

            // Set the request method to GET
            connection.setRequestMethod("GET");
            connection.connect();
            
            // Read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }
            reader.close();

            // Parse the JSON response using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            WeatherData weatherData = objectMapper.readValue(responseBuilder.toString(), WeatherData.class);
                 
            return weatherData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getLocation() {
        if (weatherData != null && weatherData.getLocation() != null) {
            return weatherData.getLocation().getName();
        } else {
            return "Location data not available";
        }
    }

    public double getTemperatureCelsius() {
        if (weatherData != null && weatherData.getCurrent() != null) {
            return weatherData.getCurrent().getTemperatureCelsius();
        } else {
            return 0.0; // Provide a default value or handle the absence of data appropriately
        }
    }

    public String getCondition() {
        if (weatherData != null && weatherData.getCurrent() != null && weatherData.getCurrent().getCondition() != null) {
            return weatherData.getCurrent().getCondition().getText();
        } else {
            return "Condition data not available";
        }
    }
}