package course.ensf607.assignment6.theatre;

import course.ensf607.assignment6.movie.Movie;
import course.ensf607.assignment6.movie.MovieService;
import course.ensf607.assignment6.showtime.Showtime;
import course.ensf607.assignment6.showtime.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/theatres")
public class TheatreController {

    private final TheatreService theatreService;
    private final MovieService movieService;
    private final ShowtimeService showtimeService;

    @Autowired
    public TheatreController(TheatreService theatreService, MovieService movieService, ShowtimeService showtimeService) {

        this.theatreService = theatreService;
        this.movieService = movieService;
        this.showtimeService = showtimeService;

    }

    @GetMapping()
    public List<Theatre> getTheatres() {
        return theatreService.getTheatres();
    }

    @PostMapping("/addTheatre")
    public void addTheatre(@RequestBody Theatre theatre) {
        theatreService.addTheatre(theatre);
    }

    // add showtime by theatre and movie
    @PutMapping("/{tId}/movies/{mId}/showtimes/{stId}")
    public Movie addShowtimeToMovieAndTheatre(@PathVariable Long tId, @PathVariable Long mId, @PathVariable Long stId) {
        Theatre theatre = theatreService.getTheatreById(tId); // is this required?
        Movie movie = movieService.getMovieById(mId);
        Showtime showtime = showtimeService.getShowtimeById(stId);
        movie.addShowtime(showtime);
        movieService.updateMovie(movie);
//        ArrayList<Movie> movies = new ArrayList<>(theatre.getMovies());
        return movie;
    }

    // get showtimes by theatre and movie
    @GetMapping("/{tId}/movies/{mId}/showtimes/")
    public Set<Showtime> getShowtimeByMovieAndTheatre(@PathVariable Long tId, @PathVariable Long mId) {
        Theatre theatre = theatreService.getTheatreById(tId); // is this required?
        Movie movie = movieService.getMovieById(mId);
//        ArrayList<Movie> movies = new ArrayList<>(theatre.getMovies());
        return movie.getShowtimes();
    }

    // get movies by theatre
    @GetMapping("/{tId}/movies/")
    public Set<Movie> getMovieByTheatre(@PathVariable Long tId) {
        Theatre theatre = theatreService.getTheatreById(tId);
        return theatre.getMovies();
    }

    // add movie to theatre
    @PutMapping("/{tId}/movies/{mId}")
    public Theatre addMovieToTheatre(@PathVariable Long tId,
                                     @PathVariable Long mId) {
        Theatre theatre = theatreService.getTheatreById(tId);
        Movie movie = movieService.getMovieById(mId);
        theatre.addMovie(movie);
        theatreService.updateTheatre(theatre);
        return theatre;
    }
}
