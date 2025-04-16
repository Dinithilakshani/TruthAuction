package org.example.vehical.enitity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.vehical.enums.Role;


import java.util.List;

@Entity

public class User {
    @Id

    private int id;
    @Column(nullable = false, unique = true)
    private String username;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "user")
    private List<Sale> sales;

    @OneToMany(mappedBy = "user")
    private List<Item> Item;

    @OneToMany(mappedBy = "user")
    private List<SaleItem> saleItems;

    public User() {
    }

    public User(int id, String username, String email, String password, Role role, Company company, List<Sale> sales, List<org.example.vehical.enitity.Item> item, List<SaleItem> saleItems) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.company = company;
        this.sales = sales;
        Item = item;
        this.saleItems = saleItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    public List<org.example.vehical.enitity.Item> getItem() {
        return Item;
    }

    public void setItem(List<org.example.vehical.enitity.Item> item) {
        Item = item;
    }

    public List<SaleItem> getSaleItems() {
        return saleItems;
    }

    public void setSaleItems(List<SaleItem> saleItems) {
        this.saleItems = saleItems;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", company=" + company +
                ", sales=" + sales +
                ", Item=" + Item +
                ", saleItems=" + saleItems +
                '}';
    }
}
