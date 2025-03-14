package org.example.vehical.enitity;

import jakarta.persistence.*;
import org.example.vehical.enitity.User;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String saleName;
    private LocalDate createDate;
    private LocalDate AuctionDate;
    private int u_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "sale")
    private List<SaleItem> saleItems;

    public Sale() {}

    public Sale(int id, String saleName, LocalDate createDate, LocalDate auctionDate, int u_id, User user) {
        this.id = id;
        this.saleName = saleName;
        this.createDate = createDate;
        AuctionDate = auctionDate;
        this.u_id = u_id;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSaleName() {
        return saleName;
    }

    public void setSaleName(String saleName) {
        this.saleName = saleName;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getAuctionDate() {
        return AuctionDate;
    }

    public void setAuctionDate(LocalDate auctionDate) {
        AuctionDate = auctionDate;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
