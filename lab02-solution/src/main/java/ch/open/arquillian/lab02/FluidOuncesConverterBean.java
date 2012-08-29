package ch.open.arquillian.lab02;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local
public class FluidOuncesConverterBean implements FluidOuncesConverter {

    @Override
    public double convertToMilliliters(double ounces) {
        return ounces * 29.5735296d;
    }

}
