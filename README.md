# AdminPanel Admin Dashboard - Selenium Test Automation Suite

##  Project Overview

**AdminPanel-Admin_Dashboard** is a comprehensive automated testing suite built using **Selenium WebDriver** and **TestNG**. This project demonstrates advanced Selenium concepts and test automation best practices for testing a dynamic web application with various UI elements including forms, alerts, frames, dynamic elements, and data tables.

**Project Type:** Selenium 4 + TestNG + Data-Driven Testing  
**Version:** 0.0.1-SNAPSHOT  
**Organization:** SRM Hackathon  
**Language:** Java  
**Build Tool:** Maven

---

##  Project Goals

- Automate testing of complex web UI elements
- Implement Page Object Model (POM) design pattern
- Perform data-driven testing with Excel files
- Handle advanced Selenium scenarios (alerts, frames, dynamic elements)
- Generate detailed test reports with ExtentReports
- Maintain clean, reusable, and maintainable test code
- Run tests in parallel for faster execution

---

##  Architecture & Design Patterns

### Design Patterns Used:
1. **Page Object Model (POM)** - Encapsulates web elements and interactions
2. **Base Page Pattern** - Common functionality for all page objects
3. **Base Test Pattern** - Setup and teardown for all test classes
4. **Factory Pattern** - WebDriver initialization and management
5. **Data-Driven Testing** - Excel-based test data
6. **Listener Pattern** - Custom TestNG listeners for reporting

### Architecture Layers:
```
├── Base Layer (BasePage, BaseTest)
├── Page Layer (Page Objects)
├── Test Layer (Test Cases)
├── Factory Layer (DriverFactory)
├── Utilities Layer (Helper classes)
└── Configuration Layer (Properties files)
```

---

##  Project Structure

```
AdminPanel-Admin_Dashboard/
│
├── pom.xml                          # Maven configuration file with dependencies
├── testng.xml                       # TestNG suite configuration
├── README.md                        # This file
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/srm/hackathon/adminpanel/
│   │   │       ├── base/
│   │   │       │   ├── BasePage.java         # Base class for all page objects
│   │   │       │   └── BaseTest.java         # Base class for all test cases
│   │   │       │
│   │   │       ├── factory/
│   │   │       │   └── DriverFactory.java    # WebDriver initialization & management
│   │   │       │
│   │   │       ├── pages/                    # Page Object Classes
│   │   │       │   ├── FormPage.java         # Form interactions
│   │   │       │   ├── AlertPage.java        # Alert handling
│   │   │       │   ├── FramePage.java        # Frame/iFrame switching
│   │   │       │   ├── DynamicPage.java      # Dynamic element interactions
│   │   │       │   └── TablePage.java        # Table data interactions
│   │   │       │
│   │   │       ├── listeners/
│   │   │       │   └── TestListener.java     # Custom TestNG listener
│   │   │       │
│   │   │       └── utils/                    # Utility Classes
│   │   │           ├── ConfigReader.java     # Configuration file reader
│   │   │           ├── ExcelUtil.java        # Excel file handling
│   │   │           ├── ExtentManager.java    # ExtentReport management
│   │   │           ├── ScreenshotUtil.java   # Screenshot capture
│   │   │           └── WaitUtils.java        # Wait conditions
│   │   │
│   │   └── resources/
│   │       ├── config.properties     # Configuration settings
│   │       └── FormData.xlsx         # Test data file
│   │
│   └── test/
│       ├── java/
│       │   └── com/srm/hackathon/adminpanel/tests/
│       │       ├── FormTest.java             # Form submission tests
│       │       ├── AlertTest.java            # Alert handling tests
│       │       ├── FrameTest.java            # Frame/iFrame tests
│       │       ├── DynamicTest.java          # Dynamic element tests
│       │       └── TableTest.java            # Table interaction tests
│       │
│       └── resources/               # Test resources (empty)
│
├── target/
│   ├── classes/                     # Compiled source code
│   └── test-classes/                # Compiled test code
│
├── reports/
│   └── ExtentReport.html            # Extent Report output
│
├── screenshots/                      # Screenshot captures
│   ├── testValidFormSubmission_*.png
│   ├── testInValidFormSubmission_*.png
│   └── testCheckboxAndRadio_*.png
│
├── test-output/                     # TestNG default report output
│   ├── index.html
│   ├── emailable-report.html
│   ├── testng-results.xml
│   └── junitreports/                # JUnit format reports
│
└── .git/                            # Git version control
```

---

##  Dependencies

### Core Dependencies:

| Dependency | Version | Purpose |
|-----------|---------|---------|
| **Selenium WebDriver** | 4.34.0 | Web browser automation |
| **TestNG** | 7.10.2 | Testing framework |
| **WebDriverManager** | 5.9.2 | Automatic driver management |
| **Apache POI** | 5.4.1 | Excel file reading/writing |
| **ExtentReports** | 5.1.1 | Advanced test reporting |

### Maven Coordinates:
```xml
<!-- TestNG -->
org.testng:testng:7.10.2

<!-- Selenium -->
org.seleniumhq.selenium:selenium-java:4.34.0

<!-- WebDriverManager -->
io.github.bonigarcia:webdrivermanager:5.9.2

<!-- Apache POI -->
org.apache.poi:poi:5.4.1
org.apache.poi:poi-ooxml:5.4.1

<!-- ExtentReports -->
com.aventstack:extentreports:5.1.1
```

---

##  Configuration

### config.properties

Located at: `src/main/resources/config.properties`

```properties
# Browser Configuration
browser=chrome

# Application Base URL
baseUrl=https://testpages.eviltester.com/styled/index.html

# Implicit Wait Timeout (in seconds)
timeout=10

# Headless Mode (true/false)
headless=true
```

### Customization:
- **Browser**: Change to `firefox`, `edge`, etc. (requires driver support)
- **Base URL**: Update to test different environments
- **Timeout**: Adjust implicit wait duration
- **Headless**: Set to `false` to see browser UI during test execution

---

##  Test Suite Overview

### 1. **Form Tests** (FormTest.java)
Tests HTML form submission with various input types.

| Test Case | Description | Method |
|-----------|-------------|--------|
| **Valid Form Submission** | Data-driven test with Excel file | `testValidFormSubmission()` |
| **Dropdown Selection** | Verify dropdown functionality | `testDropdownSelection()` |
| **Checkbox & Radio** | Test checkbox and radio button selection | `testCheckboxAndRadio()` |
| **Empty Form Validation** | Verify validation on empty submission | `testEmptyFormSubmission()` |

**Test Flow:**
1. Navigate to form page
2. Fill text fields (username, password, comments)
3. Select checkboxes and radio buttons
4. Select from dropdown
5. Submit form
6. Verify results

**Data Source:** `FormData.xlsx` (Excel file with test parameters)

---

### 2. **Alert Tests** (AlertTest.java)
Tests JavaScript alert, confirmation, and prompt dialogs.

| Test Case | Description | Method |
|-----------|-------------|--------|
| **Simple Alert** | Accept JavaScript alert | `testSimpleAlert()` |
| **Confirm Accept** | Click OK on confirmation dialog | `testConfirmAccept()` |
| **Confirm Dismiss** | Click Cancel on confirmation dialog | `testConfirmDismiss()` |
| **Prompt Handling** | Handle prompt dialog with input | `testPromptHandling()` |

**Key Features:**
- Alert handling using WebDriver switchTo()
- Accept/Dismiss operations
- Text verification in alerts
- Prompt input handling

---

### 3. **Frame Tests** (FrameTest.java)
Tests switching to and interacting with iFrames.

| Test Case | Description | Method |
|-----------|-------------|--------|
| **iFrame Interaction** | Switch to frame and click elements | `testIframeInteraction()` |
| **iFrame Text Verification** | Verify text within iframe | `testIframeTextVerification()` |
| **Multiple Frames** | Switch between different frames | `testMultipleFrames()` |

**Key Features:**
- Frame switching by index and name
- Element interaction within frames
- Text extraction from frame elements
- Frame reference management

---

### 4. **Dynamic Tests** (DynamicTest.java)
Tests interactions with dynamically appearing/disappearing elements.

| Test Case | Description | Method |
|-----------|-------------|--------|
| **Dynamic Buttons Flow** | Click hidden buttons that appear sequentially | `testDynamicButtonsFlow()` |
| **Dynamic Result Verification** | Verify results of dynamic interactions | `testDynamicResultVerification()` |
| **Wait for Dynamic Elements** | Test explicit waits for dynamic elements | `testWaitForDynamicElements()` |

**Key Features:**
- Explicit waits for dynamic elements
- Hidden element handling
- Sequential element visibility
- Dynamic content verification

---

### 5. **Table Tests** (TableTest.java)
Tests table element interactions and data verification.

| Test Case | Description | Method |
|-----------|-------------|--------|
| **Table Headers** | Verify column headers | `testTableHeaders()` |
| **Initial Table Data** | Verify initial table content | `testInitialTableData()` |

**Key Features:**
- Table header verification
- Row data extraction
- Cell content verification
- Dynamic table interaction

---

##  Setup & Installation

### Prerequisites:
- **Java 8 or higher** (JDK installed)
- **Maven 3.6+**
- **Git** (for version control)
- **Chrome Browser** (for test execution)

### Step 1: Clone the Repository
```bash
git clone <repository-url>
cd AdminPanel-Admin_Dashboard
```

### Step 2: Verify Java & Maven Installation
```bash
java -version
mvn -version
```

### Step 3: Install Dependencies
```bash
mvn clean install
```

This command will:
- Clean the project
- Download all dependencies from Maven Central
- Compile source code
- Compile test code
- Package the project

### Step 4: Configure Browser & Environment
Edit `src/main/resources/config.properties`:
```properties
browser=chrome          # Change if needed
baseUrl=https://testpages.eviltester.com/styled/index.html
timeout=10             # Adjust as needed
headless=true          # Set to false to see browser
```

---

##  Running Tests

### Run All Tests
```bash
mvn test
```

### Run Specific Test Class
```bash
mvn test -Dtest=FormTest
```

### Run Specific Test Method
```bash
mvn test -Dtest=FormTest#testValidFormSubmission
```

### Run Using TestNG Suite (testng.xml)
```bash
mvn test -DsuiteXmlFile=testng.xml
```

### Run Tests in Parallel (as configured)
```bash
mvn test
```
The `testng.xml` is configured with `parallel="tests" thread-count="2"` for parallel execution.

### Run with Maven Clean Build
```bash
mvn clean test
```

### Run with Maven and Skip Compilation
```bash
mvn test -o
```

---

## Test Reports

### 1. **ExtentReports**
- **Location:** `reports/ExtentReport.html`
- **Features:**
  - Test execution timeline
  - Pass/Fail statistics
  - Detailed test logs
  - Screenshot attachments
  - Step-by-step execution details

### 2. **TestNG Default Report**
- **Location:** `test-output/`
- **Files:**
  - `index.html` - Main report
  - `emailable-report.html` - Email-friendly report
  - `testng-results.xml` - XML results
  - `junitreports/` - JUnit format reports

### 3. **Screenshots**
- **Location:** `screenshots/`
- **Captured:** On test failure (via TestListener)
- **Format:** PNG with timestamp

---

## 📋 TestNG Configuration (testng.xml)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">

<suite name="Hackathon Suite" parallel="tests" thread-count="2">
    <!-- Parallel execution: tests run in 2 threads -->
    <!-- Listener for extended functionality -->
    
    <listeners>
        <listener class-name="com.srm.hackathon.adminpanel.listeners.TestListener"/>
    </listeners>

    <!-- Test Groups -->
    <test name="Form Tests">
        <classes>
            <class name="com.srm.hackathon.adminpanel.tests.FormTest"/>
        </classes>
    </test>
    
    <test name="Alert Tests">
        <!-- ... -->
    </test>
    
    <!-- ... other tests ... -->
</suite>
```

**Key Configuration:**
- `parallel="tests"` - Tests run in parallel
- `thread-count="2"` - Maximum 2 parallel threads
- `<listeners>` - Custom TestNG listener for reports

---

## 🔧 Key Classes & Components

### Base Classes

#### BasePage.java
```java
public class BasePage {
    protected WebDriver driver;
    
    // Methods:
    - waitForElement()
    - clickElement()
    - sendKeys()
    - switchToFrame()
    - switchToAlert()
    - takeScreenshot()
}
```

#### BaseTest.java
```java
public class BaseTest {
    @BeforeMethod
    public void setUp() {
        DriverFactory.initDriver();
        DriverFactory.getDriver().get(ConfigReader.getBaseUrl());
    }
    
    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
```

### Factory Classes

#### DriverFactory.java
Manages WebDriver instance using ThreadLocal for thread safety:
```java
public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    
    - initDriver()      // Initialize driver
    - getDriver()       // Get driver instance
    - quitDriver()      // Quit driver
}
```

### Utility Classes

#### ConfigReader.java
Reads configuration from `config.properties`:
```java
- getBrowser()        // Get browser name
- getBaseUrl()        // Get base URL
- getTimeout()        // Get timeout
- isHeadless()        // Check headless mode
```

#### ExcelUtil.java
Reads test data from Excel files:
```java
- getTestData()       // Get data from worksheet
- writeData()         // Write data to Excel
```

#### WaitUtils.java
Provides wait conditions:
```java
- waitForElement()
- waitForElementClick()
- waitForText()
- waitForVisibility()
```

#### ExtentManager.java
Manages ExtentReports:
```java
- initReports()
- logPass()
- logFail()
- attachScreenshot()
- flush()
```

#### ScreenshotUtil.java
Captures screenshots:
```java
- takeScreenshot()    // Capture full page
- getScreenshotPath() // Get file path
```

---

## 📝 Page Objects

### FormPage.java
**Methods:**
- `navigateToHtmlForm()`
- `fillTextFields(username, password, comments)`
- `selectCheckboxByIndex(index)`
- `selectRadioByIndex(index)`
- `selectDropdownByValue(value)`
- `clickSubmit()`
- `getResultUsername()`, `getResultPassword()`, etc.

### AlertPage.java
**Methods:**
- `navigateToAlertsPage()`
- `clickAlertButton()`, `clickConfirmButton()`, `clickPromptButton()`
- `acceptAlert()`, `dismissAlert()`
- `getAlertText()`, `sendAlertText(text)`
- `getAlertResult()`, `getConfirmResult()`, `getPromptResult()`

### FramePage.java
**Methods:**
- `navigateToIframesPage()`
- `switchToLeftFrame()`, `switchToRightFrame()`
- `clickListItem(index)`
- `getListItemText(index)`

### DynamicPage.java
**Methods:**
- `navigateToDynamicButtonsPage()`
- `clickStart()`, `clickButtonOne()`, `clickButtonTwo()`, `clickButtonThree()`
- `getResultMessage()`
- `waitForButton()`

### TablePage.java
**Methods:**
- `navigateToTablePage()`
- `areHeadersCorrect()`
- `isRowDataPresent(name)`
- `getTableData()`
- `getRowByColumn(columnValue)`


---

##  Troubleshooting

### Issue: "chrome driver not found"
**Solution:** WebDriverManager should handle this automatically. If not:
```bash
mvn clean install -U
```

### Issue: "Element not found / TimeoutException"
**Solution:** Increase timeout in `config.properties`:
```properties
timeout=15
```

### Issue: "Tests fail in headless mode"
**Solution:** Set headless to false for debugging:
```properties
headless=false
```

### Issue: "Screenshot not captured"
**Solution:** Ensure `screenshots/` directory exists:
```bash
mkdir screenshots
```

---

## Best Practices Implemented

1.  **Page Object Model** - Maintainable and reusable code
2.  **Data-Driven Testing** - Tests with multiple datasets
3.  **Explicit Waits** - Reliable element interaction
4.  **Screenshot Capture** - Visual debugging on failures
5.  **Detailed Reporting** - ExtentReports and TestNG reports
6.  **Thread Safety** - ThreadLocal for WebDriver instances
7.  **Configuration Management** - Properties file-based config
8.  **Parallel Execution** - Fast test execution
9.  **Error Handling** - Try-catch blocks and meaningful errors
10. **Code Organization** - Layered architecture

---

##  Technology Stack Summary

| Component | Technology | Version |
|-----------|-----------|---------|
| **Language** | Java | 8+ |
| **Build Tool** | Maven | 3.6+ |
| **Automation** | Selenium WebDriver | 4.34.0 |
| **Testing Framework** | TestNG | 7.10.2 |
| **Driver Manager** | WebDriverManager | 5.9.2 |
| **Data Handling** | Apache POI | 5.4.1 |
| **Reporting** | ExtentReports | 5.1.1 |
| **Browser** | Chrome | Latest |
| **Version Control** | Git | Latest |

---

##  License

This project is part of the SRM Hackathon and is intended for educational and testing purposes.

---

##  Team

**Project:** AdminPanel-Admin_Dashboard  
**Organization:** SRM Hackathon  
**Created:** April 2026

---

##  Contact & Contribution

For questions, issues, or contributions, please:
1. Create an issue in the repository
2. Submit a pull request with improvements
3. Follow the existing code style and patterns

---

**Last Updated:** April 14, 2026  
**Status:** Active Development 
