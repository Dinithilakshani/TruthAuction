package org.example.vehical.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
    private int id;
    private String product_name;
    private String chassis_number;
    private String register_number;
    private String brand_name;
    private String image;
    private int user_id;
}
