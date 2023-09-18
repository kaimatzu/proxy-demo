package com.example.application.views.weatherapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.lang3.ObjectUtils.Null;

import java.lang.reflect.Field;

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
            String apiUrl = "http://api.weatherapi.com/v1/forecast.json?key=" + apiKey + "&q=" + location + "&days=4&aqi=no&alerts=no";

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
            WeatherForecastList weatherForecastList = objectMapper.readValue(responseBuilder.toString(), WeatherForecastList.class);
            
            // Get the class object for MyClass
            Class<?> cls1 = weatherData.getClass();
            printPropertiesAndValues(weatherData, cls1);
            System.out.print("________________________________________\n");
            // for(WeatherForecastData forecast : weatherForecastList.getData()){
            //     printPropertiesAndValues(forecast, forecast.getClass());
            // }
            Class<?> cls2 = weatherForecastList.getClass();
            printPropertiesAndValues(weatherForecastList, cls2);
            for(ForecastDay forecastDay : weatherForecastList.getForecast().getForecastday()){
                System.out.print(forecastDay.getDate() + " | " + forecastDay.getDay().getAvgtempC() +  " | " + forecastDay.getDay().getCondition().getText() + "\n");
            }

            System.out.print("________________________________________");

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

    public WeatherData getWeatherData() {
        return this.weatherData;
    }

    private static void printPropertiesAndValues(Object obj, Class<?> cls) {
        Field[] fields = cls.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = field.getName();
            try {
                Object value = field.get(obj);

                if (value != null) {
                    if (field.getType().isPrimitive() || field.getType().equals(String.class)) {
                        // Print primitive types or strings
                        System.out.println("Property name: " + fieldName + ", Value: " + value);
                    } else {
                        // If the property is an object, recursively print its properties
                        System.out.println("Property name: " + fieldName);
                        printPropertiesAndValues(value, field.getType());
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}