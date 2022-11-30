package course.ensf607.assignment6.showtime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ShowtimeService {

    private final ShowtimeRepository showtimeRepository;

    @Autowired
    public ShowtimeService(ShowtimeRepository showtimeRepository) {
        this.showtimeRepository = showtimeRepository;
    }

    public List<Showtime> getShowtimes() {
        return showtimeRepository.findAll();
    }

    public void addShowtime (Showtime showtime) {
        Optional<Showtime> showtimeById = showtimeRepository.findById(showtime.getsId());
//        Optional<Showtime> showtimeById = showtimeRepository.findBy(showtime.getShowtime());
        if (showtimeById.isPresent()) {
            throw new IllegalStateException("Showtime already exist!");
        }
        showtimeRepository.save(showtime);
    }

    public void updateShowtime(Showtime showtime) {
        showtimeRepository.save(showtime);
    }

    public Showtime getShowtimeById(Long showtimeId) {
        Optional<Showtime> showtimeById = showtimeRepository.findById(showtimeId);
        if (!showtimeById.isPresent()) {
            throw new IllegalStateException("Showtime doesn't exist!");
        }
        return showtimeById.get();
    }
}
