package pl.coderslab.finalproject.Shop.DTO;

import lombok.Data;

import javax.validation.constraints.*;

import javax.validation.constraints.NotEmpty;

@Data
public class UserDTO {
    @NotEmpty(message = "Password field is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    @NotEmpty(message = "Email field is required")
    @Email(message = "Invalid email address")
    private String email;

    @NotEmpty(message = "Phone number field is required")
    @Pattern(regexp = "\\d{9}", message = "Invalid phone number")
    private String phoneNumber;


    // Getters and setters
}