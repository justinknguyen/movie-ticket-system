package course.ensf607.assignment6.registereduser;

import course.ensf607.assignment6.movie.Movie;
import course.ensf607.assignment6.movie.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class RegisteredUserConfig {

    @Bean
    CommandLineRunner createUsers(RegisteredUserRepository registeredUserRepository) {
        return args -> {
            RegisteredUser guest = new RegisteredUser(
                    (long) 1,
                    "guest",
                    "guest",
                    "guest",
                    "guest",
                    0,
                    0,
                    0);

            RegisteredUser user1 = new RegisteredUser(
                    (long) 2,
                    "user1@gmail.com",
                    "pass",
                    "Joe",
                    "123 Street",
                    391,
                    1234,
                    1828);
            RegisteredUser user2 = new RegisteredUser(
                    (long) 3,
                    "user2@gmail.com",
                    "pass",
                    "Jim",
                    "321 Street",
                    691,
                    5678,
                    1825);

            registeredUserRepository.saveAllAndFlush(
                    List.of(guest, user1, user2));
        };
    };
}
