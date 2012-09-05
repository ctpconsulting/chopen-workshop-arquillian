package ch.open.arquillian.lab04.repository;

import java.util.Collection;

import ch.open.arquillian.lab04.domain.Beer;

public interface BeerRepository {

    Beer getById(Long id);

    Collection<Beer> fetchAll();

}