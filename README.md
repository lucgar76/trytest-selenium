# trytest-selenium

A Selenium + Cucumber + TestNG automation project that tests the [Automation Camp practice site](https://play2.automationcamp.ir/).

---

## Prerequisites

Make sure the following are installed on your machine before cloning the project:

| Tool | Version | Download |
|---|---|---|
| Java (JDK) | 17 or higher | https://adoptium.net |
| Maven | 3.8 or higher | https://maven.apache.org/download.cgi |
| Google Chrome | Latest | https://www.google.com/chrome |

> **ChromeDriver is managed automatically** — the `WebDriverManager` library downloads the correct ChromeDriver version for your installed Chrome at runtime. You do not need to install it manually.

Verify your installations by running:

```bash
java -version
mvn -version
```

---

## Download & Setup

### 1. Clone the repository

```bash
git clone <repository-url>
cd trytest-selenium
```

### 2. Install dependencies

Maven will download all required libraries automatically:

```bash
mvn install -DskipTests
```

---

## Project Structure

```
trytest-selenium/
├── src/
│   └── test/
│       ├── java/
│       │   ├── runner/
│       │   │   └── CucumberTestRunner.java     ← launches all tests
│       │   ├── stepdefs/
│       │   │   ├── Hooks.java                  ← opens/closes Chrome before/after each scenario
│       │   │   ├── OpenWebsiteSteps.java
│       │   │   ├── FillNameFieldsSteps.java
│       │   │   ├── SelectGenderSteps.java
│       │   │   ├── SelectDropdownSteps.java
│       │   │   ├── MultiSelectSteps.java
│       │   │   ├── CheckboxSteps.java
│       │   │   ├── ColorPickerSteps.java
│       │   │   ├── DatePickerSteps.java
│       │   │   ├── RangeSliderSteps.java
│       │   │   └── SubmitButtonSteps.java
│       │   └── utils/
│       │       └── DriverManager.java          ← shared WebDriver instance
│       └── resources/
│           └── features/                       ← all .feature files live here
│               ├── open_website.feature
│               ├── fill_name_fields.feature
│               ├── select_gender.feature
│               ├── select_dropdown_option.feature
│               ├── multi_select_options.feature
│               ├── checkbox_options.feature
│               ├── color_picker.feature
│               ├── date_picker.feature
│               ├── range_slider.feature
│               ├── submit_button.feature
│               └── CompleteTest.feature        ← runs all 10 tests in one scenario
└── pom.xml
```

> **Feature files** are plain-English test scenarios written in Gherkin (`.feature` files). They live in `src/test/resources/features/`. Each file corresponds to one test area. The **step definitions** in `src/test/java/stepdefs/` contain the Java code that runs behind each Gherkin step.

---

## Running the Tests

### Run all tests

Executes every `.feature` file in the `features/` folder:

```bash
mvn test
```

---

### Run each test individually

Pass the path to a specific feature file using the `-Dcucumber.features` flag:

#### 1. Open website & verify page title
```bash
mvn test -Dcucumber.features="src/test/resources/features/open_website.feature"
```

#### 2. Fill in name fields
```bash
mvn test -Dcucumber.features="src/test/resources/features/fill_name_fields.feature"
```

#### 3. Select gender radio button
```bash
mvn test -Dcucumber.features="src/test/resources/features/select_gender.feature"
```

#### 4. Select option from dropdown
```bash
mvn test -Dcucumber.features="src/test/resources/features/select_dropdown_option.feature"
```

#### 5. Multi-select by click and drag
```bash
mvn test -Dcucumber.features="src/test/resources/features/multi_select_options.feature"
```

#### 6. Tick checkboxes
```bash
mvn test -Dcucumber.features="src/test/resources/features/checkbox_options.feature"
```

#### 7. Color picker
```bash
mvn test -Dcucumber.features="src/test/resources/features/color_picker.feature"
```

#### 8. Date picker
```bash
mvn test -Dcucumber.features="src/test/resources/features/date_picker.feature"
```

#### 9. Range slider
```bash
mvn test -Dcucumber.features="src/test/resources/features/range_slider.feature"
```

#### 10. Submit button
```bash
mvn test -Dcucumber.features="src/test/resources/features/submit_button.feature"
```

---

### Run CompleteTest (all 10 tests in one)

`CompleteTest.feature` is a single end-to-end scenario that chains all 10 individual tests together in the order they appear on the page, finishing with the Submit button click:

1. Open website & verify title
2. Fill in first and last name
3. Select gender radio button
4. Select from dropdown
5. Multi-select by drag
6. Tick checkboxes
7. Pick a colour
8. Set today's date
9. Move range slider to 85
10. **Click Submit → verifies Google opens in a new tab**

```bash
mvn test -Dcucumber.features="src/test/resources/features/CompleteTest.feature"
```

---

## Test Reports

After any test run, an HTML report is generated at:

```
target/cucumber-reports/cucumber-report.html
```

Open it in any browser to see a full breakdown of passed/failed steps.
