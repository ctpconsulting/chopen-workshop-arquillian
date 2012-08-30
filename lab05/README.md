## Lab 05 - Going into the details

### Objectives

In this lab we will evolve Beer Advisor application from the previous installment, so you can learn how to write acceptance tests in Behaviour Driven Development using Spock with Arquillian Drone.

After this lab you will be able to:
* Test your application from outside of the container (black box), using Arquillian to deploy the bundle and Drone to drive the browser.
* Write clean and concise Selenium/WebDriver UI tests using [Page Objects](http://code.google.com/p/selenium/wiki/PageObjects).
* Test your web application in different browsers and different application serves with minimal configuration thanks to Arquillian.

### Task

You will need to make another acceptance test passing
	
	@Test
    def "Details of the beer should be accessible from the main page"() {
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

Here are the steps:
* Implement new Page Object `BeerDetailsPage` which will encapsulate web elements from the web site and expose Beer details as [simple POJO](https://github.com/ctpconsulting/chopen-workshop-arquillian/blob/master/lab05/web/src/test/java/ch/open/arquillian/lab05/ui/web/Beer.java)
* Extend [`BeerAdvisorPage`](https://github.com/ctpconsulting/chopen-workshop-arquillian/blob/master/lab05/web/src/test/java/ch/open/arquillian/lab05/ui/web/BeerAdvisorPage.java#L35) by implementing `detailsOf` method which will allow to
	* click on the link with the name of the beer (taken as parameter) (_hint_ you can use XPath expression to find the matching link)
	* instantiate `BeerDetailsPage` which fill fetch web elements from the opened page with details of the selected beer
	* extract this information and create `Beer` POJO containing them

