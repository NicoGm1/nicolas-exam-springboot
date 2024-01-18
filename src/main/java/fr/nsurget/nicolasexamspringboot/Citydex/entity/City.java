package fr.nsurget.nicolasexamspringboot.Citydex.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import fr.nsurget.nicolasexamspringboot.Citydex.entity.interfaces.SluggerInterface;
import fr.nsurget.nicolasexamspringboot.Citydex.json_views.CityJsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
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

    @JsonView(CityJsonView.CityFullView.class)
    private String siren;

    @JsonView(CityJsonView.CityEssentialView.class)
    private String name;

    @JsonView(CityJsonView.CityFullView.class)
    private String code;

    @JsonView(CityJsonView.CityFullView.class)
    private int population;

    @JsonView(CityJsonView.CityFullView.class)
    private String slug;

    @ManyToOne
    @JsonView(CityJsonView.CityFullView.class)
    private Department department;

    @OneToMany(mappedBy = "city")
    @JsonView(CityJsonView.CityFullView.class)
    private List<PostalCode> postalCodes;

    @Override
    public String getField() {
        return name;
    }

}