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
public class City implements SluggerInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String siren;



    private String name;
    private String code;
    private int population;
    private String slug;


    @OneToMany
    @JsonIgnoreProperties(value = "city")
    private List<PostalCode> postalCodes;

    @ManyToOne
    private Department department;

    @Override
    public String getField() {
        return name;
    }
}