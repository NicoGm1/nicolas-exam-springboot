package fr.nsurget.nicolasexamspringboot.Centrafake.rest_controlleur;

import fr.nsurget.nicolasexamspringboot.Centrafake.entity.Model;
import fr.nsurget.nicolasexamspringboot.Centrafake.mapping.ApiUrlRoute;
import fr.nsurget.nicolasexamspringboot.Centrafake.service.ModelService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(ApiUrlRoute.URL_API_MODEL)
public class ModelRestController {

    private ModelService modelService;

    @GetMapping
    public List<Model> list() {
        return this.modelService.findAll();
    }


}