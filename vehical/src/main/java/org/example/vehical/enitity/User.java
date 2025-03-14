package org.example.vehical.enitity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id

    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private int password;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "user")
    private List<Sale> sales;

    @OneToMany(mappedBy = "user")
    private List<Item> Item;

    @OneToMany(mappedBy = "user")
    private List<SaleItem> saleItems;
}
