## Lab 04 - Walking Skeleton

### Objectives

In this lab you will learn how to leverage the concept of the Walking Skeleton to write your application using Acceptance Test Driven Development technique. Walking Skeleton is the simplest deployable unit of the application providing minimalistic implementation of the feature which we are about to implement. It's intended to make first the acceptance test pass in the automated manner and evolve the implementation in the inner TDD cycles, as described on this nice diagram which we borrowed from the great book [Growing Object-Oriented Software Guided by Tests](http://www.growing-object-oriented-software.com/).

![ATDD cycle from GOOS book](http://ubuntuone.com/3scoC3uEPSymR0Im2HTjy4 "ATDD cycle from GOOS book")

For this purpose we provide a simplified version of the Beer-Advisor web application which displays a bunch of nice beers on the main page. It consists of

* [Spock acceptance test](https://github.com/ctpconsulting/chopen-workshop-arquillian/blob/master/lab04/web/src/test/groovy/ch/open/arquillian/lab04/ui/BeerAdvisorSpecification.groovy) for verifying if all beers are displayed correctly on the screen
	* Spock is a Groovy testing framework which we integrate with Arquillian.
	* The test itself is based on the [Drone extension](http://arquillian.org/guides/functional_testing_using_drone/) which makes it easier to write Selenium/WebDriver tests with Arquillian. 
* [Page Object](http://code.google.com/p/selenium/wiki/PageObjects) to interact with the web site and verify its functionalities - [`BeerAdvisorPage`](https://github.com/ctpconsulting/chopen-workshop-arquillian/blob/master/lab04/web/src/test/java/ch/open/arquillian/lab04/ui/web/BeerAdvisorPage.java).
* A simple domain model and service layer with static content which is used for the UI.
* A JSF-based UI and CDI controller to wire it all together.

After this lab you will know how to:
* Write web applications in ATDD manner and applying the concept of the Walking Skeleton.
* Use Spock with Arquillian to write a test in the BDD mindset.
* Test your persistence layer easy with [Arquillian Persistence Extension](https://github.com/arquillian/arquillian-extension-persistence)

### Task

Your task is to replace the stubbed [`ch.open.arquillian.lab04.BeerService`](https://github.com/ctpconsulting/chopen-workshop-arquillian/blob/master/lab04/core/src/main/java/ch/open/arquillian/lab04/service/BeerService.java) and implement a JPA repository to be used instead.

	public interface BeerRepository {

	    Beer getById(Long id);

	    Set<Beer> fetchAll();

	}

You will need to make [`BeerRepositoryBasicJpaTest`](https://github.com/ctpconsulting/chopen-workshop-arquillian/blob/master/lab04/core/src/test/java/ch/open/arquillian/lab04/repository/BeerRepositoryBasicJpaTest.java) pass. But more importantly the main acceptance test will give confidence that the application is still providing the same functionality!

The final step is to rewrite `BeerRepositoryBasicJpaTest` using [Arquillian Persistence Extension](https://github.com/arquillian/arquillian-extension-persistence) and use data sets to populate the database for your tests.

**Open question:** How we can seed the database for end-to-end test after deploying the application?


