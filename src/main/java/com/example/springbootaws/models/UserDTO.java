package com.example.springbootaws.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Morris.Okworo on 11/04/2023
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String staffId;
    private String email;
    private String phone;
    private String physicalAddress;
}
