package course.ensf607.assignment6.payment;
import course.ensf607.assignment6.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }


    public void updatePayment(Payment payment) {


        paymentRepository.save(payment);
    }

    public void addPayment(Payment payment) {
        Optional<Payment> paymentByName = paymentRepository.findPaymentByName(payment.getName());
        if (paymentByName.isPresent()) {
            throw new IllegalStateException("Payment already exist!");
        }
        paymentRepository.save(payment);
    }
}
