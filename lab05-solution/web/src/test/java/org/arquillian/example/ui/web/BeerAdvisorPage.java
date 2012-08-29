package org.arquillian.example.ui.web;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.Lists;

/**
 * Main page of the Beer Advisor app.
 */
public class BeerAdvisorPage {

    private static final String RESULT_TABLE_XPATH = "//table[@id='beer-results-table']/tbody/tr";

    private static final String BEER_LINK = "*//a[text()='%s']";

    private final WebDriver driver;

    public BeerAdvisorPage(WebDriver driver, String location) {
        this.driver = driver;
        driver.get(location);
        PageFactory.initElements(driver, this);
    }

    public List<Beer> fetchFromTable() {
        final List<WebElement> foundResultRows = driver.findElements(By.xpath(RESULT_TABLE_XPATH));
        return Lists.transform(foundResultRows, new BeerRowsExtractor());
    }

    /**
     * Gets details of the first beer with the given name.
     */
    public Beer detailsOf(String beerName) {
        linkToFirstMatchingBeer(beerName).click();
        return new BeerDetailsPage(driver).extract();
    }

    // --- Private methods

    private WebElement linkToFirstMatchingBeer(String criteria) {
        final String beerLinkXpath = String.format(BEER_LINK, criteria);
        final WebElement beerLink = driver.findElement(By.xpath(beerLinkXpath));
        return beerLink;
    }
}
