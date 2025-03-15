package org.example.vehical.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private int company_id;
}
