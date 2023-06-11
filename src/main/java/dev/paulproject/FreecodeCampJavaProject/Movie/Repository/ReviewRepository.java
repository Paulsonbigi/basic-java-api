package dev.paulproject.FreecodeCampJavaProject.Movie.Repository;

import dev.paulproject.FreecodeCampJavaProject.Movie.Model.Reviews;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<Reviews, ObjectId> {
}