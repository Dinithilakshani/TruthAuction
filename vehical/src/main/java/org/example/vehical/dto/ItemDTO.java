package org.example.vehical.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
    private int id;
    private String productName;
    private String chassisNumber;
    private String registerNumber;
    private String brandName;
    private String image;
    private int userId;
}
