package course.ensf607.assignment6.movie;

import course.ensf607.assignment6.showtime.ShowtimeConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class MovieConfig {
    static Movie m1, m2, m3, m4;

    public static Set<Movie> getMovies1 () {
        Set<Movie> movies = new HashSet<>();
        movies.add(m1.setShowtimes(ShowtimeConfig.getShowtimes1()));
        movies.add(m2.setShowtimes(ShowtimeConfig.getShowtimes2()));
        return movies;
    }
    public static Set<Movie> getMovies2 () {
        Set<Movie> movies = new HashSet<>();
        movies.add(m3.setShowtimes(ShowtimeConfig.getShowtimes3()));
        movies.add(m4.setShowtimes(ShowtimeConfig.getShowtimes4()));
        return movies;
    }

    @Bean
    CommandLineRunner createMovies(MovieRepository movieRepository) {
        return args -> {
            m1 = new Movie(
                    (long) 1,
                    "Interstellar",
                    LocalDate.of(2014, 11, 7)
            );

            m2 = new Movie(
                    (long) 2,
                    "Cars 2",
                    LocalDate.of(2011, 6, 24)
            );

            m3 = new Movie(
                    (long) 3,
                    "Top Gun",
                    LocalDate.of(2014, 11, 7)
            );

            m4 = new Movie(
                    (long) 4,
                    "2 Fast 2 Furious",
                    LocalDate.of(2011, 6, 24)
            );

            movieRepository.saveAllAndFlush(
                    List.of(m1, m2, m3, m4)
            );
        };
    };
}
