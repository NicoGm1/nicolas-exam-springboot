package fr.nsurget.nicolasexamspringboot.Centrafake.dto;

import fr.nsurget.nicolasexamspringboot.Centrafake.repository.UserRepository;
import fr.nsurget.nicolasexamspringboot.Centrafake.validator.annotation.UniqueEmail;
import fr.nsurget.nicolasexamspringboot.Centrafake.validator.annotation.UniqueName;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class UserPostDTO {


    @Email
    @UniqueEmail
    private String username;

    @Size(message = "The account password must have at least 5 characters", min = 5)
    private String password;



}
