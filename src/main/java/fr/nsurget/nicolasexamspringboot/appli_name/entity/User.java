package fr.nsurget.nicolasexamspringboot.appli_name.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import fr.nsurget.nicolasexamspringboot.appli_name.entity.interfaces.SluggerInterface;
import fr.nsurget.nicolasexamspringboot.appli_name.repository.UserRepository;
import fr.nsurget.nicolasexamspringboot.appli_name.validator.annotation.UniqueEmail;
import fr.nsurget.nicolasexamspringboot.appli_name.validator.annotation.UniqueName;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class User implements SluggerInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @UniqueName(repositoryClass = UserRepository.class)
    private String name;

    @UniqueEmail
    @Email
    private String email;


    private String password;

    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd", timezone = "468")
    private Date createdAt;

    private String slug;

    private String roles = "[]";


    public boolean isAdmin() {
        return roles.contains("[\"ROLE_ADMIN\"]");
    }

    @Override
    public String getField() {
        return name;
    }
}