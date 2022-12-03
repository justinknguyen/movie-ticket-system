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

    public static Movie getMovies1() {

        return m1;
    }

    public static Movie getMovies2() {

        return m2;
    }

    @Bean
    CommandLineRunner createMovies(MovieRepository movieRepository) {
        return args -> {
            m1 = new Movie(
                    (long) 1,
                    "Interstellar",
                    LocalDate.of(2014, 11, 7));
            m2 = new Movie(
                    (long) 2,
                    "Cars 2",
                    LocalDate.of(2011, 6, 24));

            movieRepository.saveAllAndFlush(
                    List.of(m1, m2));
        };
    };
}
