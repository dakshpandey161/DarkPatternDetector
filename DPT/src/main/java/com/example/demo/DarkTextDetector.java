package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class DarkTextDetector {
    public boolean detect(String content) {
        return content.toLowerCase().contains("buy now") ||
               content.toLowerCase().contains("limited time");
    }
}
