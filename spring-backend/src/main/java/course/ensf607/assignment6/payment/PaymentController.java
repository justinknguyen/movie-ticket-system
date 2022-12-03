package course.ensf607.assignment6.payment;

import java.util.Scanner;

import course.ensf607.assignment6.movie.Movie;
import course.ensf607.assignment6.registereduser.RegisteredUser;
import course.ensf607.assignment6.showtime.Showtime;
import course.ensf607.assignment6.theatre.Theatre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/payment")
public class PaymentController {
    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PutMapping("/confirmPayment/{amount}")
    public ResponseEntity<String> confirmPayment(@PathVariable double amount) {
        paymentService.confirmPayment(amount);
        return ResponseEntity.ok("Confirmed for Payment.");

    }
    @PostMapping("/addPayment")
    public ResponseEntity<String> registerNewPayment(@RequestBody Payment payment) {
        paymentService.addPayment(payment);
        return ResponseEntity.ok("Payment added.");
    }

    @PutMapping("/addRefundPayment/{refundAmount}/{userId}")
    public ResponseEntity<String> refundPayment(@PathVariable long userId, @PathVariable double refundAmount, @PathVariable long ticketId) {
        paymentService.createRefundPayment(userId, refundAmount);
        return ResponseEntity.ok("Refunded");
    }










}



