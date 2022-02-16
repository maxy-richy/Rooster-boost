package no.movies.rest;

import no.movies.exception.ResourceNotFoundException;
import no.movies.jpa.entity.Movie;
import no.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MoviesController {

	private MovieService movieService;

	@Autowired
	public MoviesController(MovieService movieService) {
		this.movieService = movieService;
	}

	@GetMapping("/movies/byName/{name}")
	public Movie byName(@PathVariable String name) throws ResourceNotFoundException {
		return movieService.getByName(name);
	}

	@GetMapping("/movies/top")
	public List<Movie> topTen() {
		return movieService.getTopRated();
	}

	@PostMapping("/movies/rate/{id}/{rate}")
	public Movie rate(@PathVariable Long id, @PathVariable Long rate) throws ResourceNotFoundException {
		return movieService.rate(id, rate);
	}

}