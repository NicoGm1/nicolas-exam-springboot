package fr.nsurget.nicolasexamspringboot.Centrafake.entity;

import fr.nsurget.nicolasexamspringboot.Centrafake.entity.interfaces.SluggerInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Listing implements SluggerInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private int producedYear;

    private Long mileage;

    private Double price;

    @CreationTimestamp
    private Date createdAt;

    private String image;

    private String slug;

    @ManyToOne
    private User user;

    @ManyToOne
    private Model model;


    @Override
    public String getField() {
        return "vente-" + model.getBrand().getName() + model.getName() +producedYear + mileage;
    }
}