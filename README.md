# 🌍 Moroccan Darija Translator API (Gemini-Powered)

A production-ready Jakarta EE REST API that leverages Google's Gemini AI to translate text into Moroccan Darija.

## 📂 Project Structure

src/
└── main/
  └── java/
    └── rest/
      └── project/
        └── jakarta/
          └── hello/
            ├── Message.java # Data model
            ├── Translate.java # Core translation logic
            └── TranslateApplication.java # REST config


## ✨ Features
- **AI-Powered Translation**  
  Uses Gemini 1.5 Pro for accurate Darija translations
- **RESTful Endpoint**  
  `POST /rest/translate/test` with JSON payload
- **Secure**  
  JSON-B serialization with `@JsonbTransient` for sensitive data

## 🛠️ Tech Stack
| Component       | Technology                          |
|-----------------|-------------------------------------|
| Framework       | Jakarta EE 10                       |
| AI Integration  | Gemini API (Gemini 1.5 Pro)         |
| JSON Processing | Jakarta JSON-B + `org.json`         |
| Build Tool      | Maven                               |

## ⚙️ Setup Guide

### Prerequisites
- Java 17+
- [Gemini API Key](https://ai.google.dev/)
- Jakarta EE 10 Server (Payara/TomEE/GlassFish)

### 1. Clone & Configure
```bash
git clone https://github.com/yourusername/moroccan-translator.git
mvn clean package
```
## 📦 Key Dependencies (`pom.xml`)

```xml
<!-- Gemini Integration -->
<dependency>
    <groupId>swiss.ameri</groupId>
    <artifactId>gemini-api</artifactId>
    <version>1beta.0.2.3</version>
</dependency>

<!-- Jakarta EE Core -->
<dependency>
    <groupId>jakarta.platform</groupId>
    <artifactId>jakarta.jakartaee-api</artifactId>
    <version>10.0.0</version>
    <scope>provided</scope>
</dependency>

<!-- JSON Processing -->
<dependency>
    <groupId>org.json</groupId>
    <artifactId>json</artifactId>
    <version>20240303</version>
</dependency>
```

## 🙏 Acknowledgments
Java library to access the gemini API : https://mvnrepository.com/artifact/swiss.ameri/gemini-api

