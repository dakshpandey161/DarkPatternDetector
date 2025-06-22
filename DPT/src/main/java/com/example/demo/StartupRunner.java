package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {

    @Autowired
    private WebCrawler webCrawler;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("🟢 Application started... beginning web crawling.");
        webCrawler.crawlAll();
        System.out.println("✅ Crawling finished.");
    }
}
