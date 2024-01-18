package fr.nsurget.nicolasexamspringboot.Citydex.dto;

import fr.nsurget.nicolasexamspringboot.Citydex.validator.annotation.UniqueEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class UserPostDTO {


    private String name;

    @Email(message = "Please, give a valid email")
    @NotBlank(message = "Please, give an email")
    @UniqueEmail
    private String email;

    private String password;

}
