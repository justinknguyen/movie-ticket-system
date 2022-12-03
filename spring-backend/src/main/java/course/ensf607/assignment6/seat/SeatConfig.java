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
                    (long) 3,
                    'A',
                    true,
                    3
            );
            Seat A4 = new Seat(
                    (long) 4,
                    'A',
                    true,
                    4
            );
            Seat B1 = new Seat(
                    (long) 5,
                    'B',
                    false,
                    1
            );
            Seat B2 = new Seat(
                    (long) 6,
                    'B',
                    false,
                    2
            );
            Seat B3 = new Seat(
                    (long) 7,
                    'B',
                    false,
                    3
            );
            Seat B4 = new Seat(
                    (long) 8,
                    'B',
                    false,
                    4
            );
            Seat C1 = new Seat(
                    (long) 9,
                    'C',
                    false,
                    1
            );
            Seat C2 = new Seat(
                    (long) 10,
                    'C',
                    false,
                    2
            );
            Seat C3 = new Seat(
                    (long) 11,
                    'C',
                    false,
                    3
            );
            Seat C4 = new Seat(
                    (long) 12,
                    'C',
                    false,
                    4
            );
            Seat D1 = new Seat(
                    (long) 13,
                    'D',
                    false,
                    1
            );
            Seat D2 = new Seat(
                    (long) 14,
                    'D',
                    false,
                    2
            );
            Seat D3 = new Seat(
                    (long) 15,
                    'D',
                    false,
                    3
            );
            Seat D4 = new Seat(
                    (long) 16,
                    'D',
                    false,
                    4
            );

            seatRepository.saveAllAndFlush(
                    List.of(A1, A2, A3, A4,
                            B1, B2, B3, B4,
                            C1, C2, C3, C4,
                            D1, D2, D3, D4)
            );
        };
    };
}
