package ch.open.arquillian.lab04.service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.RequestScoped;

import ch.open.arquillian.lab04.domain.Beer;
import ch.open.arquillian.lab04.domain.BeerBuilder;
import ch.open.arquillian.lab04.domain.Brewery;
import ch.open.arquillian.lab04.domain.Country;
import ch.open.arquillian.lab04.domain.Type;

@RequestScoped
public class BeerService {

    public Set<Beer> fetchAll() {
        final Set<Beer> beers = new HashSet<Beer>();

        Beer mocnyFull = BeerBuilder.create().named("Mocny Full")
                .withPrice(BigDecimal.valueOf(1.0))
                .havingAlcohol(BigDecimal.valueOf(4.5))
                .from(new Brewery("Kiepski Browar", Country.POLAND))
                .ofType(Type.LAGER).withCode("mocny_full").build();
        beers.add(mocnyFull);

        Brewery brewDog = new Brewery("Brew Dog", Country.SCOTLAND);
        Beer endOfHistory = BeerBuilder.create().named("End of history")
                .withPrice(BigDecimal.valueOf(765.0))
                .havingAlcohol(BigDecimal.valueOf(55.0)).from(brewDog)
                .ofType(Type.BLOND_ALE).withCode("end_of_history").build();

        Beer bismarck = BeerBuilder.create().named("Sink The Bismarck!")
                .withPrice(BigDecimal.valueOf(64.0))
                .havingAlcohol(BigDecimal.valueOf(41.0)).from(brewDog)
                .ofType(Type.QUADRUPEL_IPA).withCode("bismarck").build();

        beers.add(endOfHistory);
        beers.add(bismarck);

        Beer delirium = BeerBuilder.create().named("Delirium Tremens")
                .withPrice(BigDecimal.valueOf(10.0))
                .havingAlcohol(BigDecimal.valueOf(8.5))
                .from(new Brewery("Brouwerij Huyghe", Country.BELGIUM))
                .ofType(Type.PALE_ALE).withCode("delirium").build();
        beers.add(delirium);

        Beer kwak = BeerBuilder.create().named("Pauwel Kwak")
                .withPrice(BigDecimal.valueOf(4.0))
                .havingAlcohol(BigDecimal.valueOf(8.4))
                .from(new Brewery("Brouwerij Bosteels", Country.BELGIUM))
                .ofType(Type.AMBER).withCode("kwak").build();
        beers.add(kwak);

        Beer bugel = BeerBuilder.create().named("Bügel")
                .withPrice(BigDecimal.valueOf(3.0))
                .havingAlcohol(BigDecimal.valueOf(4.8))
                .from(new Brewery("Feldschlösschen", Country.SWITZERLAND))
                .ofType(Type.VIENNA).withCode("bugel").build();
        beers.add(bugel);

        Beer appenzellerSchwarzKrystall = BeerBuilder.create()
                .named("Appenzeller Schwarzer Kristall")
                .withPrice(BigDecimal.valueOf(4.0))
                .havingAlcohol(BigDecimal.valueOf(6.3))
                .from(new Brewery("Locher", Country.SWITZERLAND))
                .ofType(Type.SCHWARZBIER).withCode("schwarzer_kristall")
                .build();
        beers.add(appenzellerSchwarzKrystall);

        return beers;
    }

}
