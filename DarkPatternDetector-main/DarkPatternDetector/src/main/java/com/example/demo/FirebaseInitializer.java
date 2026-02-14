package com.example.demo;

import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Configuration
public class FirebaseInitializer {

    @PostConstruct
    public void initialize() {
        try {
            InputStream serviceAccount =
                getClass().getClassLoader().getResourceAsStream("serviceAccountKey.json");

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("fIRE_BASE_DATABASE_URL")
                    .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
                System.out.println("✅ Firebase initialized successfully");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("❌ Failed to initialize Firebase");
        }
    }
}
