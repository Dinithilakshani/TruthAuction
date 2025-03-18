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
    private String sale_name;
    private LocalDate create_date;
    private LocalDate auction_date;
    private int user_id;


}
