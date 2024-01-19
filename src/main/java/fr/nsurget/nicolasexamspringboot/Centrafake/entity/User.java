package fr.nsurget.nicolasexamspringboot.Centrafake.entity;


import com.fasterxml.jackson.annotation.JsonView;
import fr.nsurget.nicolasexamspringboot.Centrafake.entity.interfaces.SluggerInterface;
import fr.nsurget.nicolasexamspringboot.Centrafake.json_views.ModelJsonView;
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
    @JsonView(ModelJsonView.ModelEssentialView.class)
    private Long id;

    @CreationTimestamp
    @JsonView(ModelJsonView.ModelDetailedView.class)
    private Date createdAt;

    @JsonView(ModelJsonView.ModelDetailedView.class)
    private String email;

    @JsonView(ModelJsonView.ModelDetailedView.class)
    private String password;

    @JsonView(ModelJsonView.ModelDetailedView.class)
    private String slug;

    private String roles = "[]";

    @JsonView(ModelJsonView.ModelDetailedView.class)
    @OneToMany (mappedBy = "user")
    private List<Listing> listings;

    @JsonView(ModelJsonView.ModelDetailedView.class)
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