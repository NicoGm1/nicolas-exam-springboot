package fr.nsurget.nicolasexamspringboot.Citydex.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.nsurget.nicolasexamspringboot.Citydex.json_views.PostalCodeJsonView;
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
public class PostalCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonView(PostalCodeJsonView.PostalCodeEssentialView.class)
    private String code;

    @ManyToOne
    @JsonView(PostalCodeJsonView.PostalCodeFullView.class)
    private City city;

}