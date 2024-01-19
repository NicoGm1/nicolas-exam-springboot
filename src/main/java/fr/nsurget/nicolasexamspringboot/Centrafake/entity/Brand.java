package fr.nsurget.nicolasexamspringboot.Centrafake.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.nsurget.nicolasexamspringboot.Centrafake.entity.interfaces.SluggerInterface;
import fr.nsurget.nicolasexamspringboot.Centrafake.json_views.BrandJsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Brand implements SluggerInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(BrandJsonView.BrandEssentialView.class)
    private Long id;

    @JsonView(BrandJsonView.BrandEssentialView.class)
    private String name;

    @JsonView(BrandJsonView.BrandDetailedView.class)
    private String slug;

    @Override
    public String getField() {
        return name;
    }
}