package com.example.application.views.weatherapp;

import java.awt.Color;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.example.application.MyIconsFeather;
import com.example.application.views.MainLayout;
import com.example.application.views.weatherapp.WeatherForecast.ForecastDay;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.OrderedList;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.Background;
import com.vaadin.flow.theme.lumo.LumoUtility.BorderRadius;
import com.vaadin.flow.theme.lumo.LumoUtility.BoxShadow;
import com.vaadin.flow.theme.lumo.LumoUtility.Display;
import com.vaadin.flow.theme.lumo.LumoUtility.FlexDirection;
import com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import com.vaadin.flow.theme.lumo.LumoUtility.FontWeight;
import com.vaadin.flow.theme.lumo.LumoUtility.JustifyContent;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.Overflow;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import com.vaadin.flow.theme.lumo.LumoUtility.TextColor;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import com.vaadin.flow.theme.lumo.LumoUtility.Position;
import com.vaadin.flow.theme.lumo.LumoUtility.Width;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Weather App")
@Route(value = "weather", layout = MainLayout.class)
public class WeatherCard extends Main{
    private OrderedList imageList;
    private WeatherData weatherData;
    private WeatherForecast weatherForecast;

    public WeatherCard(){
        WeatherProxy weatherProxy = new WeatherProxy("Cebu");
        weatherData = weatherProxy.getWeatherData();
        weatherForecast = weatherProxy.getWeatherForecast();

        LoadUI();
    }

    private void LoadUI(){
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d MMM yyyy");
        String formattedDate = currentDate.format(dateFormatter);

        UI.getCurrent().getPage().addJsModule("https://unpkg.com/feather-icons");

        addClassNames(Display.FLEX, FlexDirection.COLUMN, AlignItems.CENTER, Margin.LARGE);
                
        Div container = new Div();
        container.addClassName("weather-card");
        container.addClassNames(Display.FLEX, AlignItems.START, JustifyContent.START,
                Margin.Bottom.MEDIUM, Overflow.HIDDEN, BorderRadius.LARGE, Width.FULL);
        container.setHeight("400px");
        container.setWidth("675px");

            Div weatherSide = new Div();
            weatherSide.addClassName("weather-side");
            weatherSide.addClassNames(Background.CONTRAST_50, AlignItems.START, JustifyContent.START, Position.RELATIVE);

                Image image = new Image();
                image.setHeight("100%");
                image.setSrc("https://images.unsplash.com/photo-1519681393784-d120267933ba?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80");
                image.setAlt("no img");

                Div weatherGradient = new Div();
                weatherGradient.addClassName("weather-gradient");

                Div dateContainer = new Div();
                dateContainer.addClassName("date-container");

                    H2 dateDayName = new H2(currentDate.getDayOfWeek().toString());
                    dateDayName.addClassName("date-dayname");

                    Span dateDay = new Span(formattedDate);
                    dateDay.addClassName("date-day");

                    Icon locationIcon = MyIconsFeather.MAP_PIN.create();
                    locationIcon.setSize("15px");
                    locationIcon.addClassName("location-icon");

                    String locationName = weatherData.getLocation().getName();
                    String countryName = weatherData.getLocation().getCountry(); 
                    String locDisplay = locationName + ", " + countryName;
                    Span locationSpan = new Span(locDisplay);
                    locationSpan.addClassName("location");

                dateContainer.add(dateDayName, dateDay, locationIcon, locationSpan);
    
                Div weatherContainer = new Div();
                weatherContainer.addClassName("weather-container");

                    Icon weatherIcon = MyIconsFeather.SUN.create();
                    weatherIcon.setSize("60px");
                    weatherIcon.addClassName("weather-icon");

                    H1 weatherTemp = new H1(String.valueOf((int)Math.round(weatherData.getCurrent().getTemperatureCelsius())) + "°C");
                    weatherTemp.addClassName("weather-temp");

                    H3 weatherDesc = new H3(weatherData.getCurrent().getCondition().getText());
                    weatherDesc.addClassName("weather-desc");

                weatherContainer.add(weatherIcon, weatherTemp, weatherDesc);

            weatherSide.add(image, weatherGradient, dateContainer, weatherContainer);
            
            Div infoSide = new Div();
            infoSide.addClassName("info-side");

                Div todayInfoContainer = new Div();
                todayInfoContainer.addClassName("today-info-container");

                    Div todayInfo = new Div();
                    todayInfo.addClassName("today-info");

                        Div precipitation = new Div();
                        precipitation.addClassName("precipitation");

                            Span precipitationTitle = new Span("PRECIPITATION");
                            precipitationTitle.addClassName("title");

                            Span precipitationValue = new Span(weatherForecast.getForecast().getForecastday().get(0).getDay().getPrecipitation() + "%");
                            precipitationValue.addClassName("value");

                        precipitation.add(precipitationTitle, precipitationValue);

                        Div humidity = new Div();
                        humidity.addClassName("humidity");

                            Span humidityTitle = new Span("HUMIDITY");
                            humidityTitle.addClassName("title");

                            Span humidityValue = new Span((int)weatherForecast.getForecast().getForecastday().get(0).getDay().getAvgHumidity() + "%");
                            humidityValue.addClassName("value");

                        humidity.add(humidityTitle, humidityValue);    

                        Div wind = new Div();
                        wind.addClassName("wind");

                            Span windTitle = new Span("WIND");
                            windTitle.addClassName("title");

                            Span windValue = new Span("0 km/h");
                            windValue.addClassName("value");

                        wind.add(windTitle, windValue);   
                    
                    todayInfo.add(precipitation, humidity, wind);

                Div weekContainer = new Div();
                weekContainer.addClassName("week-container");

                    Span forecast = new Span("Forecast");
                    forecast.addClassName("title");

                    UnorderedList weekList = weekList();

                weekContainer.add(forecast, weekList);

            infoSide.add(todayInfo, weekContainer);

        container.add(weatherSide, infoSide);
        add(container);
    }

    private UnorderedList weekList(){
        LocalDate currentDate = LocalDate.now();
        int daysOffset = 0;
        UnorderedList weekList = new UnorderedList();
        for (ForecastDay forecastDay : weatherForecast.getForecast().getForecastday()) {
            ListItem listItem = new ListItem();

            Icon dayIcon = MyIconsFeather.SUN.create();
            dayIcon.addClassName("day-icon");

            Span dayName = new Span(currentDate.plusDays(daysOffset++).getDayOfWeek().toString().substring(0, 3));
            dayName.addClassName("day-name");

            Span dayTemp = new Span((int)Math.round(forecastDay.getDay().getAvgtempC()) + "°C");
            dayTemp.addClassName("day-temp");

            listItem.add(dayIcon, dayName, dayTemp);

            weekList.add(listItem);
            weekList.addClassName("week-list");
        }
        return weekList;
    }
}
