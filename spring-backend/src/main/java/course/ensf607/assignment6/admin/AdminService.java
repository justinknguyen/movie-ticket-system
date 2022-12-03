package course.ensf607.assignment6.admin;

import course.ensf607.assignment6.registereduser.RegisteredUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAllAdminUsers() {
        return adminRepository.findAll();
    }

    public void addAdminStaff(Admin staff) {
        Optional<Admin> newStaff = adminRepository.findByName(staff.getName());
        if (newStaff.isPresent()) {
            throw new IllegalStateException("Staff already exists!");
        }
        adminRepository.save(staff);
    }

    public void removeAdminStaff(Admin staff) {
        Optional<Admin> newStaff = adminRepository.findByName(staff.getName());
        if (newStaff.isPresent()) {
            throw new IllegalStateException("Staff already exists!");
        }
        adminRepository.save(staff);
    }

}