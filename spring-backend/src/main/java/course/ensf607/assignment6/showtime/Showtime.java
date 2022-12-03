package course.ensf607.assignment6.showtime;

import course.ensf607.assignment6.movie.Movie;
import course.ensf607.assignment6.seat.Seat;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
//import course.ensf607.assignment6.showtime.Seat;

@Entity
@Transactional
@Table(name = "showtime")
public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stId")
    private long stId;
    private LocalDateTime showtime;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_stId", referencedColumnName = "stId")
    private Set<Seat> seats = new HashSet<>();

    public Showtime() {
    }

    public Showtime(Long id, LocalDateTime showtime) {
        this.stId = id;
        this.showtime = showtime;
    }

    public Long getsId() {
        return stId;
    }

    public Showtime setsId(Long id) {
        this.stId = id;
        return this;
    }

    public LocalDateTime getShowtime() {
        return showtime;
    }

    public Showtime setShowtime(LocalDateTime showtime) {
        this.showtime = showtime;
        return this;
    }

    public Set<Seat> getSeats() {
        return seats;
    }

    public Showtime setSeats(Set<Seat> seats) {
        this.seats = seats;
        return this;
    }
}