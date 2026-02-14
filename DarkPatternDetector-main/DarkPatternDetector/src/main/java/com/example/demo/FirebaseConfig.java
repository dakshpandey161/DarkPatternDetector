package com.example.demo;

import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Configuration
public class FirebaseConfig {

    @PostConstruct
    @SuppressWarnings({"UseSpecificCatch", "CallToPrintStackTrace"})
    public void init() {
        try {
            InputStream serviceAccount =
                    getClass().getClassLoader().getResourceAsStream("serviceAccountKey.json");

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://darkpatterndetector-6113a.firebaseio.com/")
                    .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
                System.out.println("✅ Firebase Initialized");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("❌ Failed to initialize Firebase");
        }
    }
}
