## Lab 01 - Getting ready with Arquillian

### Objectives

During this lab you will learn:

* How to create a project with Forge
* Add Arquillian to a project using Forge
* Create an Arquillian Test

### Task

This is a step-by-step tutorial:

* Start Forge with the `forge` command.
* Create a new project with the `new-project` command. **Tip**: Use tab to see command options, or the Forge `help` command. Use `ch.open.lab1` as top level package.
* Add CDI support to your project with the `beans setup` command.
* The resulting project is already importable into Eclipse (using the Maven import)
* Install the Forge Arquillian plugin with `forge install-plugin arquillian`
* Add Arquillian support with the `arquillian setup` command. Select the GlassFish Embedded Container (make sure to select the GlassFish dependency with version 3.1.1).
* Add a `HelloWorld` class to your project (if you don't want to use Eclipse, use the Forge `edit` command):

```java
package ch.open.lab1;

public class HelloWorld {

    public String hello(String name) {
        return "Hello " + name;	
    }
	
}
```

* Create an Arquillian test for the `HelloWorld` class by using the Arquillian `arquillian create-test` command (use again tab to see the options).
* You can look at the created test with `less .`
* Add a new test to the class, e.g.

```java
   @Test
   public void should_say_hello() {
      Assert.assertEquals("Hello ch.open", helloworld.hello("ch.open"));
   }
```

* Run the test using `mvn test -P GLASSFISH_EMBEDDED_3.1`
* Have a look at the console output.

**Congratulations**! You have just run your first Arquillian test.

