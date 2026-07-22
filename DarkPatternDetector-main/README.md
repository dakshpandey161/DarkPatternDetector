# 🛡 Dark Pattern Detection System (DPD)

An AI-powered automated web crawler that detects deceptive UI/UX dark patterns across live websites using a hybrid rule-based and AI classification pipeline.

---

## 🎥 Demo Video

[![Watch the Demo](https://img.youtube.com/vi/FHv1E-a-Dqs/hqdefault.jpg)](https://www.youtube.com/watch?v=FHv1E-a-Dqs)

---

## 📄 Research Paper

This system is grounded in research on AI-generated and AI-amplified dark patterns.

📖 Read the full paper on SSRN:


https://papers.ssrn.com/sol3/papers.cfm?abstract_id=6079910

---

## 🚀 Overview

The Dark Pattern Detection System (DPD) is a Spring Boot–based backend application that:

- Crawls live websites using Selenium WebDriver  
- Extracts textual and UI signals  
- Sends new pattern candidates to the Gemini API for classification  
- Stores previously detected patterns in Firebase  
- Reuses cached results to reduce redundant AI calls  

The system identifies deceptive UX patterns such as:

- Forced continuity  
- Scarcity messaging  
- Misleading consent flows  
- Preselected options  
- Urgency manipulation  

---

## 🏗 System Architecture

WebCrawler  
↓  
Content Extraction (Text + UI)  
↓  
Gemini AI Classification  
↓  
Firebase Storage  
↓  
Pattern Reuse & Optimization  

---

## 🧠 Detection Pipeline

1. The crawler visits predefined seed URLs.  
2. Visible page content and UI elements are extracted.  
3. If content matches a known pattern, it is flagged immediately.  
4. If new, the content is sent to Gemini for AI classification.  
5. Confirmed patterns are stored in Firebase.  
6. Future detections reuse stored knowledge to improve efficiency.  

This architecture reduces redundant API calls while continuously expanding the internal detection library.

---

## 📦 Installation & Setup

### Clone the Repository

git clone https://github.com/dakshpandey161/DarkPatternDetector/blob/main/DarkPatternDetector-main
cd DarkPatternDetector

### Set Gemini API Key (Environment Variable)

Windows:

setx GEMINI_API_KEY "your_api_key_here"

Restart the terminal after setting the variable.

### Build the Project

mvn clean install

### Run the Application

mvn spring-boot:run

---

## ⚙ Configuration

- Seed URLs can be modified inside `WebCrawler.java`
- Firebase credentials must be placed in:

src/main/resources/ServiceAccountKey.json

---

## 📊 Output

Detected patterns are:

- Logged in the console  
- Stored in Firebase  
- Available for reuse in future crawls  

---

## 🛠 Technology Stack

- Java 17+  
- Spring Boot 3  
- Selenium 4  
- Firebase Admin SDK  
- Gemini API  
- OkHttp  
- Maven  

---

## 🎯 Objective

To build a scalable AI-assisted system capable of identifying deceptive digital design practices and contributing toward more transparent and ethical user experiences.
