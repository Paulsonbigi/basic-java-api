package dev.paulproject.FreecodeCampJavaProject;

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
