package course.ensf607.assignment6.payment;
import java.util.Scanner;
import course.ensf607.assignment6.registereduser.RegisteredUser;

import java.util.Optional;

public class PaymentController {
    private Payment payment;
    private PaymentRepository paymentRepository;

    public PaymentController(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    public void sendPayment(double amount){
        requestInformation(amount);
        confirmPayment(amount);
    }

    private void requestInformation(double amount){
        Scanner object = new Scanner(System.in);
        System.out.println("Please enter your name as it appear on your card: ");
        String name = object.nextLine();

        System.out.println("Please enter your card number: ");
        int number = object.nextInt();

        System.out.println("Please enter the ccv number on the back of your card: ");
        int ccv = object.nextInt();

        object.close();

        payment = new Payment(name,number,ccv,amount);
    }

    public void sendPayment(RegisteredUser user, double amount){
        payment = new Payment(user, amount);
        confirmPayment(amount);
    }

    public void sendPayment(RegisteredUser user){
        payment = new Payment(user);
        confirmPayment(20);
    }

    public Boolean verifyInformation(double amount){
        Boolean success = false;
        Optional<Payment> paymentFound = paymentRepository.findAccount(payment.getNumber());
        if (paymentFound.isPresent()) {
            if (paymentFound.get().getAccountBalance() >= amount){
                payment.setAccountBalance(paymentFound.get().getAccountBalance()-amount);
                success = true;
            }
        }
        return success;
    }
    public void confirmPayment(double amount){
        if (verifyInformation(amount) == false)
        {
            System.out.println("Invalid Account, please try again"); 
            payment = null;
        }
        else{
            System.out.println("Payment successfull, email reciept");
        }
    }

}
