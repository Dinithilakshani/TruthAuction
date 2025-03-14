package org.example.vehical.enitity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
public class CompanyType {
    @Id
    private int id;
    @Column(nullable = false)
    private String companyType;
    @OneToMany(mappedBy = "companyType")
    private List<Company> companies;

    public CompanyType() {
    }

    public CompanyType(int id, String companyType) {
        this.id = id;
        this.companyType = companyType;
        this.companies = companies;
    }
    public CompanyType(int id, String companyType, List<Company> companies) {
        this.id = id;
        this.companyType = companyType;
        this.companies = companies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    @Override
    public String toString() {
        return "CompanyType{" +
                "id=" + id +
                ", companyType='" + companyType + '\'' +
                ", companies=" + companies +
                '}';
    }
}
