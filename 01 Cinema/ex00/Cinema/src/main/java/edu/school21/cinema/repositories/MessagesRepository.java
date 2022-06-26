package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Message;

import java.util.List;

public interface MessagesRepository {
    public List<Message> findAll();
    public void save(Message entity);
}
