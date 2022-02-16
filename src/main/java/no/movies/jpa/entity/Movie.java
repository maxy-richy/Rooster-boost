package no.movies.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "movies", uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Boolean won;
    private String category;
    private String nominee;
    private Long rating;
    private Long timesRated;
    private Long averageRating;
}