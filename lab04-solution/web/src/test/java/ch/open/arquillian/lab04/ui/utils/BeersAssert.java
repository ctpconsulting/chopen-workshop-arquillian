package ch.open.arquillian.lab04.ui.utils;

import java.util.Collection;

import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;

import ch.open.arquillian.lab04.ui.web.Beer;

public class BeersAssert extends GenericAssert<BeersAssert, Collection<Beer>>
{

   private BeersAssert(Collection<Beer> actual)
   {
      super(BeersAssert.class, actual);
   }

   public static BeersAssert assertThat(Collection<Beer> beers)
   {
      return new BeersAssert(beers);
   }

   public BeersAssert hasSize(int expected) {
       Assertions.assertThat(this.actual).hasSize(expected);
       return this;
   }

   public BeersAssert shouldContain(Beer ... beers)
   {
      Assertions.assertThat(actual).contains(beers);
      return this;
   }

}
