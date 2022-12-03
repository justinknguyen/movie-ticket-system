package course.ensf607.assignment6.payment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PaymentConfig {
    @Bean
    CommandLineRunner createPayment(PaymentRepository paymentRepository) {
        return args -> {
            Payment accountOne = new Payment(
                    "annual",
                    "Joe",
                    "user1@gmail.com",
                    1234,
                    590,
                    1223,
                    500.00);

            Payment accountTwo = new Payment(
                    "annual",
                    "Jim",
                    "user2@gmail.com",
                    5678,
                    592,
                    1224,
                    600.00);

            paymentRepository.saveAllAndFlush(
                    List.of(accountOne, accountTwo));
        };
    };
}
