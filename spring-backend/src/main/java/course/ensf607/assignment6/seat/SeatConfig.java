package course.ensf607.assignment6.seat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class SeatConfig {
    static Seat A1, A2, A3, A4,
                B1, B2, B3, B4,
                C1, C2, C3, C4,
                D1, D2, D3, D4,
                E1, E2, E3, E4,
                F1, F2, F3, F4,
                G1, G2, G3, G4,
                H1, H2, H3, H4;

    public static Set<Seat> getSeatsA () {
        Set<Seat> seats = new HashSet<>();
        seats.add(A1);
        seats.add(A2);
        seats.add(A3);
        seats.add(A4);
        return seats;
    }
    public static Set<Seat> getSeatsB () {
        Set<Seat> seats = new HashSet<>();
        seats.add(B1);
        seats.add(B2);
        seats.add(B3);
        seats.add(B4);
        return seats;
    }
    public static Set<Seat> getSeatsC () {
        Set<Seat> seats = new HashSet<>();
        seats.add(C1);
        seats.add(C2);
        seats.add(C3);
        seats.add(C4);
        return seats;
    }
    public static Set<Seat> getSeatsD () {
        Set<Seat> seats = new HashSet<>();
        seats.add(D1);
        seats.add(D2);
        seats.add(D3);
        seats.add(D4);
        return seats;
    }
    public static Set<Seat> getSeatsE () {
        Set<Seat> seats = new HashSet<>();
        seats.add(E1);
        seats.add(E2);
        seats.add(E3);
        seats.add(E4);
        return seats;
    }
    public static Set<Seat> getSeatsF () {
        Set<Seat> seats = new HashSet<>();
        seats.add(F1);
        seats.add(F2);
        seats.add(F3);
        seats.add(F4);
        return seats;
    }
    public static Set<Seat> getSeatsG () {
        Set<Seat> seats = new HashSet<>();
        seats.add(G1);
        seats.add(G2);
        seats.add(G3);
        seats.add(G4);
        return seats;
    }
    public static Set<Seat> getSeatsH () {
        Set<Seat> seats = new HashSet<>();
        seats.add(H1);
        seats.add(H2);
        seats.add(H3);
        seats.add(H4);
        return seats;
    }

    @Bean
    CommandLineRunner createSeats(SeatRepository seatRepository) {
        return args -> {
            A1 = new Seat(
                    (long) 1,
                    'A',
                    false,
                    1
            );
            A2 = new Seat(
                    (long) 2,
                    'A',
                    false,
                    2
            );
            A3 = new Seat(
                    (long) 3,
                    'A',
                    true,
                    3
            );
            A4 = new Seat(
                    (long) 4,
                    'A',
                    true,
                    4
            );
            B1 = new Seat(
                    (long) 5,
                    'B',
                    false,
                    1
            );
            B2 = new Seat(
                    (long) 6,
                    'B',
                    false,
                    2
            );
            B3 = new Seat(
                    (long) 7,
                    'B',
                    false,
                    3
            );
            B4 = new Seat(
                    (long) 8,
                    'B',
                    false,
                    4
            );
            C1 = new Seat(
                    (long) 9,
                    'C',
                    false,
                    1
            );
            C2 = new Seat(
                    (long) 10,
                    'C',
                    false,
                    2
            );
            C3 = new Seat(
                    (long) 11,
                    'C',
                    false,
                    3
            );
            C4 = new Seat(
                    (long) 12,
                    'C',
                    false,
                    4
            );
            D1 = new Seat(
                    (long) 13,
                    'D',
                    false,
                    1
            );
            D2 = new Seat(
                    (long) 14,
                    'D',
                    false,
                    2
            );
            D3 = new Seat(
                    (long) 15,
                    'D',
                    false,
                    3
            );
            D4 = new Seat(
                    (long) 16,
                    'D',
                    false,
                    4
            );
            E1 = new Seat(
                    (long) 17,
                    'E',
                    false,
                    1
            );
            E2 = new Seat(
                    (long) 18,
                    'E',
                    false,
                    2
            );
            E3 = new Seat(
                    (long) 19,
                    'E',
                    false,
                    3
            );
            E4 = new Seat(
                    (long) 20,
                    'E',
                    false,
                    4
            );
            F1 = new Seat(
                    (long) 21,
                    'F',
                    false,
                    1
            );
            F2 = new Seat(
                    (long) 22,
                    'F',
                    false,
                    2
            );
            F3 = new Seat(
                    (long) 23,
                    'F',
                    false,
                    3
            );
            F4 = new Seat(
                    (long) 24,
                    'F',
                    false,
                    4
            );
            G1 = new Seat(
                    (long) 25,
                    'G',
                    false,
                    1
            );
            G2 = new Seat(
                    (long) 26,
                    'G',
                    false,
                    2
            );
            G3 = new Seat(
                    (long) 27,
                    'G',
                    false,
                    3
            );
            G4 = new Seat(
                    (long) 28,
                    'G',
                    false,
                    4
            );
            H1 = new Seat(
                    (long) 29,
                    'H',
                    false,
                    1
            );
            H2 = new Seat(
                    (long) 30,
                    'H',
                    false,
                    2
            );
            H3 = new Seat(
                    (long) 31,
                    'H',
                    false,
                    3
            );
            H4 = new Seat(
                    (long) 32,
                    'H',
                    false,
                    4
            );

            seatRepository.saveAllAndFlush(
                    List.of(A1, A2, A3, A4,
                            B1, B2, B3, B4,
                            C1, C2, C3, C4,
                            D1, D2, D3, D4,
                            E1, E2, E3, E4,
                            F1, F2, F3, F4,
                            G1, G2, G3, G4,
                            H1, H2, H3, H4)
            );
        };
    };
}
