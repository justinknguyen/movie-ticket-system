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

    private RegisteredUser user1;
    private RegisteredUser user2;
    @Bean
    CommandLineRunner createUsers(RegisteredUserRepository registeredUserRepository) {
        return args -> {
            user1 = new RegisteredUser(
                    (long) 1,
                    "user1@gmail.com",
                    "pass",
                    "Joe",
                    "123 Street",
                    391,
                    1234,
                    1828,
                    500.00);
            user2 = new RegisteredUser(
                    (long) 2,
                    "user2@gmail.com",
                    "pass",
                    "Jim",
                    "321 Street",
                    691,
                    5678,
                    1825,
                    600);

            registeredUserRepository.saveAllAndFlush(
                    List.of(user1, user2));
        };
    };

    public RegisteredUser getUser1() {
        return user1;
    }

    public void setUser1(RegisteredUser user1) {
        this.user1 = user1;
    }

    public RegisteredUser getUser2() {
        return user2;
    }

    public void setUser2(RegisteredUser user2) {
        this.user2 = user2;
    }
}
