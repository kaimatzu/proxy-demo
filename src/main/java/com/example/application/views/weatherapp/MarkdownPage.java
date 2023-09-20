package com.example.application.views.weatherapp;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.Div;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class MarkdownPage extends Div {
    public MarkdownPage() {
        // Read the content of markdown.html and set it as innerHTML
        String htmlContent = readMarkdownFile("markdown.html");
        System.out.println(getRelativePath("markdown.html"));
        // Create an Html component and set its innerHTML to the HTML content
        Html html = new Html(htmlContent);

        // Add the Html component to your layout
        add(html);

        // Apply CSS styling to the HTML content (optional)
        html.getStyle().set("padding", "20px");

        // Set a CSS class for styling (optional)
        html.getElement().getClassList().add("markdown-content");

        
        // Set the size of the Div
        setSizeFull();
    }

    private String getRelativePath(String fileName) {
        URL resourceUrl = MarkdownPage.class.getResource(fileName);
    
        if (resourceUrl != null) {
            // Convert the URL to a file path
            return resourceUrl.getPath();
        } else {
            // Handle the case where the file is not found
            return null;
        }
    }

    private String readMarkdownFile(String fileName) {
        try (InputStream inputStream = MarkdownPage.class.getResourceAsStream(fileName)) {
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
                    StringBuilder content = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        content.append(line).append("\n");
                    }
                    return content.toString();
                }
            } else {
                // Handle the case where the file is not found
                return "<p>Markdown file not found.</p>";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "<p>Error loading markdown content</p>";
        }
    }
}
