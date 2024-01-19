package fr.nsurget.nicolasexamspringboot.Centrafake.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.nsurget.nicolasexamspringboot.Centrafake.entity.interfaces.SluggerInterface;
import fr.nsurget.nicolasexamspringboot.Centrafake.json_views.BrandJsonView;
import fr.nsurget.nicolasexamspringboot.Centrafake.json_views.ListingJsonView;
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
    @JsonView(ListingJsonView.ListingEssentialView.class)
    private Long id;

    @JsonView(ListingJsonView.ListingDetailedView.class)
    private String title;

    @JsonView(ListingJsonView.ListingDetailedView.class)
    private String description;

    @JsonView(ListingJsonView.ListingDetailedView.class)
    private int producedYear;

    @JsonView(ListingJsonView.ListingDetailedView.class)
    private Long mileage;

    @JsonView(ListingJsonView.ListingEssentialView.class)
    private Double price;

    @CreationTimestamp
    @JsonView(ListingJsonView.ListingDetailedView.class)
    private Date createdAt;

    @JsonView(ListingJsonView.ListingDetailedView.class)
    private String image;

    @JsonView(ListingJsonView.ListingDetailedView.class)
    private String slug;

    @ManyToOne
    @JsonView(ListingJsonView.ListingEssentialView.class)
    private User user;

    @ManyToOne
    @JsonView(ListingJsonView.ListingEssentialView.class)
    private Model model;


    @Override
    public String getField() {
        return "vente-" + model.getBrand().getName() + model.getName() +producedYear + mileage;
    }
}