package fr.nsurget.nicolasexamspringboot.Citydex.rest_controlleur;

import fr.nsurget.nicolasexamspringboot.Citydex.entity.City;
import fr.nsurget.nicolasexamspringboot.Citydex.entity.Region;
import fr.nsurget.nicolasexamspringboot.Citydex.mapping.ApiUrlRoute;
import fr.nsurget.nicolasexamspringboot.Citydex.service.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(ApiUrlRoute.URL_API_REGION)
public class RegionRestController {

    private RegionService regionService;

    @GetMapping
    public List<Region> list() {
        return this.regionService.findAll();
    }


    @GetMapping(path = "/{slug}")
    public Region show(@PathVariable String slug) {
        return regionService.findBySlug(slug);
    }
}