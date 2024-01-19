package fr.nsurget.nicolasexamspringboot.Centrafake.entity;

import fr.nsurget.nicolasexamspringboot.Centrafake.entity.interfaces.SluggerInterface;
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
    private Long id;

    private String name;

    private String slug;

    @Override
    public String getField() {
        return name;
    }
}