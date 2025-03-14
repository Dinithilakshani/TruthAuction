package org.example.vehical.enitity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    private int c_id;
    @Column(nullable = false)
    private String companyName;

    private String email;
    private int contactNumber;
    private String address;

    @ManyToOne
    @JoinColumn(name = "company_type_id", referencedColumnName = "id")
    private CompanyType companyType;

    @OneToMany(mappedBy = "company")
    private List<User> users;



}
