package fr.nsurget.nicolasexamspringboot.Citydex.rest_controlleur;

import com.fasterxml.jackson.annotation.JsonView;
import fr.nsurget.nicolasexamspringboot.Citydex.entity.City;
import fr.nsurget.nicolasexamspringboot.Citydex.entity.Region;
import fr.nsurget.nicolasexamspringboot.Citydex.json_views.CityJsonView;
import fr.nsurget.nicolasexamspringboot.Citydex.mapping.ApiUrlRoute;
import fr.nsurget.nicolasexamspringboot.Citydex.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping
public class CityRestController {

    private CityService cityService;

    @GetMapping(name = "Cities by region", path = ApiUrlRoute.URL_API_REGION + "/{slug}" + "/cities")
    @JsonView(CityJsonView.CityFullView.class)
    public List<City> list(@PathVariable String slug) {
        return cityService.findAllByRegionSlug(slug);
    }

    @GetMapping(path = "/{id}")
    @JsonView(CityJsonView.CityFullView.class)
    public City show(@PathVariable int id) {
        return cityService.findById(id);
    }
}