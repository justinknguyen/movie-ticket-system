package course.ensf607.assignment6.admin;

import course.ensf607.assignment6.movie.Movie;
import course.ensf607.assignment6.movie.MovieService;
import course.ensf607.assignment6.registereduser.RegisteredUser;
import course.ensf607.assignment6.registereduser.RegisteredUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/admin/")
public class AdminController {

    private final AdminService adminService;
    private final MovieService movieService;
    private final RegisteredUserService registeredUserService;

    @Autowired
    public AdminController(AdminService adminService, MovieService movieService, RegisteredUserService registeredUserService) {
        this.adminService = adminService;
        this.registeredUserService = registeredUserService;
        this.movieService = movieService;
    }

    @GetMapping("/all")
    public List<Admin> getAllUsers() {
        return adminService.getAllAdminUsers();
    }

    @PostMapping("/addRegisteredUser")
    public void addNewUser(@RequestBody RegisteredUser registeredUser) {
        registeredUserService.addNewUser(registeredUser);
    }

    @DeleteMapping("/removeRegisteredUser")
    public void removeNewUser(@RequestBody RegisteredUser registeredUser) {
        registeredUserService.removeNewUser(registeredUser);
    }

    @PostMapping("/addMovie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
        return ResponseEntity.ok("Movie added.");
    }

    @DeleteMapping("/removeMovie")
    public void removeMovie(@RequestBody Movie movie) {
        movieService.removeMovie(movie);
    }

    @PostMapping("/addAdminStaff")
    public void addAdminStaff(@RequestBody Admin staff) {
        adminService.addAdminStaff(staff);
    }

    @PostMapping("/removeAdminStaff")
    public void removeAdminStaff(@RequestBody Admin staff) {
        adminService.removeAdminStaff(staff);
    }

}
