package course.ensf607.assignment6.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public void addMovie(Movie movie) {
        Optional<Movie> movieByName = movieRepository.findByName(movie.getName());
        if (movieByName.isPresent()) {
            throw new IllegalStateException("Showtime already exist!");
        }
        movieRepository.save(movie);
    }

    public void updateMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public Movie getMovieById(Long movieId) {
        Optional<Movie> movieById = movieRepository.findById(movieId);
        if (!movieById.isPresent()) {
            throw new IllegalStateException("Showtime doesn't exist!");
        }
        return movieById.get();
    }
}
