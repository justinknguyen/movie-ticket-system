package course.ensf607.assignment6.showtime;

import course.ensf607.assignment6.movie.Movie;
import course.ensf607.assignment6.movie.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Configuration
public class ShowtimeConfig {

    @Bean
    CommandLineRunner createShowtimes(ShowtimeRepository showtimeRepository){

        return args -> {
            Showtime st1 = new Showtime(
                    (long) 1,
                    LocalDateTime.of(2022,12,7,16,0)

            );
            Showtime st2 = new Showtime(
                    (long) 2,
                    LocalDateTime.of(2022,12,7,19,0)

            );

            showtimeRepository.saveAllAndFlush(
                    List.of(st1, st2)
            );
        };
    };
}
