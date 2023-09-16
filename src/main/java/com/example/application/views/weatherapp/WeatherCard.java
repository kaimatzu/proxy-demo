package com.example.application.views.weatherapp;

import java.awt.Color;

import com.example.application.MyIconsFeather;
import com.example.application.views.MainLayout;
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
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
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

    public WeatherCard(){
        UI.getCurrent().getPage().addJsModule("https://unpkg.com/feather-icons");

        addClassNames(Display.FLEX, FlexDirection.COLUMN, AlignItems.CENTER, Margin.LARGE);
                
        Div container = new Div();
        container.addClassName("weather-card");
        container.addClassNames(Display.FLEX, AlignItems.START, JustifyContent.START,
                Margin.Bottom.MEDIUM, Overflow.HIDDEN, BorderRadius.LARGE, Width.FULL);
        container.setHeight("400px");
        container.setWidth("600px");

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

                    H2 dateDayName = new H2("Tuesday");
                    dateDayName.addClassName("date-dayname");

                    Span dateDay = new Span("15 Jan 2019");
                    dateDay.addClassName("date-day");

                    Icon locationIcon = MyIconsFeather.MAP_PIN.create();
                    locationIcon.setSize("15px");
                    locationIcon.addClassName("location-icon");

                    Span locationSpan = new Span("Toledo, Cebu");
                    locationSpan.addClassName("location");

                dateContainer.add(dateDayName, dateDay, locationIcon, locationSpan);
    
                Div weatherContainer = new Div();
                weatherContainer.addClassName("weather-container");

                    Icon weatherIcon = MyIconsFeather.SUN.create();
                    weatherIcon.setSize("60px");
                    weatherIcon.addClassName("weather-icon");

                    H1 weatherTemp = new H1("29°C");
                    weatherTemp.addClassName("weather-temp");

                    H3 weatherDesc = new H3("Sunny");
                    weatherDesc.addClassName("weather-desc");

                weatherContainer.add(weatherIcon, weatherTemp, weatherDesc);

            weatherSide.add(image, weatherGradient, dateContainer, weatherContainer);
            
        container.add(weatherSide);
        add(container);
    }
}
