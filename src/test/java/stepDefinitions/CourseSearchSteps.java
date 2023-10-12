package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.SearchResultsPage;
import pages.TAFENSWHomePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CourseSearchSteps {
    private WebDriver driver;
    private TAFENSWHomePage homePage;
    private SearchResultsPage searchResultsPage;

    @Before
    public void setUp() {
    	System.setProperty("webdriver.chrome.driver", ".\\src\\test\\java\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new TAFENSWHomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
    }

    @Given("I am on the TAFE NSW website")
    public void iAmOnTAFENSWebsite() {
        homePage.open();
    }

    @When("I search for a course with the keyword {string}")
    public void searchForCourse(String courseName) {
        homePage.enterSearchKeyword(courseName);
    }

    @When("I click the search button")
    public void clickSearchButton() {
        homePage.clickSearchButton();
    }

    @Then("I should see the {string} course in the search results")
    public void verifyCourseInSearchResults(String courseName) {
        Assert.assertTrue(searchResultsPage.isCourseDisplayed(courseName));
    }

    @When("I apply the {string} filter by setting it to {string}")
    public void applyDeliveryFilter(String filterType, String filterValue) {
        searchResultsPage.applyDeliveryFilter(filterValue);
    }

    @Then("I should see that the filter has been correctly applied to the chosen course")
    public void verifyFilterApplied() {
        Assert.assertTrue(searchResultsPage.isFilterApplied());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}