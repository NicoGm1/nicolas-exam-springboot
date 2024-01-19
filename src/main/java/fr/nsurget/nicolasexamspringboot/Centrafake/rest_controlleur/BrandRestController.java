package fr.nsurget.nicolasexamspringboot.Centrafake.rest_controlleur;

import com.fasterxml.jackson.annotation.JsonView;
import fr.nsurget.nicolasexamspringboot.Centrafake.dto.BrandDTO;
import fr.nsurget.nicolasexamspringboot.Centrafake.entity.Brand;
import fr.nsurget.nicolasexamspringboot.Centrafake.entity.Listing;
import fr.nsurget.nicolasexamspringboot.Centrafake.json_views.BrandJsonView;
import fr.nsurget.nicolasexamspringboot.Centrafake.json_views.ModelJsonView;
import fr.nsurget.nicolasexamspringboot.Centrafake.mapping.ApiUrlRoute;
import fr.nsurget.nicolasexamspringboot.Centrafake.service.BrandService;
import fr.nsurget.nicolasexamspringboot.Centrafake.validator.group.ValidationGroup;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(ApiUrlRoute.URL_API_BRAND)
public class BrandRestController {

    private BrandService brandService;

    @GetMapping
    @JsonView(BrandJsonView.BrandEssentialView.class)
    public List<Brand> list() {
        return this.brandService.findAll();
    }


    @GetMapping(path = "/{id}")
    @JsonView(BrandJsonView.BrandDetailedView.class)
    Brand show(@PathVariable Long id) {
        return brandService.findById(id);
    }

    @PostMapping
    @Validated(ValidationGroup.OnPostItem.class)
    public Brand persist(@Valid @RequestBody BrandDTO dto) {
        return brandService.persist(dto, null);
    }

    @PutMapping("/{id}")
    @Validated(ValidationGroup.OnPutItem.class)
    public Brand persist(@Valid @RequestBody BrandDTO dto, @PathVariable Long id) {
        return brandService.persist(dto, id);
    }


}