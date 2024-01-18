package fr.nsurget.nicolasexamspringboot.Citydex.dto;

import fr.nsurget.nicolasexamspringboot.Citydex.repository.UserRepository;
import fr.nsurget.nicolasexamspringboot.Citydex.validator.annotation.UniqueEmail;
import fr.nsurget.nicolasexamspringboot.Citydex.validator.annotation.UniqueName;
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

    @UniqueName(repositoryClass = UserRepository.class)
    private String name;

    @Email(message = "Please, give a valid email")
    @NotBlank(message = "Please, give an email")
    @UniqueEmail
    private String email;

    @Size(min = 5)
    private String password;

}
