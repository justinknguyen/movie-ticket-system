package course.ensf607.assignment6.registereduser;

import course.ensf607.assignment6.ticket.Ticket;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "registeredUser")
public class RegisteredUser implements Serializable {

    @Id
    @SequenceGenerator(name = "RegisteredUser_sequence", sequenceName = "RegisteredUser_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RegisteredUser_sequence")
    private Long id;

    private String email;

    private String password;

    private String name;

    private String address;

    private LocalDate dateRegistered;

    @OneToMany
    @JoinColumn(name = "ruTickets")
    private Set<Ticket> tickets = new HashSet<>();

    public RegisteredUser() {
    }

    public RegisteredUser(Long id, String email, String password, String name, String address) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.address = address;
        this.dateRegistered = LocalDate.now();
    }

    public RegisteredUser(String email, String password, String name, String address) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.address = address;
        this.dateRegistered = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(LocalDate dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public RegisteredUser setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
        return this;
    }

    public void addTickets(Ticket ticket) {
        tickets.add(ticket);
    }
}
