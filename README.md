# Automated Course Search Testing using Cucumber, Java, Selenium, and Page Object Model (POM)

This README file provides a detailed guide on the automated testing of course search on the TAFE NSW website using Java, Cucumber, Selenium, and the Page Object Model (POM). The project is structured to allow efficient testing and maintenance of the test scenarios.

## Prerequisites
Before running the tests, ensure you have the following prerequisites set up:

1. Java Development Kit (JDK)
2. IntelliJ IDEA or any preferred IDE for Java.
example)
3. Cucumber
4. JUnit
5. ChromeDriver.exe file

## Project Structure
The project follows the Page Object Model (POM) design pattern, which separates the page-related logic from the step definitions. Here's a brief explanation of the project structure:

- `src/test/java`: Contains the Java source code.
  - `features`: Holds the Cucumber feature files that define test scenarios.
  - `stepDefinitions`: Contains the Cucumber step definitions.
  - `pages`: Includes the Page Objects that represent the web pages in the application.
  - `cucumber.Options`: Configures the Cucumber test runner.

## Test Execution
To execute the automated test, follow these steps:

1. Clone or download the project to your local machine.
```
git clone https://github.com/parajuli/course-search-testing.git
```
2. Open the project in your preferred IDE.
3. Install the required dependencies.

### WebDriver Setup

Ensure that the WebDriver is set up correctly in the `CourseSearchSteps.java` file under the `setUp` method. Make sure that the path to the `chromedriver.exe` is accurate, and the WebDriver is compatible with your system.

### Running the Tests

Run the tests using the Cucumber test runner class `TestRunner.java`. Right-click on the `TestRunner` class and select "Run" or "Debug" in your IDE.

## Test Scenarios

The test scenarios are defined in Cucumber feature files (`course_search.feature`) and are mapped to step definitions in `CourseSearchSteps.java`. Each step is written in Gherkin language to create clear and readable test scenarios.

## Page Objects

Page Objects are used to encapsulate the functionality of web pages. They provide a convenient way to interact with the web elements on the page without exposing the implementation details to step definitions. In this project, there are two Page Objects:

1. `TAFENSWHomePage.java`: Represents the TAFE NSW homepage, including methods for opening the website, entering a search keyword, and clicking the search button.
2. `SearchResultsPage.java`: Represents the search results page, including methods for checking if a course is displayed and applying the delivery filter.

## Cucumber Test Runner

The `TestRunner.java` class is configured to run Cucumber tests. It specifies the location of feature files, step definitions, and any additional plugins for reporting. In this example, it's configured to produce "pretty" and "monochrome" output.

## Test Automation Flow

1. The `TAFENSWHomePage` Page Object is used to open the TAFE NSW website and perform a course search.
2. The `SearchResultsPage` Page Object is used to verify that the "Advanced Barista Skills" course is displayed in the search results. The Page Object is also used to apply the "On campus" delivery filter.

The test asserts that the filter has been correctly applied to the chosen course.

## Reporting

By default, Cucumber generates a report in the console output, providing details on the test execution. You can enhance reporting by adding HTML or JSON report plugins to the `CucumberOptions` configuration in `TestRunner.java`.

## Maintenance

To maintain this test suite, you can:

- Add more scenarios and features to the `course_search.feature` file.
- Extend the Page Objects in the `pages` package to encapsulate additional page functionality.
- Update the `CourseSearchSteps` step definitions to handle new scenarios or changes in the application.
- Enhance reporting and logging for better test visibility and debugging.

## Running Tests Using Linux Command

To run the automated tests using the Linux command line, follow these steps:

1. Open a terminal and navigate to the root folder of the project.

2. Use Maven to build the project:

```
mvn clean install
```

3. Run the tests using the following command:

```
mvn test
```

The tests will execute, and the results will be displayed on the terminal.

## Running Tests Using Jenkins

To run the automated tests using Jenkins, follow these steps:

- Download the Jenkins war file, navigate to the directory and execute the following command:

```
java -jar jenkins.war --httpPort=8080
```

1. Open Jenkins and create a new Freestyle project.

2. In the project configuration, set up the following:

   - Specify the Git repository URL where the project is hosted.
   - Add a build step to execute a Maven build, specifying the goals as `clean install test`.

3. Save the configuration and run the Jenkins project. Jenkins will fetch the code, build the project, and execute the tests.

4. After the test execution, you can access the generated Cucumber JSON report for further analysis.

## Test Results
The test results are generated in a Cucumber JSON report, which can be found at `target/jsonReports/cucumber-report.json`. You can customize the reporting format and output by modifying the `CucumberOptions` in the `TestRunner` class.

---