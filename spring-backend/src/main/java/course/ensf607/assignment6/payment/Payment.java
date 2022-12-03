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
    // Description of the Payment Type

    // User Information
    private String name;

    private String buyerEmail;

    // Credit Card Information
    private int cardNo;
    private int ccv;
    private int expiry;

    // Account balance, charged at end of month
    private double accountBalance;

    // Dates for account management

    private LocalDate creationDate;

    // private LocalDate currentTime;

    public Payment(String type, String name, String buyerEmail, int cardNo, int ccv, int expiry,
            double accountBalance) {
        this.name = name;
        this.type = type;
        this.cardNo = cardNo;
        this.expiry = expiry;
        this.ccv = ccv;
        this.buyerEmail = buyerEmail;
        this.accountBalance = accountBalance;
        this.creationDate = LocalDate.now();

        // accountBalance = 20; // Starts with annual payment
    }

    public Payment(RegisteredUser user) {
        this.name = user.getName();
        // accountBalance = 20; // Starts with annual payment
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

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return pId;
    }

    public void setId(long pId) {
        this.pId = pId;
    }

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public int getCcv() {
        return ccv;
    }

    public void setCcv(int ccv) {
        this.ccv = ccv;
    }

    public int getExpiry() {
        return expiry;
    }

    public void setExpiry(int expiry) {
        this.expiry = expiry;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

}
