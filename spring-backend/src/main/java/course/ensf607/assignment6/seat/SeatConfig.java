package course.ensf607.assignment6.seat;

import course.ensf607.assignment6.registereduser.RegisteredUser;
import course.ensf607.assignment6.registereduser.RegisteredUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SeatConfig {

    @Bean
    CommandLineRunner createSeats(SeatRepository seatRepository) {
        return args -> {
            Seat A1 = new Seat(
                    (long) 1,
                    'A',
                    false,
                    1
            );
            Seat A2 = new Seat(
                    (long) 2,
                    'A',
                    false,
                    2
            );
            Seat A3 = new Seat(
                    (long) 2,
                    'A',
                    true,
                    3
            );

            seatRepository.saveAllAndFlush(
                    List.of(A1, A2, A3)
            );
        };
    };
}
