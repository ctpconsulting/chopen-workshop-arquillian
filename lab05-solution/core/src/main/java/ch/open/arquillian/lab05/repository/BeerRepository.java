package ch.open.arquillian.lab05.repository;

import java.util.Set;

import ch.open.arquillian.lab05.domain.Beer;

public interface BeerRepository {

    Beer getById(Long id);

    Set<Beer> fetchAll();

}