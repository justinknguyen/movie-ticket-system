package course.ensf607.assignment6.payment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import course.ensf607.assignment6.registereduser.RegisteredUserConfig;

@Configuration
public class PaymentConfig {

    RegisteredUserConfig config;
    @Bean
    CommandLineRunner createPayment(PaymentRepository paymentRepository) {
        return args -> {
            Payment paymentOne = new Payment(
                    "annual",
                    config.getUser1()
                    );

            Payment paymentTwo = new Payment(
                    "annual",
                    config.getUser2());

            paymentRepository.saveAllAndFlush(
                    List.of(paymentOne, paymentTwo));
        };
    };
}
