package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TAFENSWHomePage {
    private WebDriver driver;

    public TAFENSWHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.tafensw.edu.au/");
      //Maximize current window
        driver.manage().window().maximize();
    }

    public void enterSearchKeyword(String keyword) {
        WebElement searchBox = driver.findElement(By.id("homePageSearch"));
        searchBox.sendKeys(keyword);
    }

    public void clickSearchButton() {
        WebElement searchButton = driver.findElement(By.xpath("//button[@aria-label='Submit search']"));
        searchButton.click();
    }
}