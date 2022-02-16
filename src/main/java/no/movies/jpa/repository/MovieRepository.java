package no.movies.jpa.repository;

import no.movies.jpa.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findByNameEquals(String name);

    @Query(value = "SELECT * FROM movies a WHERE a.id = :id FOR UPDATE", nativeQuery = true)
    Optional<Movie> findMovieForUpdate(Long id);

    @Query(value = "select * from movies c " +
            "where c.average_rating is not null " +
            "order by c.average_rating desc limit 10", nativeQuery = true)
    List<Movie> findAllWhereAverageRatingNotNull();
}