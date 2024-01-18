package fr.nsurget.nicolasexamspringboot.Citydex.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import fr.nsurget.nicolasexamspringboot.Citydex.json_views.CityJsonView;
import fr.nsurget.nicolasexamspringboot.Citydex.json_views.DepartmentJsonView;
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
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonView(DepartmentJsonView.DepartmentEssentialView.class)
    private String name;

    @JsonView(DepartmentJsonView.DepartmentFullView.class)
    private String code;

    @JsonView(DepartmentJsonView.DepartmentFullView.class)
    private String slug;

    @OneToMany(mappedBy = "department")
    @JsonView(DepartmentJsonView.DepartmentFullView.class)
    private List<City> cities;

    @ManyToOne
    @JsonView(DepartmentJsonView.DepartmentFullView.class)
    private Region region;

}