## Lab 06 - Beyond the limits

### Objectives

In this installement we will dive into the most appealing part of the Arquillian ecosystem - its extension mechanism. 
We will create a simple extension which will intercept test executions and log messages in the console before and/or after the test.

You will have a chance to explore and understand:
* Available SPIs.
* Event model.
* Prepare your extension package on the client side.
* Client and remote part of the extension.
* Register your own interceptor which can execute logic before and after test execution.

### Task

We introduced the `@Prompt` annotation which can be used for the test and have two parameters.

    @RunWith(Arquillian.class)   
    public class FluidOuncesConverterTest {

        @Deployment
        public static Archive<?> createDeployment() {
            return ShrinkWrap.create(JavaArchive.class, "test.jar")
	                          .addClasses(FluidOuncesConverter.class, FluidOuncesConverterBean.class)
	                          .addPackages(true, "org.fest");
	     }

	     @EJB
	     FluidOuncesConverter converter;

	     @Test
	     @Prompt(before = "before test", after = "after test")
	     public void should_convert_fluid_ounces_to_milliliters() throws Exception {
	         // given
	         double ouncesToConvert = 8d;
	         double expectedMilliliters = 236.5882368d;
 
 	         // when
 	         double ouncesInMl = converter.convertToMilliliters(ouncesToConvert);

	         // then
	         assertThat(ouncesInMl).isEqualTo(expectedMilliliters);
	     }
	 }

The goal is to finish the provided extension skeleton and log messages specified in the `@Prompt` annotation. 

All you need to do is:
* Implement the observer which will extract information from the test method and log it (similar @Observes annotation and concept like in CDI).
* Register it as a part of the [`PromptRemoteExtension`](https://github.com/ctpconsulting/chopen-workshop-arquillian/blob/master/lab06/src/main/java/ch/open/arquillian/lab06/container/PromptRemoteExtension.java)
* [Prepare extension deployment](https://github.com/ctpconsulting/chopen-workshop-arquillian/blob/master/lab06/src/main/java/ch/open/arquillian/lab06/client/PromptExtensionArchiveCreator.java) by adding all classes required at runtime.
