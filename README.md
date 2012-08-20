## Java EE testing revisited with Arquillian

### What is this?

**Java EE testing revisited with Arquillian** is a full day workshop under [ch/open](http://www.ch-open.ch/wstage/workshop-tage/aktuelles-programm-2012/) intiative.  It will be held by Cambridge Technology Partners Java passionates - Thomas Hug and Bartosz Majsak.
The workshop will take place on 6th of September. 

This repository is intended for storing all the labs and other complementary materials used during the workshop.

### Summary

Unit testing is one of the key techniques helping developers to deliver high quality software. But relying only on it is most of the times just an illusion of safety. Eventually we need to verify how our components are interacting or whether running in the target environment does not end up with some unexpected behaviour. Last but not least it all amounts to whether your application is providing the end user with what he or she is really expecting.
Arquillian is an innovative and highly extensible testing platform for the JVM that enables developers to easily create automated integration, functional and acceptance tests for Java middleware.

### Program

During this workshop you will learn how to leverage the [Arquillian](http://arquillian.org/) ecosystem for:

* writing your tests in a clean, narrative way by applying a Behaviour Driven Development approach
* testing your application components such as EJBs, REST web services, CDI or Spring beans using Arquillian and its extensions
* effectively testing your persistence code using the Arquillian Persistence Extension
* testing the entire web application from the end user perspective using WebDriver and the Page Objects pattern combined with Arquillian Drone which makes development of functional tests using Selenium/WebDriver a breeze.

But what’s more important, how to keep you focused on writing the tests and not worrying about all the burden and boilerplate around. No more custom scripts or copy-paste Maven configurations. No more full builds. Regardless of how complex it becomes, executing an Arquillian test is as simple as selecting “Run Test” in the IDE or executing the “test” goal from the build tool.

### Virtual Machine

Software Development Environment for workshop is based on Ubuntu 12.04 64bit, with following components pre-installed
* JDK 6 & 7
* Maven 3.0.4 with command line autocompletion and output coloring
* Eclipse 3.7 with following plugins
  * JBoss Tools 3.3
  * Maven integration
  * Groovy Support
  * JUnit & TestNG
  * AnyEdit
* JBoss Forge
* MySQL 5.5
* JBoss AS 4.2.3.GA, 5.1.0.GA, 7.0.2.Final, 7.1.1.Final

Credentials:
username: arq
password: letmein

OVA image is available under [following location](http://images.workshoptage.ch/images/ws15/).