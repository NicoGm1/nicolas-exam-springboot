package fr.nsurget.nicolasexamspringboot.Citydex.custom_response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponsePopulation {

    private String location;

    private Long population;

}
