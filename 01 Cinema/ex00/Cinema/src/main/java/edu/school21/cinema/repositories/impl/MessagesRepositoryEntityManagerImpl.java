package edu.school21.cinema.repositories.impl;

import edu.school21.cinema.models.Message;
import edu.school21.cinema.repositories.MessagesRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MessagesRepositoryEntityManagerImpl implements MessagesRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Message> findAll() {
        return entityManager
                .createQuery("from Message", Message.class).getResultList();
    }
    @Override
    @Transactional
    public void save(Message entity) {
        entityManager.persist(entity );
    }
}