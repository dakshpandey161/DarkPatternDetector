package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/detect")
public class DetectionController {

    @Autowired
    private FirebaseService firebaseService;

    /**
     * Detects a potential dark pattern and logs it to Firebase.
     *
     * @param url         The URL where the pattern was detected.
     * @param patternType The type/category of dark pattern.
     * @return A confirmation message with the detection ID.
     */
    @PostMapping
    public String detect(@RequestParam String url, @RequestParam String patternType) {
        // Simulated detection logic
        boolean isDarkPattern = true;

        // Generate a unique detection ID
        String id = UUID.randomUUID().toString();

        // Save to Firebase
        firebaseService.saveDetectionResult(patternType, url, isDarkPattern ? "High" : "Low");

        return "✅ Logged detection to Firebase with ID: " + id;
    }
}
