package course.ensf607.assignment6.ticket;

import course.ensf607.assignment6.payment.Payment;
import course.ensf607.assignment6.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/ticket/")
public class TicketUserController {

    private final TicketService ticketService;

    private final PaymentService paymentService;

    // private final StudentService studentService;

    @Autowired
    public TicketUserController(TicketService ticketService, PaymentService paymentService) {
        this.ticketService = ticketService;
        this.paymentService = paymentService;
    }

    @GetMapping("all")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @PostMapping("add")
    public void addNewTicket(@RequestBody Ticket ticket) {
        ticketService.addNewTicket(ticket);
    }

    @DeleteMapping("delete/{id}")
    public void removeTicket(@PathVariable Long id) {
        ticketService.removeTicket(id);
    }

    @GetMapping("getTicketToCancel/{id}")
    public Ticket getTicketToCancel(@PathVariable Long id) {return ticketService.FindById(id);}

   // @PostMapping("createRefundPayment")
   // public void createRefundPayment(@RequestBody Payment payment){paymentService.createRefundPayment(payment);}

    // @GetMapping("{email}")
    // public RegisteredUser getByEmail(@PathVariable String email) {
    // return registeredUserService.findByEmail(email);
    // }

    // @PutMapping("{courseId}/students/{studentId}")
    // public Course enrollStudentToCourse(@PathVariable Long courseId,
    // @PathVariable Long studentId) {
    // Course course = courseService.getCourseById(courseId);
    // Student student = studentService.getStudentById(studentId);
    // course.enrolledStudents(student);
    // courseService.updateCourse(course);
    // return course;
    // }
}
