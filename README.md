# Selenium Java Automation Framework

## 📌 Overview

This is a robust Selenium-based Test Automation Framework built using **Java**, **TestNG**, **Maven**, and **Allure Reports**. It supports scalable test automation with features like video recording, screenshot capture, custom reporting, data-driven testing, and Page Object Model (POM) design.

---

## 🚀 Features

- Page Object Model (POM) Design Pattern
- Selenium WebDriver for UI Testing
- TestNG for test orchestration
- Maven for dependency management
- WebDriverManager for automatic driver resolution
- Allure Reports for visual test reports
- Screenshots and video recording on failure
- Config management through `.properties` file
- Test data support via Excel and JSON
- Custom utility classes for reusable components

---

## 🧾 Project Structure

```
src/
├── main/
│   ├── java/com/ahmad/automation/
│   │   ├── base/
│   │   │   ├── BasePage.java
│   │   │   ├── BaseTest.java
│   │   │   └── WebDriverProvider.java
│   │   ├── config/
│   │   │   └── ConfigManager.java
│   │   ├── drivers/
│   │   │   └── DriverManager.java
│   │   ├── listeners/
│   │   │   └── TestListener.java
│   │   ├── pages/
│   │   │   └── LoginPage.java
│   │   └── utils/
│   │       ├── ExcelUtils.java
│   │       ├── JsonUtils.java
│   │       ├── ReportManager.java
│   │       ├── ScreenshotUtil.java
│   │       └── VideoRecorderUtil.java
│
├── test/
│   └── java/com/ahmad/automation/tests/
│       ├── LoginTests.java
│       └── EcommerceTests.java
│
resources/
├── config.properties
├── logback.xml
└── testdata.xlsx

reports/              # Allure reports
videos/               # Video recordings of failed tests
logs/                 # Execution logs
```

---

## 🛠 Prerequisites

- Java 17+
- Maven 3.8+
- Git
- Chrome browser (latest version)

---

## 🧪 Test Execution

Run tests via Maven:

```bash
mvn clean test
```

To generate and open Allure Report:

```bash
mvn allure:serve
```

---

## ✅ Test Scenarios

### The Internet HerokuApp

- Valid login
- Invalid login (wrong username/password)
- Empty field validation
- Logout verification

### Rahul Shetty Academy Practice Site

- Add items to cart
- Cart total validation
- Promo code application
- Order placement

---

## 📈 Reports and Logs

- **Allure Reports**: Visual logs and steps.
- **Screenshot**: Captured on failure.
- **Video**: Full session recording for each test.

---

## 👤 Author

**Ahmad Rauf**  
ISTQB Certified QA Automation Engineer  
[TopTal] (https://www.toptal.com/resume/ahmad-rauf)
[GitHub](https://github.com/AhmadRaufISTQB)
