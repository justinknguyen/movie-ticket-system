package course.ensf607.assignment6.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public void addNewTicket(Ticket ticket) {
        Optional<Ticket> ticket1 = ticketRepository.findBySeat(ticket.getSeat());
        if (ticket1.isPresent()) {
            throw new IllegalStateException("There is already a ticket with that id");
        }
        ticketRepository.save(ticket);
    }

    public void removeTicket(Long id) {
        Ticket ticket1 = ticketRepository.findById(id).get();
        if (ticket1 == null) {
            throw new IllegalStateException("There is no ticket with that id");
        } else {
            ticketRepository.delete(ticket1);
        }
    }

    // public Course getCourseById(Long courseId) {
    // Optional<Course> courseById = courseRepository.findById(courseId);
    // if (!courseById.isPresent()) {
    // throw new IllegalStateException("Course does'nt exist!");
    // }
    // return courseById.get();
    // }
}