package fr.nsurget.nicolasexamspringboot.Citydex.rest_controlleur;

import com.fasterxml.jackson.annotation.JsonView;
import fr.nsurget.nicolasexamspringboot.Citydex.custom_response.ResponsePopulation;
import fr.nsurget.nicolasexamspringboot.Citydex.entity.City;
import fr.nsurget.nicolasexamspringboot.Citydex.entity.Department;
import fr.nsurget.nicolasexamspringboot.Citydex.entity.Region;
import fr.nsurget.nicolasexamspringboot.Citydex.json_views.DepartmentJsonView;
import fr.nsurget.nicolasexamspringboot.Citydex.json_views.RegionJsonView;
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
    @JsonView(RegionJsonView.RegionFullView.class)
    public List<Region> list() {
        return this.regionService.findAll();
    }


    @GetMapping(path = "/{slug}")
    @JsonView(RegionJsonView.RegionFullView.class)
    public Region show(@PathVariable String slug) {
        return regionService.findBySlug(slug);
    }

    @GetMapping(path = "/search/{search}")
    @JsonView(RegionJsonView.RegionEssentialView.class)
    public List<Region> search(@PathVariable String search) {
        return regionService.findByName(search);
    }

    @GetMapping(path = "/{id}/population")
    public ResponsePopulation population(@PathVariable int id) {
        return regionService.populationByRegionId(id);
    }
}