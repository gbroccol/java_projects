package edu.school21.cinema.services;

import edu.school21.cinema.models.Film;
import edu.school21.cinema.repositories.FilmsRepository;
import edu.school21.cinema.repositories.impl.FilmsRepositoryEntityManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FilmsService {

    private FilmsRepository filmsRepository;

    @Autowired
    public FilmsService(FilmsRepositoryEntityManagerImpl filmsRepository) {
        this.filmsRepository = filmsRepository;
    }

//    public List<Film> getfilms() {
//
//    }
}
