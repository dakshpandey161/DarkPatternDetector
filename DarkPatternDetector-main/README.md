# Dark Pattern Detector 🕵️‍♂️

A Java-based automated system for detecting **dark and deceptive patterns** on websites using web crawling, AI-assisted classification, and a self-learning pattern library.

This project is designed for **research, auditing, and large-scale analysis** of manipulative UI/UX practices on the web.

---

## 🚀 Overview

The Dark Pattern Detector crawls websites, analyzes textual and UI elements, and identifies dark patterns such as:
- Hidden costs
- Forced continuity
- Fake urgency
- Misleading language
- Preselected choices
- Obstructive UI patterns

The system is **adaptive**:
- On first encounter, a pattern is verified using **Gemini AI**
- Verified patterns are stored in an internal library
- Future encounters are **flagged automatically** without AI calls

---

## 🧠 System Architecture


---

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot**
- **Maven**
- **Selenium (Headless, optional)**
- **OkHttp**
- **Gemini AI (LLM-based verification)**
- **Firebase (pattern storage, later phase)**
- **Google Cloud (deployment, later phase)**

---

## 📂 Project Structure


---

## ⚙️ How It Works

1. **Crawl Initialization**
   - Seed URLs
   - Max depth
   - Domain constraints
   - Crawl session ID

2. **Page Analysis**
   - Text extraction
   - UI inspection (DOM, CSS, visibility, behavior)

3. **Detection Flow**
   - Check against learned pattern library
   - If unknown → consult Gemini AI
   - Store high-confidence patterns

4. **Self-Learning**
   - Known patterns are flagged instantly
   - Reduces AI dependency over time

---

## 🧪 Current Status

✅ Deterministic crawler  
✅ Config-driven crawl control  
✅ Text-based dark pattern detection  
🟡 UI-based detection (expanding)  
🟡 Local data collection  
🔜 Firebase integration  
🔜 Google Cloud deployment  
🔜 Selenium-based JS rendering  

---

## ▶️ Running the Project

Make sure you are in the directory containing `pom.xml`.

```bash
mvn spring-boot:run
java --version
# Java 17+

---

If you want, next I can:
- Tune this for **research paper / SSRN**
- Rewrite it for **GitHub stars**
- Add **architecture diagrams**
- Make a **CV-ready project description**

One step at a time.
