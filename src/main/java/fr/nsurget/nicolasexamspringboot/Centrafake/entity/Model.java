package fr.nsurget.nicolasexamspringboot.Centrafake.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.nsurget.nicolasexamspringboot.Centrafake.entity.interfaces.SluggerInterface;
import fr.nsurget.nicolasexamspringboot.Centrafake.json_views.ListingJsonView;
import fr.nsurget.nicolasexamspringboot.Centrafake.json_views.ModelJsonView;
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
public class Model implements SluggerInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(ModelJsonView.ModelEssentialView.class)
    private Long id;

    @JsonView(ModelJsonView.ModelEssentialView.class)
    private String name;

    @ManyToOne
    @JsonView(ModelJsonView.ModelEssentialView.class)
    private Brand brand;

    @JsonView(ModelJsonView.ModelDetailedView.class)
    private String slug;

    @Override
    public String getField() {
        return name;
    }

//    @OneToMany(mappedBy = "model")
//    private List<Listing> listings;

}