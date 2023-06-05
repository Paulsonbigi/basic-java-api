package dev.paulproject.FreecodeCampJavaProject.Movie.Service;

import dev.paulproject.FreecodeCampJavaProject.Movie.Model.Movie;
import dev.paulproject.FreecodeCampJavaProject.Movie.Repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MoviesService {
    @Autowired
    private MoviesRepository moviesRepository;
    public List<Movie> allMovies(){
        return moviesRepository.findAll();
    }
}
