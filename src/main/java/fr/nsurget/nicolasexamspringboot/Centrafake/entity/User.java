package fr.nsurget.nicolasexamspringboot.Centrafake.entity;


import com.fasterxml.jackson.annotation.JsonView;
import fr.nsurget.nicolasexamspringboot.Centrafake.entity.interfaces.SluggerInterface;
import fr.nsurget.nicolasexamspringboot.Centrafake.json_views.ModelJsonView;
import fr.nsurget.nicolasexamspringboot.Centrafake.json_views.UserJsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class User implements SluggerInterface, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(UserJsonView.UserEssentialView.class)
    private Long id;

    @CreationTimestamp
    @JsonView(UserJsonView.UserDetailedView.class)
    private Date createdAt;

    @JsonView(UserJsonView.UserDetailedView.class)
    private String email;

    @JsonView(UserJsonView.UserDetailedView.class)
    private String password;

    @JsonView(UserJsonView.UserDetailedView.class)
    private String slug;

    private String roles = "[]";

    @JsonView(UserJsonView.UserDetailedView.class)
    @OneToMany (mappedBy = "user")
    private List<Listing> listings;

    @JsonView(UserJsonView.UserDetailedView.class)
    public boolean isAdmin() {
        return roles.contains("[\"ROLE_ADMIN\"]");
    }


    public String getField() {
        return "user-" + id;
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