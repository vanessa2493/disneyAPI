package com.example.disneyapi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movie_id;
    private String title;
    private String image_url;
    private String launch_date;
    private Integer score;
    @JsonBackReference//Se establece que es el hijo de la referencia ManyToMany
    @ManyToMany (mappedBy = "movies", fetch = FetchType.LAZY)
    private List<Character> characters;
    @ManyToMany (mappedBy = "movies", fetch = FetchType.LAZY)
    private List<Genre> genres;

    public Movie() {
    }

    public Integer getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Integer movie_id) {
        this.movie_id = movie_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getLaunch_date() {
        return launch_date;
    }

    public void setLaunch_date(String launch_date) {
        this.launch_date = launch_date;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movie_id=" + movie_id +
                ", title='" + title + '\'' +
                ", image_url='" + image_url + '\'' +
                ", launch_date='" + launch_date + '\'' +
                ", score=" + score +
                ", characters=" + characters +
                '}';
    }
}

