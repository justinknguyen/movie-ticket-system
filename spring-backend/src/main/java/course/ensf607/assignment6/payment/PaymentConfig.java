package course.ensf607.assignment6.payment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PaymentConfig {
    @Bean
    CommandLineRunner createPayment(PaymentRepository paymentRepository){
        return args -> {
            Payment accountOne = new Payment(
                    "Joe",
                    "Annual",
                    "Receipt: Annual Due",
                    1,
                    1,
                    0,
                    "user1@gmail.com"

            );
            Payment accountTwo = new Payment(
                    "Jim",
                    "Annual",
                    "Receipt: Annual Due",
                    2,
                    2,
                    0,
                    "user2@gmail.com"
            );

            paymentRepository.saveAllAndFlush(
                    List.of(accountOne, accountTwo)
            );
        };
    };
}
