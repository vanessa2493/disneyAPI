package com.example.disneyapi.services;

import com.example.disneyapi.entities.Genre;
import com.example.disneyapi.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getGenres(){
        return genreRepository.findAll();
    }

    public void save(Genre genre){
        genreRepository.save(genre);
    }

}
