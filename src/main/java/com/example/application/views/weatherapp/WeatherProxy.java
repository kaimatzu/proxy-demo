package com.example.application.views.weatherapp;

import java.util.HashMap;
import java.util.Map;

class WeatherProxy {
    private WeatherService weatherService;
    private Map<String, WeatherData> cache;
    private String location;

    public WeatherProxy(String location) {
        this.weatherService = new WeatherService("81caee637d1843918aa43838231609", location);
        this.location = location;
        this.cache = new HashMap<>();
    }

    public WeatherData getWeatherData(){
        // Check if weather data for the location is cached locally
        // If not, fetch it from the remote WeatherService
        if (!isCached(this.location)) {
            cacheWeatherData(this.location);
        }

        return getCachedData(this.location);
    }

    public WeatherData getWeatherData(String location) {
        // Change the location if a new one is provided
        if (!location.equals(this.location)) {
            this.location = location;
        }
        // Check if weather data for the location is cached locally
        // If not, fetch it from the remote WeatherService
        if (!isCached(location)) {
            cacheWeatherData(location);
        }

        return getCachedData(location);
    }

    private boolean isCached(String location) {
        // Check if weather data for the location is cached
        return cache.containsKey(location);
    }

    private void cacheWeatherData(String location) {
        // Fetch weather data from the remote service and cache it
        WeatherData weatherData = weatherService.getWeatherData();
        
        cache.put(location, weatherData);
    }

    private WeatherData getCachedData(String location) {
        // Retrieve weather data from the cache
        return cache.get(location);
    }

    public void clearCache() {
        // Clear the cache if needed
        cache.clear();
    }
}