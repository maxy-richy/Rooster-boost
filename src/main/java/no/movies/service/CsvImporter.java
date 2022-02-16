package no.movies.service;

import no.movies.jpa.entity.Movie;
import no.movies.jpa.repository.MovieRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

@Component
@Profile("populate")
public class CsvImporter {

    private MovieRepository movieRepository;

    @Autowired
    public CsvImporter(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @PostConstruct
    public void populateDatabase() throws IOException {
        Reader in = new FileReader("academy_awards.csv");
        Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);
        for (CSVRecord record : records) {
            String category = record.get(1);
            String name = record.get(3);
            String star = record.get(2);
            String[] chunks = name.split("\\{");
            if (chunks.length == 2) {
                name = chunks[0].trim();
            }
            Movie newMovie = new Movie();
            newMovie.setName(name);
            newMovie.setCategory(category);
            newMovie.setNominee(star);
            newMovie.setWon(record.get(4).equalsIgnoreCase("YES") ? true: false);
            try {
                movieRepository.save(newMovie);
                System.out.println("Inserted " + name);
            } catch (Exception e) {

            }
        }
    }
}
