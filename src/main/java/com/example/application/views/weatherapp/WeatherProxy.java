package com.example.application.views.weatherapp;

import java.util.HashMap;
import java.util.Map;

class WeatherProxy {
    private WeatherService weatherService;
    private Map<String, WeatherData> cacheData;
    private Map<String, WeatherForecast> cacheForecast;
    private String location;

    public WeatherProxy(String location) {
        this.weatherService = new WeatherService("81caee637d1843918aa43838231609", location);
        this.location = location;
        this.cacheData = new HashMap<>();
        this.cacheForecast = new HashMap<>();
    }

    public WeatherData getWeatherData() {
        // Check if weather data for the location is cached locally
        // If not, fetch it from the remote WeatherService
        if (!isCachedWeatherData(this.location)) {
            cacheWeatherData(this.location);
        }

        return getCachedWeatherData(this.location);
    }

    public WeatherData getWeatherData(String location) {
        // Change the location if a new one is provided
        if (!location.equals(this.location)) {
            this.location = location;
        }
        // Check if weather data for the location is cached locally
        // If not, fetch it from the remote WeatherService
        if (!isCachedWeatherData(location)) {
            cacheWeatherData(location);
        }

        return getCachedWeatherData(location);
    }

    public WeatherForecast getWeatherForecast() {
        // Check if weather data for the location is cached locally
        // If not, fetch it from the remote WeatherService
        if (!isCachedWeatherForecast(this.location)) {
            cacheWeatherForecast(this.location);
        }

        return getCachedWeatherForecast(this.location);
    }

    public WeatherForecast getWeatherForecast(String location) {
        // Change the location if a new one is provided
        if (!location.equals(this.location)) {
            this.location = location;
        }
        // Check if weather data for the location is cached locally
        // If not, fetch it from the remote WeatherService
        if (!isCachedWeatherForecast(location)) {
            cacheWeatherForecast(location);
        }

        return getCachedWeatherForecast(location);
    }

    private boolean isCachedWeatherData(String location) {
        // Check if weather data for the location is cached
        return cacheData.containsKey(location);
    }

    private boolean isCachedWeatherForecast(String location) {
        // Check if weather data for the location is cached
        return cacheForecast.containsKey(location);
    }

    private void cacheWeatherData(String location) {
        // Fetch weather data from the remote service and cache it
        WeatherData weatherData = weatherService.getWeatherData();
        
        cacheData.put(location, weatherData);
    }

    private void cacheWeatherForecast(String location) {
        // Fetch weather data from the remote service and cache it
        WeatherForecast weatherForecast = weatherService.getWeatherForecast();
        
        cacheForecast.put(location, weatherForecast);
    }

    private WeatherData getCachedWeatherData(String location) {
        // Retrieve weather data from the cache
        return cacheData.get(location);
    }

    private WeatherForecast getCachedWeatherForecast(String location) {
        // Retrieve weather data from the cache
        return cacheForecast.get(location);
    }

    public void clearCache() {
        // Clear the cache if needed
        cacheData.clear();
        cacheForecast.clear();
    }
}