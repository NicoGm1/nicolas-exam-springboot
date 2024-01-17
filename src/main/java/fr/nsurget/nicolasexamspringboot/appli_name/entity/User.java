package fr.nsurget.nicolasexamspringboot.appli_name.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import fr.nsurget.nicolasexamspringboot.appli_name.entity.interfaces.SluggerInterface;
import fr.nsurget.nicolasexamspringboot.appli_name.repository.UserRepository;
import fr.nsurget.nicolasexamspringboot.appli_name.validator.annotation.UniqueEmail;
import fr.nsurget.nicolasexamspringboot.appli_name.validator.annotation.UniqueName;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.Random;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class User implements SluggerInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please, give a proper name")
    @Size(message = "The account name must have at least 5 characters", min = 5)
    private String name;


    private String email;


    private String password;

    @CreationTimestamp
    private Date createdAt;

    private String slug;

    private String roles = "[]";


    public boolean isAdmin() {
        return roles.contains("[\"ROLE_ADMIN\"]");
    }

    @Override
    public String getField() {
        return name + "-" + new Random().nextInt(9999);
    }
}