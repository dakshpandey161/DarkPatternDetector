package com.example.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UIDetector {

    @Value("${webdriver.chrome.driver}")
    private String chromeDriverPath;

    // Optionally, if you want this method to analyze a URL inside UIDetector
    public void analyze(String url) {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu", "--no-sandbox");

        WebDriver driver = new ChromeDriver(options);
        try {
            driver.get(url);
            analyzePageContent(driver.getPageSource());
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    // Remove @Component here; this is a method, not a class
    public boolean detectUI(String html) {
        // Your detection logic here
        return false; // stub implementation
    }

    public void analyzePageContent(String html) {
        System.out.println("HTML content received. Length: " + html.length());
    }
}
