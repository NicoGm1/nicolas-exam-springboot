package fr.nsurget.nicolasexamspringboot.Centrafake.rest_controlleur;

import com.fasterxml.jackson.annotation.JsonView;
import fr.nsurget.nicolasexamspringboot.Centrafake.dto.ModelDTO;
import fr.nsurget.nicolasexamspringboot.Centrafake.entity.Listing;
import fr.nsurget.nicolasexamspringboot.Centrafake.entity.Model;
import fr.nsurget.nicolasexamspringboot.Centrafake.entity.User;
import fr.nsurget.nicolasexamspringboot.Centrafake.json_views.ModelJsonView;
import fr.nsurget.nicolasexamspringboot.Centrafake.mapping.ApiUrlRoute;
import fr.nsurget.nicolasexamspringboot.Centrafake.service.ModelService;
import fr.nsurget.nicolasexamspringboot.Centrafake.validator.group.ValidationGroup;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(ApiUrlRoute.URL_API_MODEL)
public class ModelRestController {

    private ModelService modelService;

    @GetMapping
    @JsonView(ModelJsonView.ModelEssentialView.class)
    public List<Model> list() {
        return this.modelService.findAll();
    }

    @GetMapping(path = "/{id}")
    @JsonView(ModelJsonView.ModelDetailedView.class)
    Model show(@PathVariable Long id) {
        return modelService.findById(id);
    }

    @PostMapping
    @Validated(ValidationGroup.OnPostItem.class)
    public Model persist(@Valid @RequestBody ModelDTO dto) {
        return modelService.persist(dto, null);
    }

    @PutMapping("/{id}")
    @Validated(ValidationGroup.OnPutItem.class)
    public Model persist(@Valid @RequestBody ModelDTO dto, @PathVariable Long id) {
        return modelService.persist(dto, id);
    }


}