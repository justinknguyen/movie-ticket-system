package course.ensf607.assignment6.payment;

import course.ensf607.assignment6.registereduser.RegisteredUser;
import java.time.LocalDate;

public class Payment {
    private String name;
    private int number;
    private int ccv;
    private double amount;
    private LocalDate releaseDate;
    private double accountBalance;

    public Payment(String name,int number,int ccv,double amount) {
        this.name = name;
        this.number = number;
        this.ccv = ccv;
        this.amount = amount;
        this.releaseDate = LocalDate.now();
        accountBalance = 100; // arbitary starting point, adjusted later
    }

    public Payment(RegisteredUser user, double amount) {
        this.name = user.getName();
        //this.number = user.getCard();
        //this.ccv = user.getCcv();
        this.amount = amount;
        this.releaseDate = LocalDate.now();
    }

    public Payment(RegisteredUser user) {
        this.name = user.getName();
        //this.number = user.getCard();
        //this.ccv = user.getCcv();
        this.amount = 20;
        this.releaseDate = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCcv() {
        return ccv;
    }

    public void setCcv(int ccv) {
        this.ccv = ccv;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

}
