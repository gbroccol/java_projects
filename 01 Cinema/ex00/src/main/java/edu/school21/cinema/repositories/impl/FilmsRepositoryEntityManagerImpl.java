package edu.school21.cinema.repositories.impl;

import edu.school21.cinema.models.Film;
import edu.school21.cinema.repositories.FilmsRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FilmsRepositoryEntityManagerImpl implements FilmsRepository {

    @PersistenceContext
    private EntityManager entityManager;

//    @Override
//    public List<Film> findAll() {
//        return entityManager.createQuery("from film", Film.class).getResultList();
//    }

    @Override
    @Transactional
    public void save(Film entity) {
        entityManager.persist(entity);
    }
}