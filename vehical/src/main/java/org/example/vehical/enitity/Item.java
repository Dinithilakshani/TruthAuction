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
public class Item {
@Id
    private int id;
    private String product_name;
    private String chassis_number;
    private String register_number;
    private String brand_name;
    private String image;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @OneToMany(mappedBy = "item")
    private List<SaleItem> saleItems;



}
