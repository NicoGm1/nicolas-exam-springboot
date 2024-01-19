package fr.nsurget.nicolasexamspringboot.Centrafake.entity;


import fr.nsurget.nicolasexamspringboot.Centrafake.entity.interfaces.SluggerInterface;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class User implements SluggerInterface, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Please, give a proper name")
    @Size(message = "The account name must have at least 5 characters", min = 5)
    private String name;

    private String email;

    private String password;

    private String slug;

    private String roles = "[]";


    public boolean isAdmin() {
        return roles.contains("[\"ROLE_ADMIN\"]");
    }


    public String getField() {
        return name + "-" + id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}