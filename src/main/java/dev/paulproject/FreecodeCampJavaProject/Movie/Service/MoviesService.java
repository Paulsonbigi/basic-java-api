package dev.paulproject.FreecodeCampJavaProject.Movie.Service;

import dev.paulproject.FreecodeCampJavaProject.Movie.Model.Movie;
import dev.paulproject.FreecodeCampJavaProject.Movie.Repository.MoviesRepository;
import org.bson.types.ObjectId;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoviesService {
    @Autowired
    private MoviesRepository moviesRepository;
    public List<Movie> allMovies(){
        return moviesRepository.findAll();
    }
    public Optional<Movie> getMovieById(@NotNull ObjectId id) {
        return moviesRepository.findById(id.toString());
    }

    public Optional<Movie> getMovieByImdbId(String imdbid) {
        return moviesRepository.findMovieByImdbid(imdbid);
    }

    public Movie createMovie(Movie data) {
        return moviesRepository.save(data);
    }

}
