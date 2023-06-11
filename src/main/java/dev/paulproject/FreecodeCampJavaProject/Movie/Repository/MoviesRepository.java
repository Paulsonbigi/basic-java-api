package dev.paulproject.FreecodeCampJavaProject.Movie.Repository;
import dev.paulproject.FreecodeCampJavaProject.Movie.Model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoviesRepository extends MongoRepository<Movie, String> {
    Optional<Movie> findMovieByImdbid(String imdbid);

}