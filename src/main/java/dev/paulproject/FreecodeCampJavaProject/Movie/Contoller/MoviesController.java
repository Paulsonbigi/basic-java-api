package dev.paulproject.FreecodeCampJavaProject.Movie.Contoller;

import dev.paulproject.FreecodeCampJavaProject.Movie.Model.Movie;
import dev.paulproject.FreecodeCampJavaProject.Movie.Service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {
    @Autowired
    private MoviesService moviesService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<>(moviesService.allMovies(), HttpStatus.OK );
    }
}
