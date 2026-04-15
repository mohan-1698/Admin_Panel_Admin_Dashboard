# AdminPanel-Admin Dashboard - Automation Test Suite

##  Project Overview

**AdminPanel-Admin Dashboard** is a **Selenium-based automated test suite** for testing the admin dashboard application. It's built using the **Page Object Model (POM)** design pattern with **TestNG** framework to test various UI components including forms, alerts, frames, dynamic elements, and tables.

The project is designed for **data-driven testing** with **parallel execution** capabilities and generates comprehensive **ExtentReports** for test reporting.

---

##  Project Objectives

- Automate UI testing of Admin Dashboard application
- Implement reusable and maintainable test code using POM
- Support data-driven testing with Excel integration
- Generate detailed test reports with ExtentReports
- Capture screenshots on test failures
- Execute tests in parallel for faster execution
- Demonstrate advanced Selenium techniques (alerts, frames, dynamic elements, etc.)

---

##  Project Structure

```
AdminPanel-Admin_Dashboard/
│
├── src/
│   ├── main/
│   │   ├── java/com/srm/hackathon/adminpanel/
│   │   │   ├── base/
│   │   │   │   └── BasePage.java              # Base class for all pages with common methods
│   │   │   │
│   │   │   ├── factory/
│   │   │   │   └── DriverFactory.java         # WebDriver initialization and management
│   │   │   │
│   │   │   ├── pages/                         # Page Object Model classes
│   │   │   │   ├── FormPage.java              # Form testing page object
│   │   │   │   ├── AlertPage.java             # Alert handling page object
│   │   │   │   ├── FramePage.java             # Frame handling page object
│   │   │   │   ├── DynamicPage.java           # Dynamic elements page object
│   │   │   │   └── TablePage.java             # Table operations page object
│   │   │   │
│   │   │   ├── utils/
│   │   │   │   ├── ConfigReader.java          # Read configuration from properties file
│   │   │   │   ├── ExcelUtil.java             # Read test data from Excel files
│   │   │   │   ├── WaitUtils.java             # Wait conditions and utilities
│   │   │   │   ├── ExtentManager.java         # Extent Reports configuration
│   │   │   │   ├── ScreenshotUtil.java        # Screenshot capture utility
│   │   │   │   └── Log.java                   # Logging utility
│   │   │   │
│   │   │   └── listeners/
│   │   │       └── TestListener.java          # TestNG listeners for reporting
│   │   │
│   │   └── resources/
│   │       ├── config.properties              # Configuration file
│   │       └── FormData.xlsx                  # Test data for form tests
│   │
│   └── test/
│       ├── java/com/srm/hackathon/adminpanel/
│       │   ├── base/
│       │   │   └── BaseTest.java              # Base test class with setup/teardown
│       │   │
│       │   └── tests/
│       │       ├── FormTest.java              # Form submission and validation tests
│       │       ├── AlertTest.java             # Alert handling tests
│       │       ├── FrameTest.java             # Frame switching tests
│       │       ├── DynamicTest.java           # Dynamic element tests
│       │       └── TableTest.java             # Table operations tests
│       │
│       └── resources/
│           └── (test configuration files)
│
├── reports/
│   └── ExtentReport.html                      # Generated extent report
│
├── screenshots/
│   └── (captured screenshots on failures)
│
├── test-output/
│   └── (TestNG default report files)
│
├── pom.xml                                     # Maven configuration
├── testng.xml                                  # TestNG execution configuration
└── README.md                                   # This file

```

---

##  Technologies & Dependencies

### Core Technologies
- **Java 8+** - Programming language
- **Selenium 4.34.0** - Web automation framework
- **TestNG 7.10.2** - Test framework
- **Maven** - Build tool

### Key Dependencies

```xml
<!-- Selenium WebDriver -->
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.34.0</version>
</dependency>

<!-- TestNG -->
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.10.2</version>
</dependency>

<!-- WebDriver Manager (Auto-manages driver binaries) -->
<dependency>
    <groupId>io.github.bonigarcia</groupId>
    <artifactId>webdrivermanager</artifactId>
    <version>5.9.2</version>
</dependency>

<!-- Apache POI (Excel data reading) -->
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi</artifactId>
    <version>5.4.1</version>
</dependency>
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-ooxml</artifactId>
    <version>5.4.1</version>
</dependency>

<!-- ExtentReports (Test reporting) -->
<dependency>
    <groupId>com.aventstack</groupId>
    <artifactId>extentreports</artifactId>
    <version>5.1.1</version>
</dependency>
```

---

##  Architecture & Design Patterns

### 1. **Page Object Model (POM)**
Each page/screen of the application is represented as a separate class:
- **BasePage** - Contains common methods and elements
- **Page Classes** - Extend BasePage and encapsulate page-specific elements and methods

### 2. **Factory Pattern**
- **DriverFactory** - Manages WebDriver initialization and lifecycle

### 3. **Data-Driven Testing**
- Test data stored in Excel files (`FormData.xlsx`)
- Tests parameterized using TestNG @DataProvider
- ExcelUtil reads and provides test data

### 4. **Listener Pattern**
- **TestListener** - Implements TestNG ITestListener for test lifecycle events
- Integrates with ExtentReports for automatic logging

---

##  Configuration

### config.properties

```properties
# Browser to use (chrome, firefox, edge, etc.)
browser=chrome

# Base URL of the application
baseUrl=https://testpages.eviltester.com/styled/index.html

# Implicit wait timeout (seconds)
timeout=10

# Run in headless mode (true/false)
headless=true
```

### testng.xml

```xml
<suite name="Hackathon Suite" parallel="tests" thread-count="2">
    <listeners>
        <listener class-name="com.srm.hackathon.adminpanel.listeners.TestListener"/>
    </listeners>

    <!-- Test groups -->
    <test name="Form Tests">...</test>
    <test name="Alert Tests">...</test>
    <test name="Frame Tests">...</test>
    <test name="Dynamic Tests">...</test>
    <test name="Table Tests">...</test>
</suite>
```

---

##  Test Suites

### 1. **FormTest** - HTML Form Testing
Tests form submission with various UI elements:
-  **testValidFormSubmission** - Data-driven form submission test
-  **testDropdownSelection** - Dropdown value verification
-  **testCheckboxAndRadio** - Checkbox and radio button selection

**Key Features:**
- Data-driven using Excel file (`FormData` sheet)
- Tests text input, checkboxes, radio buttons, dropdowns
- Validates submitted data against expected results

### 2. **AlertTest** - JavaScript Alert Handling
Tests browser alert interactions:
-  **testSimpleAlert** - Accept simple alert
-  **testConfirmAccept** - Accept confirm dialog
-  **testConfirmDismiss** - Dismiss confirm dialog
-  **testPrompt** - Enter text in prompt dialog

**Key Features:**
- Tests all alert types (alert, confirm, prompt)
- Validates alert handling and result messages

### 3. **FrameTest** - Frame/Iframe Handling
Tests switching between frames:
-  Frame detection and switching
-  Element interaction within frames
-  Exiting frames back to main content

### 4. **DynamicTest** - Dynamic Elements
Tests elements that appear/disappear dynamically:
-  **testDynamicButtonsFlow** - Sequence of button clicks
-  **testDynamicResultVerification** - Result validation

**Key Features:**
- Tests wait conditions for dynamic elements
- Verifies final state after interactions

### 5. **TableTest** - HTML Table Operations
Tests table data validation:
-  **testTableHeaders** - Header verification
-  **testInitialTableData** - Data row verification

**Key Features:**
- Table header validation
- Row data verification

---

##  How to Run Tests

### Prerequisites
- Java 8 or higher installed
- Maven installed
- Chrome browser installed (WebDriverManager auto-manages driver)
- IDE (Eclipse, IntelliJ IDEA recommended)

### Run All Tests
```bash
mvn clean test
```

### Run Specific Test Suite
```bash
mvn clean test -Dsuites=testng.xml
```

### Run with Maven (Specific Test Class)
```bash
mvn test -Dtest=FormTest
```

### Run from IDE (Eclipse/IntelliJ)
1. Right-click on `testng.xml`
2. Select "Run As" → "TestNG Suite"

### Run with Custom Configuration
```bash
mvn clean test -Dbrowser=chrome -Dheadless=true
```

---

##  Test Reports

### ExtentReports
- **Location:** `reports/ExtentReport.html`
- **Features:**
  - Dashboard with test statistics
  - Test execution timeline
  - Pass/Fail status with details
  - Screenshot attachments on failures
  - Browser and device information
  - Tags and categories

### TestNG Reports
- **Location:** `test-output/index.html`
- Standard TestNG HTML report with execution details

### Screenshots
- **Location:** `screenshots/`
- Captured automatically on test failures
- Named with test method and timestamp

---

##  Key Classes & Methods

### BasePage.java
```java
protected void click(WebElement element)           // Click with wait
protected void type(WebElement element, String value)  // Type text
protected String getText(WebElement element)       // Get element text
protected Alert waitForAlert()                     // Wait for JavaScript alert
protected void scrollToElement(WebElement element) // Scroll to element
```

### DriverFactory.java
```java
public static void initDriver()                    // Initialize WebDriver
public static WebDriver getDriver()                // Get current WebDriver instance
public static void quitDriver()                    // Close WebDriver and cleanup
```

### ConfigReader.java
```java
public static String getBrowser()                  // Get browser type
public static String getBaseUrl()                  // Get application URL
public static int getTimeout()                     // Get wait timeout
public static boolean isHeadless()                 // Get headless mode status
```

### ExcelUtil.java
```java
public static Object[][] getTestData(String sheetName)  // Get data from Excel sheet
```

---

##  Best Practices Implemented

1. **Page Object Model** - Separation of page elements and test logic
2. **DRY Principle** - Reusable methods in BasePage and BasePage utilities
3. **Explicit Waits** - WaitUtils for reliable element interactions
4. **Thread-Safe WebDriver** - ThreadLocal for parallel execution
5. **Data-Driven Testing** - Excel integration for test parameters
6. **Logging & Reporting** - ExtentReports with screenshots
7. **Configuration Management** - Externalized properties
8. **Exception Handling** - Fallback mechanisms in click operations

---

##  Troubleshooting

### Tests Fail with "Element Not Found"
- ✅ Check if timeout in config.properties is sufficient
- ✅ Verify element locators in Page classes
- ✅ Check if page has loaded completely

### WebDriver Connection Refused
- ✅ Ensure Chrome is installed
- ✅ Check if ChromeDriver is compatible with Chrome version
- ✅ WebDriverManager should auto-download correct driver

### Excel Data Not Loading
- ✅ Verify FormData.xlsx exists in `src/main/resources/`
- ✅ Check sheet name matches in test (@DataProvider name)
- ✅ Ensure Excel file format is .xlsx

### Parallel Execution Issues
- ✅ ThreadLocal WebDriver prevents thread conflicts
- ✅ Check thread-count in testng.xml
- ✅ Verify test isolation (no shared state)

---

##  Metrics & Results

After test execution, review:
- **Total Tests:** Displayed in reports
- **Pass Rate:** Success percentage
- **Failure Details:** Error messages and stack traces
- **Execution Time:** Total and per-test timing
- **Screenshots:** Attached to failed tests

---

## 🔄 Continuous Integration

This project is CI/CD ready:
- ✅ Maven-based build
- ✅ Parallel test execution support
- ✅ Automated reporting
- ✅ Headless mode capability
- ✅ Exit codes for pipeline integration

**Example Jenkins Integration:**
```groovy
stage('Test') {
    steps {
        sh 'mvn clean test -Dheadless=true'
    }
}
stage('Report') {
    steps {
        publishHTML([reportDir: 'reports', reportFiles: 'ExtentReport.html'])
    }
}
```

---

##  Notes

- **Base URL:** The tests run against `https://testpages.eviltester.com/` (free test application)
- **Browser:** Configured for Chrome; can be modified in config.properties
- **Parallel Execution:** 2 threads configured in testng.xml (adjustable)
- **Headless Mode:** Enabled by default for CI/CD environments

---

##  Author & Version

- **Project Name:** AdminPanel-Admin Dashboard
- **Version:** 0.0.1-SNAPSHOT
- **Group ID:** com.srm.hackathon
- **Artifact ID:** AdminPanel-Admin_Dashboard

---

##  Support & Contact

For issues or questions:
- Review test logs in `test-output/`
- Check ExtentReport for detailed failure information
- Verify configuration in `config.properties`
- Review page locators in respective Page classes

---
