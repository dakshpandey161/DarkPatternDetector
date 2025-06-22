package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DarkPatternController {

    private final FirebaseService firebaseService;
    private final DarkTextDetector textDetector;
    private final UIDetector uiDetector;

    public DarkPatternController(FirebaseService firebaseService,
                                 DarkTextDetector textDetector,
                                 UIDetector uiDetector) {
        this.firebaseService = firebaseService;
        this.textDetector = textDetector;
        this.uiDetector = uiDetector;
    }

    @PostMapping("/detect-text")
    public ResponseEntity<String> detectText(@RequestBody String text) {
        if (textDetector.detect(text)) {
            firebaseService.saveDetectionResult("TEXT", text, "HIGH");
            return ResponseEntity.ok("Dark pattern detected");
        }
        return ResponseEntity.ok("No dark patterns found");
    }

    @GetMapping("/analyze-page")
    public ResponseEntity<String> analyzePage(@RequestParam String url) {
        uiDetector.analyze(url);
        return ResponseEntity.ok("Analysis started for: " + url);
    }
}
