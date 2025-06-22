package com.example.demo;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class FirebaseService {

    public FirebaseService() {
        initializeFirebase();
    }

    private void initializeFirebase() {
        try {
            FileInputStream serviceAccount = new FileInputStream("src/main/resources/serviceAccountKey.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://dpt161-628f0-default-rtdb.asia-southeast1.firebasedatabase.app/:")
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize Firebase", e);
        }
    }

    public void saveDetectionResult(String type, String content, String severity) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("detections");

        Map<String, Object> data = new HashMap<>();
        data.put("type", type);
        data.put("content", content);
        data.put("severity", severity);
        data.put("timestamp", System.currentTimeMillis());

        ref.push().setValueAsync(data);
    }
}
