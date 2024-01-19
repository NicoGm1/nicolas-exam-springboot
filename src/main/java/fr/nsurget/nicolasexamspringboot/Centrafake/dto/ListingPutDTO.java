package fr.nsurget.nicolasexamspringboot.Centrafake.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ListingPutDTO {



    private String title;

    private String description;

    private int producedYear;

    private Long mileage;

    private Double price;

    private String image;

    private Long user_id;

    private Long model_id;

}