package fr.nsurget.nicolasexamspringboot.Centrafake.rest_controlleur;

import fr.nsurget.nicolasexamspringboot.Centrafake.entity.Brand;
import fr.nsurget.nicolasexamspringboot.Centrafake.mapping.ApiUrlRoute;
import fr.nsurget.nicolasexamspringboot.Centrafake.service.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(ApiUrlRoute.URL_API_BRAND)
public class BrandRestController {

    private BrandService brandService;

    @GetMapping
    public List<Brand> list() {
        return this.brandService.findAll();
    }


}