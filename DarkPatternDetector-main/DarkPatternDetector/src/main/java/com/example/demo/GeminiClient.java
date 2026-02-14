package com.example.demo;

import java.io.IOException;

import org.springframework.stereotype.Component;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Component
public class GeminiClient {

    private final OkHttpClient httpClient = new OkHttpClient();

    // Replace with actual Gemini API endpoint
    private static final String GEMINI_API_URL = "GEMINI_API_URL";

    // Replace with your actual Gemini API key
    private static final String API_KEY = "GEMINI_API_KEY";

    public boolean isDarkPattern(String content) {
        // Build JSON payload
        String jsonPayload = "{\"text\": \"" + escapeJson(content) + "\"}";

        RequestBody body = RequestBody.create(
                jsonPayload, MediaType.parse("application/json; charset=utf-8"));

        Request request = new Request.Builder()
                .url(GEMINI_API_URL)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .post(body)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                System.err.println("Gemini API call failed: " + response);
                return false;
            }

            String responseBody = response.body().string();
            System.out.println("Gemini response: " + responseBody);

            // Assuming response is like: { "darkPattern": true }
            return parseDarkPatternFromResponse(responseBody);

        } catch (IOException e) {
            System.err.println("Error calling Gemini API: " + e.getMessage());
            return false;
        }
    }

    private boolean parseDarkPatternFromResponse(String response) {
        // Simple parse for demo (use proper JSON parser like Jackson or Gson in real code)
        return response.contains("\"darkPattern\":true");
    }

    private String escapeJson(String text) {
        // Basic JSON escaping (replace quotes and backslashes)
        return text.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}
