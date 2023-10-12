package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {
    private WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCourseDisplayed(String courseName) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	By courseTitleXPath = By.xpath("//h4[contains(text(),'Advanced Barista Skills')]");
    	WebElement courseTitle = wait.until(ExpectedConditions.presenceOfElementLocated(courseTitleXPath));

        // Scroll to the element to make it visible
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", courseTitle);

        return courseTitle.isDisplayed();
    }

    public void applyDeliveryFilter(String filterValue) {
        // Find and click the element to display the checkboxes
        WebElement expandFilterElement = driver.findElement(By.xpath("(//div[@class='flex items-start mt-2'])[3]"));
        expandFilterElement.click();

        // Scroll to the filter container
        WebElement filterContainer = driver.findElement(By.xpath("//div[@class='flex flex-col overflow-y-auto card-body'][1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", filterContainer);

        // Select the 'On campus' checkbox
        WebElement onCampusCheckbox = driver.findElement(By.id("on-campus"));
        onCampusCheckbox.click();
    }

    public boolean isFilterApplied() {
        // Verify if the 'On campus' filter is selected
        WebElement onCampusCheckbox = driver.findElement(By.id("on-campus"));
        return onCampusCheckbox.isSelected();
    }
}
