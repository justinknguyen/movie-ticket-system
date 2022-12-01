package course.ensf607.assignment6.theatre;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TheatreConfig {

    @Bean
    CommandLineRunner createTheatres(TheatreRepository theatreRepository){
        return args -> {
            Theatre crowfoot = new Theatre(
                    (long) 1,
                    "Crowfoot"

            );
            Theatre chinook = new Theatre(
                    (long) 2,
                    "Chinook"

            );

            theatreRepository.saveAllAndFlush(
                    List.of(crowfoot, chinook)
            );
        };
    };
}
