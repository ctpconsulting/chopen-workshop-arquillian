package ch.open.arquillian.lab1;

import ch.open.arquillian.lab1.HelloWorld;

import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

@RunWith(Arquillian.class)
public class HelloWorldTest
{
   @Inject
   private HelloWorld helloworld;

   @Deployment
   public static JavaArchive createDeployment()
   {
      return ShrinkWrap.create(JavaArchive.class, "test.jar").addClass(HelloWorld.class).addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
   }

   @Test
   public void testIsDeployed()
   {
      Assert.assertNotNull(helloworld);
   }

   @Test
   public void should_say_hello()
   {
      Assert.assertEquals("Hello ch.open", helloworld.hello("ch.open"));
   }
}
