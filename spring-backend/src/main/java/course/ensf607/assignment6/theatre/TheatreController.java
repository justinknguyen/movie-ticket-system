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
    public TheatreController(TheatreService theatreService, MovieService movieService,
            ShowtimeService showtimeService) {

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

    // add showtime
    @PutMapping("/{tId}/showtimes/{stId}")
    public Theatre addShowtimeToTheatre(@PathVariable Long tId,
            @PathVariable Long stId) {
        Theatre theatre = theatreService.getTheatreById(tId); // is this required?
        Showtime showtime = showtimeService.getShowtimeById(stId);
        theatre.addShowtimes(showtime);
        theatreService.updateTheatre(theatre);

        // ArrayList<Movie> movies = new ArrayList<>(theatre.getMovies());
        return theatre;
    }

    // add movie
    @PutMapping("/{tId}/{mId}/movie/{stId}")
    public Theatre addMoiveToShowtime(@PathVariable Long tId,
            @PathVariable Long stId, @PathVariable Long mId) {
        Theatre theatre = theatreService.getTheatreById(tId); // is this required?
        Showtime showtime = showtimeService.getShowtimeById(stId);
        Movie movie = movieService.getMovieById(mId);
        // showtime.setMovie(movie);
        showtimeService.updateShowtime(showtime);

        theatre.addShowtimes(showtime);
        theatreService.updateTheatre(theatre);

        // ArrayList<Movie> movies = new ArrayList<>(theatre.getMovies());
        return theatre;
    }

    // // get seats by showtimes and theatre and movie
    // @GetMapping("/{tId}/movies/{mId}/showtimes/{stId}/seats")
    // public Set<Seat> getSeatsByShowtimeAndMovieAndTheatre(@PathVariable Long tId,
    // @PathVariable Long mId,
    // @PathVariable Long stId) {
    // Set<Movie> movies = theatreService.getMovieListById(tId);
    // Movie movie = movieService.getMovieById(mId);
    // Showtime showtime = showtimeService.getShowtimeById(stId);
    // return showtime.getSeats();
    // }

    // // get showtimes by theatre and movie
    // @GetMapping("/{tId}/movies/{mId}/showtimes/")
    // public Set<Showtime> getShowtimeByMovieAndTheatre(@PathVariable Long tId,
    // @PathVariable Long mId) {
    // // Theatre theatre = theatreService.getTheatreById(tId); // is this required?
    // // Movie movie = movieService.getMovieById(mId);
    // // // ArrayList<Movie> movies = new ArrayList<>(theatre.getMovies());
    // Set<Movie> movies = theatreService.getMovieListById(tId);
    // Movie movie = movieService.getMovieById(mId);
    // return movie.getShowtimes();
    // }

    // // get movies by theatre
    // @GetMapping("/{tId}/movies/")
    // public Set<Movie> getMovieByTheatre(@PathVariable Long tId) {
    // Set<Movie> movies = theatreService.getMovieListById(tId);
    // return movies;
    // }

    // // add movie to theatre
    // @PutMapping("/{tId}/movies/{mId}")
    // public Theatre addMovieToTheatre(@PathVariable Long tId,
    // @PathVariable Long mId) {
    // Theatre theatre = theatreService.getTheatreById(tId);
    // Movie movie = movieService.getMovieById(mId);
    // theatre.addMovie(movie);
    // theatreService.updateTheatre(theatre);
    // return theatre;
    // }

    // // get seats by showtimes and theatre and movie
    // @GetMapping("/{tId}/movies/{mId}/showtimes/{stId}/seats")
    // public Set<Seat> getSeatsByShowtimeAndMovieAndTheatre(@PathVariable Long tId,
    // @PathVariable Long mId,
    // @PathVariable Long stId) {
    // Set<Movie> movies = theatreService.getMovieListById(tId);
    // Movie movie = movieService.getMovieById(mId);
    // Showtime showtime = showtimeService.getShowtimeById(stId);
    // return showtime.getSeats();
    // }

    // // get showtimes by theatre and movie
    // @GetMapping("/{tId}/movies/{mId}/showtimes/")
    // public Set<Showtime> getShowtimeByMovieAndTheatre(@PathVariable Long tId,
    // @PathVariable Long mId) {
    // // Theatre theatre = theatreService.getTheatreById(tId); // is this required?
    // // Movie movie = movieService.getMovieById(mId);
    // // // ArrayList<Movie> movies = new ArrayList<>(theatre.getMovies());
    // Set<Movie> movies = theatreService.getMovieListById(tId);
    // Movie movie = movieService.getMovieById(mId);
    // return movie.getShowtimes();
    // }

}
