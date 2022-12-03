package course.ensf607.assignment6.payment;

import course.ensf607.assignment6.registereduser.RegisteredUser;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Payment")
public class Payment {

    @Id
    @SequenceGenerator(name = "pid_sequence", sequenceName = "pid_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pid_sequence")
    private long pId;

    // Payment Type
    private String type;
    @ManyToOne
    @JoinColumn(name = "RegisteredUserId")
    RegisteredUser user;

    // Dates for account management

    private LocalDate creationDate;


    public Payment(String type, RegisteredUser user) {
        this.type = type;
        this.user = user;
        this.creationDate = LocalDate.now();

        // accountBalance = 20; // Starts with annual payment
    }

    public Payment(RegisteredUser user) {
        this.user = user;
        this.creationDate = LocalDate.now();
    }

    public Payment() {

    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    // public LocalDate getCurrentTime() {
    // return currentTime;
    // }

    // public void setCurrentTime(LocalDate currentTime) {
    // this.currentTime = currentTime;
    // }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public long getId() {
        return pId;
    }

    public void setId(long pId) {
        this.pId = pId;
    }

    public void setUser(RegisteredUser user) {
        this.user = user;
    }
}
