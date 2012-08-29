package ch.open.arquillian.lab04.ui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.Selenium;

public class BeerAdvisorSeleniumTest {

    private Selenium selenium;

    @Before
    public void setUp() throws Exception {
        String baseUrl = "http://beeradvisor.bartoszmajsak.com";
        selenium = new WebDriverBackedSelenium(new FirefoxDriver(), baseUrl);
    }

    @Test
    public void should_find_all_beers() throws Exception {
        selenium.open("/search.xhtml");
        selenium.type("id=advisor:beerSearch", "all");
        selenium.keyPress("id=advisor:beerSearch", "\\13");
        for (int second = 0;; second++) {
            if (second >= 60)
                fail("timeout");
            try {
                if (selenium.isElementPresent("//table[@id='beer-results-table']/tbody/tr"))
                    break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        assertEquals(7, selenium.getXpathCount("//table[@id='beer-results-table']/tbody/tr"));
    }

    @After
    public void tearDown() throws Exception {
        selenium.stop();
    }
}