package course.ensf607.assignment6.payment;

import course.ensf607.assignment6.registereduser.RegisteredUser;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pId")
    private long pId;

    //Payment Type
    private String Type;
    //Description of the Payment Type
    private String Description;

    //User Information
    private String name;

    private String buyerEmail;

    //Credit Card Information
    private int cardNo;
    private int ccv;
    private int expiry;

    //Account balance, charged at end of month
    private double accountBalance;

    //Dates for account management

    private LocalDate creationDate;

    private LocalDate currentTime;




    public Payment(String name, String Type, String Description, int ccv, int cardNo, int expiry, String buyerEmail) {
        this.name = name;
        this.Type = Type;
        this.Description = Description;
        this.cardNo = cardNo;
        this.expiry = expiry;
        this.ccv = ccv;
        this.buyerEmail=buyerEmail;
        accountBalance = 20; // Starts with annual payment
    }

    public Payment(RegisteredUser user) {
        this.name = user.getName();
        accountBalance = 20; // Starts with annual payment
    }


    public Payment() {

    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(LocalDate currentTime) {
        this.currentTime = currentTime;
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
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
