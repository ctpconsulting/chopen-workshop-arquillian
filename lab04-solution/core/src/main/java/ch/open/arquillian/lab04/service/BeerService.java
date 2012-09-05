package ch.open.arquillian.lab04.service;

import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import ch.open.arquillian.lab04.domain.Beer;
import ch.open.arquillian.lab04.repository.BeerRepository;

@RequestScoped
public class BeerService {

    @Inject
    private BeerRepository beerRepository;

    public Beer getById(Long id) {
        return beerRepository.getById(id);
    }

    public Collection<Beer> fetchAll() {
        return beerRepository.fetchAll();
    }

}
