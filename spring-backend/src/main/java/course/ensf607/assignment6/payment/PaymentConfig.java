package course.ensf607.assignment6.payment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PaymentConfig {
    @Bean
    CommandLineRunner createMovies(PaymentRepository paymentRepository){
        return args -> {
            Payment accountOne = new Payment(
                "Hello",
                1,
                1,
                0
            );
            Payment accountTwo = new Payment(
                "World",
                2,
                2,
                0
            );

            paymentRepository.saveAllAndFlush(
                    List.of(accountOne, accountTwo)
            );
        };
    };
}
