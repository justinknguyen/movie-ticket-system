package course.ensf607.assignment6.ticket;

import com.fasterxml.jackson.annotation.JsonIgnore;
import course.ensf607.assignment6.seat.Seat;
// import course.ensf607.assignment6.course.Course;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ticket")
public class Ticket implements Serializable {

    @Id
    @SequenceGenerator(name = "RegisteredUser_sequence", sequenceName = "RegisteredUser_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RegisteredUser_sequence")
    private Long id;

    private String theatre;

    private String movie;

    private String showtime;

    private Double price;
    private Long seat;

    // Work in Progress
    private long paymentId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seat_id")
    private Seat seats;

    public Ticket() {
    }

    public Ticket(Long id, String theatre, String movie, String showtime, Long seat, Double price) {
        this.id = id;
        this.theatre = theatre;
        this.movie = movie;
        this.showtime = showtime;
        this.seat = seat;
        this.price = price;
    }

    public Ticket(String theatre, String movie, String showtime, Long seat, Double price) {
        this.theatre = theatre;
        this.movie = movie;
        this.showtime = showtime;
        this.seat = seat;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTheatre() {
        return theatre;
    }

    public void setTheatre(String theatre) {
        this.theatre = theatre;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getShowtime() {
        return showtime;
    }

    public void setShowtime(String showtime) {
        this.showtime = showtime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getSeat() {
        return seat;
    }

    public void setSeat(Long seat) {
        this.seat = seat;
    }

    public Seat getSeats() {
        return seats;
    }

    public void setSeats(Seat seats) {
        this.seats = seats;
    }

}
