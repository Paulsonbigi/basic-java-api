package dev.paulproject.FreecodeCampJavaProject.Movie.Contoller;

import dev.paulproject.FreecodeCampJavaProject.Movie.Model.Movie;
import dev.paulproject.FreecodeCampJavaProject.Movie.Service.MoviesService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MoviesController {
    @Autowired
    private MoviesService moviesService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(moviesService.allMovies(), HttpStatus.OK );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable ObjectId id){
        return new ResponseEntity<Optional<Movie>>(moviesService.getMovieById( id), HttpStatus.OK );
    }

    @GetMapping("/imdbid/{imdbid}")
    public ResponseEntity<Optional<Movie>> getMovies(@PathVariable String imdbid){
        return new ResponseEntity<Optional<Movie>>(moviesService.getMovieByImdbId(imdbid), HttpStatus.OK );
    }

    @PostMapping("/create")
    public ResponseEntity<Movie> createMovieEndpoint(@RequestBody Movie movie){
        try {
            Movie createdMovie = moviesService.createMovie(movie);
            return new ResponseEntity<>(createdMovie, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable("id") String id, @RequestBody Movie movieBody) {
        try {
            Optional<Movie> movie = moviesService.getMovieById(new ObjectId(id));
            if(movie.isPresent()){
                Movie _movie = movie.get();
                _movie.setGenres(movieBody.getGenres());
                return  new ResponseEntity<>(moviesService.createMovie(_movie), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
