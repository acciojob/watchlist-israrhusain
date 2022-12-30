package com.driver;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    
    @Autowired
    MovieRepository movieRepository;
    public void addMovie(Movie movie){
        movieRepository.saveMovie(movie);
    }
    public void addDirectors(Director director){
        movieRepository.saveDirector(director);
    }
    public void addDirectormoviepair(String director ,String movie){
        movieRepository.saveDirectorPairMap(director,movie);
    }
    public Movie FindMoviebyName(String movie){
        return movieRepository.FindMovie(movie);
    }
    public Director FindDirectorbyName(String director){
        return movieRepository.FindDirector(director);
    }
    public List<String> FindmovieFromDirector(String director){
          return movieRepository.GetListMovie(director);
    }
    public List<String> FindAllmoivies(){
            return movieRepository.FindAllmovie();
    }
    public void deleteDirector(String director){
        movieRepository.deleteMoviesbyDirector(director);
    }
    public void deleteAllDirector(){
        movieRepository.removeAlldirector();
    }
}


