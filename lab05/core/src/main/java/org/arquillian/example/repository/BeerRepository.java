package org.arquillian.example.repository;

import java.util.Set;

import org.arquillian.example.domain.Beer;

public interface BeerRepository {

    Beer getById(Long id);

    Set<Beer> fetchAll();

}