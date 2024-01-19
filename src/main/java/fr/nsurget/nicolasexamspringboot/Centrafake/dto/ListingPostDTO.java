package fr.nsurget.nicolasexamspringboot.Centrafake.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ListingPostDTO {

    @NotBlank
    @Size(min = 8)
    private String title;

    private Long mileage;

    private Double price;

    @NotBlank
    private Long user_id;

    @NotBlank
    private Long model_id;

}