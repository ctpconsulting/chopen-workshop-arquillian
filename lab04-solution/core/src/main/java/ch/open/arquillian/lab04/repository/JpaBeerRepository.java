package ch.open.arquillian.lab04.repository;

import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ch.open.arquillian.lab04.domain.Beer;

@RequestScoped
public class JpaBeerRepository implements BeerRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Beer getById(Long id) {
        return em.find(Beer.class, id);
    }

    @Override
    public Set<Beer> fetchAll() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Beer> query = criteriaBuilder.createQuery(Beer.class);
        Root<Beer> from = query.from(Beer.class);
        CriteriaQuery<Beer> select = query.select(from);

        final Set<Beer> result = new HashSet<Beer>();
        result.addAll(em.createQuery(select).getResultList());

        return result;
    }

}