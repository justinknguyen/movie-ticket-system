package course.ensf607.assignment6.theatre;

import course.ensf607.assignment6.movie.Movie;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "theatre")
public class Theatre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tId")
    private Long tId;
    private String name;

    @ManyToMany(cascade = { CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "now_playing",
            joinColumns = {@JoinColumn(name = "tId")},
            inverseJoinColumns = {@JoinColumn(name = "mId")}
    )
    private Set<Movie> movies = new HashSet<>();

    public Theatre() {
    }

    public Theatre(Long id, String name) {
        this.tId = id;
        this.name = name;
    }

    public Long gettId() {
        return tId;
    }

    public Theatre settId(Long id) {
        this.tId = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Theatre setName(String name) {
        this.name = name;
        return this;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public Theatre setMovies(Set<Movie> movies) {
        this.movies = movies;
        return this;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }
}