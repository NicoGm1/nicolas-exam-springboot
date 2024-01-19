package fr.nsurget.nicolasexamspringboot.Centrafake.dto;

import com.fasterxml.jackson.annotation.JsonView;
import fr.nsurget.nicolasexamspringboot.Centrafake.entity.Brand;
import fr.nsurget.nicolasexamspringboot.Centrafake.entity.interfaces.SluggerInterface;
import fr.nsurget.nicolasexamspringboot.Centrafake.json_views.ModelJsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ModelDTO {

    private String name;

    private String brand_id;


}