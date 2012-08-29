package org.arquillian.example.service;

import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.arquillian.example.domain.Beer;
import org.arquillian.example.repository.BeerRepository;

@RequestScoped
public class BeerService {

    @Inject
    private BeerRepository beerRepository;

    public Beer getById(Long id) {
        return beerRepository.getById(id);
    }

    public Set<Beer> fetchAll() {
        return beerRepository.fetchAll();
    }

}
