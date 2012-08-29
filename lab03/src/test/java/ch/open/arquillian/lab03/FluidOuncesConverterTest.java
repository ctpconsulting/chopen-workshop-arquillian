package ch.open.arquillian.lab03;

import static org.fest.assertions.Assertions.*;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import ch.open.arquillian.lab03.FluidOuncesConverter;
import ch.open.arquillian.lab03.FluidOuncesConverterBean;

@RunWith(Arquillian.class)
public class FluidOuncesConverterTest {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap
                .create(JavaArchive.class, "test.jar")
                .addClasses(FluidOuncesConverter.class,
                        FluidOuncesConverterBean.class)
                .addPackages(true, "org.fest");
    }

    @EJB
    FluidOuncesConverter converter;

    @Test
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
