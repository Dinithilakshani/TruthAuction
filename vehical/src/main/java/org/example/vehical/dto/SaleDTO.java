package org.example.vehical.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO {
    private int id;
    private String saleName;
    private LocalDate createDate;
    private LocalDate AuctionDate;
    private int u_id;


}
