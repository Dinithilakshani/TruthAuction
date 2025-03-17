package org.example.vehical.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleItemDTO {
private int id;
private double biddingPrice;
private LocalDate time;
private boolean issold;
private int item_id;
private int sale_id;
private int user_id;



}
