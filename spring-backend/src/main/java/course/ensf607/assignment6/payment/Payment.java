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
    private String name;
    private int cardNo;
    private int ccv;
    private int expiry;
    private double accountBalance;

    public Payment(String name,int ccv, int cardNo, int expiry) {
        this.name = name;
        this.cardNo = cardNo;
        this.expiry = expiry;
        this.ccv = ccv;
        accountBalance = 100; // arbitary starting point, adjusted later
    }

    public Payment(RegisteredUser user) {
        this.name = user.getName();
        accountBalance = 100; // arbitary starting point, adjusted later
    }




    public Payment() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getpId() {
        return pId;
    }

    public void setpId(long pId) {
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
