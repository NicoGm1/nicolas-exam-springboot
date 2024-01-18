package fr.nsurget.nicolasexamspringboot.Citydex.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.nsurget.nicolasexamspringboot.Citydex.entity.interfaces.SluggerInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Region implements SluggerInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String code;

    private String slug;

    @OneToMany
    @JsonIgnoreProperties(value = "region")
    private List<Department> departments;

    @Override
    public String getField() {
        return name;
    }
}