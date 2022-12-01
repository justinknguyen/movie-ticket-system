package course.ensf607.assignment6.movie;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class MovieConfig {

    @Bean
    CommandLineRunner createMovies(MovieRepository movieRepository){
        return args -> {
            Movie interstellar = new Movie(
                    (long) 1,
                    "Interstellar",
                    LocalDate.of(2014, 11, 7)

            );
            Movie cars2 = new Movie(
                    (long) 2,
                    "Cars 2",
                    LocalDate.of(2011, 6, 24)
            );

            movieRepository.saveAllAndFlush(
                    List.of(interstellar, cars2)
            );
        };
    };
}
