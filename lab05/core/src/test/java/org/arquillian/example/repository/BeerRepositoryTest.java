package org.arquillian.example.repository;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Set;

import javax.inject.Inject;

import org.arquillian.example.domain.Beer;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class BeerRepositoryTest
{

   @Deployment
   public static Archive<?> createDeployment()
   {
      return ShrinkWrap.create(JavaArchive.class, "test.jar")
                       .addPackage(Beer.class.getPackage())
                       .addPackage(BeerRepository.class.getPackage())
                       .addPackages(true, "org.fest")
                       .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                       .addAsManifestResource("test-persistence.xml", "persistence.xml");
   }

   @Inject
   BeerRepository beerRepository;

   @Test
   @UsingDataSet("beers.yml")
   public void should_find_all_beers() throws Exception
   {
      // given
      int expectedAmountOfBeers = 7;

      // when
      Set<Beer> beers = beerRepository.fetchAll();

      // then
      assertThat(beers).hasSize(expectedAmountOfBeers);
   }

}
