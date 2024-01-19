package fr.nsurget.nicolasexamspringboot.Centrafake.entity;

import fr.nsurget.nicolasexamspringboot.Centrafake.entity.interfaces.SluggerInterface;
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
    private Long id;

    private String name;

    @ManyToOne
    private Brand brand;

    private String slug;

    @Override
    public String getField() {
        return name;
    }

//    @OneToMany
//    private List<Listing> listings;

}