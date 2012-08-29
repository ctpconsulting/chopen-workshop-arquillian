package ch.open.arquillian.lab05.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ch.open.arquillian.lab05.domain.Beer;
import ch.open.arquillian.lab05.service.BeerService;

@Named
@RequestScoped
public class BeerDetailsController
{

   @Inject
   BeerService beerService;

   private Long beerId;

   private Beer beer;

   public void loadBeer()
   {
      this.beer = beerService.getById(beerId);
   }

   public Long getBeerId()
   {
      return beerId;
   }

   public void setBeerId(Long beerId)
   {
      this.beerId = beerId;
   }

   public Beer getBeer()
   {
      return beer;
   }

   public void setBeer(Beer beer)
   {
      this.beer = beer;
   }

}
