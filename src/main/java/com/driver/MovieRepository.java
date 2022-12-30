package com.driver;


import java.util.*;
import org.springframework.stereotype.Repository;


@Repository
public class MovieRepository {
    private HashMap<String ,Movie> MovieMap;
    private HashMap<String ,Director> DirectorMap;
    private HashMap<String ,List<String>> MovieDirectorPairMap;

    public MovieRepository() {
        this.MovieMap = new HashMap<>();
        this. DirectorMap = new HashMap<>();
        this.MovieDirectorPairMap = new HashMap<>();
     }


    public void saveMovie(Movie movie){
         
            MovieMap.put(movie.getName(),movie);
          }
    
    public void saveDirector(Director director){
        
            DirectorMap.put(director.getName(),director);
        
    }
    public void saveDirectorPairMap(String movie,String director ){
          if(MovieMap.containsKey(movie) && DirectorMap.containsKey(director)){
              List<String> currentmoviebyDirector=new ArrayList<>();

              if(MovieDirectorPairMap.containsKey(director)){
                  currentmoviebyDirector=MovieDirectorPairMap.get(director);
                  currentmoviebyDirector.add(movie);
              }
              MovieDirectorPairMap.put(director, currentmoviebyDirector);
          }
    }
    public Movie FindMovie(String movie){
           return MovieMap.get(movie);
    }
     public Director FindDirector(String director){
        return DirectorMap.get(director);
     }
     public List<String> GetListMovie(String director){
           List<String> movielist=new ArrayList<>();

           if(MovieDirectorPairMap.containsKey(director)){
              movielist=MovieDirectorPairMap.get(director);
           }
           return movielist;
     }
     public List<String> FindAllmovie(){
        return new ArrayList<>( MovieMap.keySet());
     }

     public void deleteMoviesbyDirector(String director){
             List<String> movies=new ArrayList<>();

             if(MovieDirectorPairMap.containsKey(director)){
                movies=MovieDirectorPairMap.get(director);
             for(String movie : movies){
                if(MovieMap.containsKey(movie)){
                    MovieMap.remove(movie);
                }
             }
             MovieDirectorPairMap.remove(director);
            }
            if(DirectorMap.containsKey(director)){
                DirectorMap.remove(director);
            }
     }

     public void removeAlldirector(){
          List<String> movieset=new ArrayList<>();
          DirectorMap=new HashMap<>();
          for(String director:MovieDirectorPairMap.keySet() ){
             for(String movie :MovieDirectorPairMap.get(director) ){
                 movieset.add(movie);
             }
          }
          for(String movie:movieset){
            if(MovieMap.containsKey(movie)){
                MovieMap.remove(movie);
            }
          }
          MovieDirectorPairMap=new HashMap<>();
     }
     

    

}


