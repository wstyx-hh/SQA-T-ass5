# SauceDemo Automation Testing (TestNG)

## Project Description
This project contains automated UI tests for the SauceDemo web application using Selenium WebDriver and TestNG framework. The automation covers login functionality, shopping cart operations, and product sorting features.

## Technologies Used
- **Language:** Java 17
- **Automation Tool:** Selenium WebDriver 4.16.1
- **Test Framework:** TestNG 7.9.0
- **Logging:** Log4j2 2.22.0
- **Build Tool:** Maven
- **Browser:** Microsoft Edge

## Prerequisites
- Java JDK 17 or higher
- Maven 3.6+
- Microsoft Edge browser
- Git

## Project Structure
```
demo/
├── src/
│   ├── main/java/
│   └── test/
│       ├── java/
│       │   ├── base/          # BaseTest class with setup/teardown
│       │   ├── tests/         # Test cases (SauceDemoTests)
│       │   └── utils/         # Utilities (Logger, Screenshot)
│       └── resources/
│           └── log4j2.xml     # Logging configuration
├── logs/                      # Test execution logs
├── screenshots/               # Screenshots on test failure
├── pom.xml                    # Maven dependencies
├── testing.xml                # TestNG configuration
└── README.md
```

## Installation & Setup
1. Clone the repository:
```bash
git clone https://github.com/wstyx-hh/SQA-T-ass5.git
cd SQA-T-ass5/demo
```

2. Install dependencies:
```bash
mvn clean install
```

## How to Run Tests

### Option 1: Maven Command Line
```bash
mvn clean test
```

### Option 2: TestNG XML
```bash
mvn test -DsuiteXmlFile=testing.xml
```

### Option 3: IDE (IntelliJ IDEA / VS Code)
1. Open project in your IDE
2. Right-click on `testing.xml`
3. Select "Run"

## Test Cases

| Test ID | Test Name | Description | Status |
|---------|-----------|-------------|--------|
| TC-01 | successfulLogin | Verify login with valid credentials | ✅ PASS |
| TC-02 | addItemToCart | Verify adding product to cart | ✅ PASS |
| TC-03 | productSortingByPrice | Verify product sorting by price (low to high) | ✅ PASS |
| TC-04 | verifyCartBadgeCount | Verify cart badge item count (Bug Report) | ❌ FAIL |

## Test Results
- **Total Tests:** 4
- **Passed:** 3
- **Failed:** 1
- **Success Rate:** 75%

## Features
✅ Test lifecycle management (setup/teardown)  
✅ Logging with Log4j2 (logs saved to file)  
✅ Automatic screenshots on test failure  
✅ HTML test reports (Surefire)  
✅ Detailed test documentation  

## Logs & Reports
- **Test Logs:** `logs/test.log`
- **Screenshots:** `screenshots/`
- **HTML Reports:** `target/surefire-reports/index.html`

## Bug Report
**BUG-01:** Cart badge displays incorrect item count  
- **Expected:** Badge shows "2" when 2 items added  
- **Actual:** Badge shows incorrect count  
- **Screenshot:** `screenshots/verifyCartBadgeCount.png`

## Author
**Nuraiym**  
GitHub: [@wstyx-hh](https://github.com/wstyx-hh)  
Assignment: SQA Assignment 5 - TestNG Automation

## License
This project is created for educational purposes.