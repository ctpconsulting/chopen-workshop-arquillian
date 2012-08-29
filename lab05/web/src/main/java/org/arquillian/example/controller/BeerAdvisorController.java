package org.arquillian.example.controller;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.arquillian.example.domain.Beer;
import org.arquillian.example.service.BeerService;

import com.google.common.collect.Lists;

@Named
@RequestScoped
public class BeerAdvisorController {

    private List<Beer> beers = Collections.emptyList();

    @Inject
    private BeerService beerService;

    @PostConstruct
    public void loadBeers() {
        beers = Lists.newArrayList(beerService.fetchAll());
    }

    public List<Beer> getBeers() {
        return beers;
    }

}
