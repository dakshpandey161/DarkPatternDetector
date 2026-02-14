package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")  // Prevents this from running during tests
@Component
public class StartupRunner implements CommandLineRunner {

    private final WebCrawler webCrawler;

    @Autowired
    public StartupRunner(WebCrawler webCrawler) {
        this.webCrawler = webCrawler;
    }

    @Override
    public void run(String... args) {
        System.out.println("🟢 Application started... beginning web crawling.");
        webCrawler.crawlAll();
        System.out.println("✅ Crawling finished.");
    }
}
