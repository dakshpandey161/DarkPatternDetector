package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DarkPatternApplication implements CommandLineRunner {

    @Autowired
    private FirebaseService firebaseService;

    @Autowired
    private UIDetector uiDetector;

    @Autowired
    private WebCrawler webCrawler;

    @Autowired
    private DarkTextDetector textDetector;

    @Override
    public void run(String... args) {
        // Initialize Firebase
        System.out.println("✅ Firebase initialized.");

        // Run dark text detection
        String sampleText = "Hurry! Limited time offer, buy now!";
        boolean hasDarkPattern = textDetector.detect(sampleText);
        System.out.println("🧠 Text Detection Result: " + hasDarkPattern);

        // Analyze UI
        uiDetector.analyze("https://example.com");
        System.out.println("🖥️ UI analysis started.");

        // Run crawler
        webCrawler.crawl("https://example.com");
        System.out.println("🌐 Web crawling complete.");
    }
}
