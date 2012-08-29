package org.arquillian.example.ui

import static org.fest.assertions.Assertions.assertThat

import java.net.URL
import java.util.List
import java.util.concurrent.TimeUnit

import org.jboss.arquillian.container.test.api.Deployment
import org.jboss.arquillian.container.test.api.RunAsClient
import org.jboss.arquillian.drone.api.annotation.Drone
import org.jboss.arquillian.test.api.ArquillianResource
import org.jboss.shrinkwrap.api.spec.WebArchive
import org.junit.Test
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.arquillian.example.ui.utils.BeersAssert
import org.arquillian.example.ui.utils.Deployments
import org.arquillian.example.ui.web.Beer
import org.arquillian.example.ui.web.BeerAdvisorPage
import spock.lang.*

/**
 *
 * Acceptance tests for Beer Advisor app covering
 * its search capabilities. Tests can be treated as
 * executable specifications. They are written
 * in <a href="http://en.wikipedia.org/wiki/Behavior_Driven_Development#Application_examples_in_the_Gherkin_language">gherkin language</a>.
 */
@Stepwise
class BeerAdvisorSpecification extends Specification
{
   @Deployment(testable = false)
   public static WebArchive createDeployment()
   {
      return Deployments.create()
   }

   @ArquillianResource
   URL deploymentUrl

   @Drone
   WebDriver driver

   def setup()
   {
      // make the driver more patient for our VM environments :)
      driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS)
   }

   @Test
   def "All beers should be displayed when entering the main page"()
   {
      when: "I'm on the main page"
         def beerAdvisor = new BeerAdvisorPage(driver, deploymentUrl.toString())
         def beers = beerAdvisor.fetchFromTable()

      then: "I should see all beers"
         BeersAssert.assertThat(beers).hasSize(7)
   }

   @Test
   def "Details of the beer should be accessible from the main page"()
   {
      given: "I'm on the main page"
          def beerAdvisor = new BeerAdvisorPage(driver, deploymentUrl.toString())

      when: "I choose on 'End of History'"
          def endOfHistory = beerAdvisor.detailsOf "End of history"

      then: "I should see all the details"
          endOfHistory.shouldBeNamed("End of history")
                      .shouldCosts(765)
                      .shouldBeFrom("Brew Dog")
                      .shouldHaveAlcoholPercentageOf(55)
   }

}
