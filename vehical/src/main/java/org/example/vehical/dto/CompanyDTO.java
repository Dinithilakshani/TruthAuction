package org.example.vehical.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CompanyDTO {

    private int c_id;
    private String companyName;
    private int companyTypeId;
    private String email;
    private int contactNumber;
    private String address;


}
