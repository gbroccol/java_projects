package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Film;

import java.util.List;

public interface FilmsRepository {

//    List<Film> findAll();

    void save(Film entity);
}
