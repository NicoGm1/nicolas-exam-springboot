package fr.nsurget.nicolasexamspringboot.Citydex.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import fr.nsurget.nicolasexamspringboot.Citydex.entity.interfaces.SluggerInterface;
import fr.nsurget.nicolasexamspringboot.Citydex.json_views.RegionJsonView;
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
    private int id;

    @JsonView(RegionJsonView.RegionEssentialView.class)
    private String name;

    @JsonView(RegionJsonView.RegionFullView.class)
    private String code;

    @JsonView(RegionJsonView.RegionFullView.class)
    private String slug;

    @OneToMany(mappedBy = "region")
    @JsonView(RegionJsonView.RegionFullView.class)
    private List<Department> departments;

    @Override
    public String getField() {
        return name;
    }
}