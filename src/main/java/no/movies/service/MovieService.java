package no.movies.service;

import no.movies.exception.ResourceNotFoundException;
import no.movies.jpa.entity.Movie;
import no.movies.jpa.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie getByName(String name) throws ResourceNotFoundException {
        return movieRepository.findByNameEquals(name).orElseThrow(() -> new ResourceNotFoundException("Movie was not found by name: " + name));
    }

    public Movie rate(long id, long rating) throws ResourceNotFoundException {
        Movie m = movieRepository.findMovieForUpdate(id).orElseThrow(() -> new ResourceNotFoundException("Movie does not exist, id = " + id));
        m.setRating(m.getRating() == null ? rating : m.getRating() + rating);
        m.setTimesRated(m.getTimesRated() == null ? 1 : m.getTimesRated() + 1);
        m.setAverageRating(m.getRating() / m.getTimesRated());
        movieRepository.saveAndFlush(m);
        return m;
    }

    public List<Movie> getTopRated() {
        return movieRepository.findAllWhereAverageRatingNotNull();
    }
}