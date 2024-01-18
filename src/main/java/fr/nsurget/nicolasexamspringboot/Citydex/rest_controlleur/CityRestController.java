package fr.nsurget.nicolasexamspringboot.Citydex.rest_controlleur;

import com.fasterxml.jackson.annotation.JsonView;
import fr.nsurget.nicolasexamspringboot.Citydex.entity.City;
import fr.nsurget.nicolasexamspringboot.Citydex.entity.Department;
import fr.nsurget.nicolasexamspringboot.Citydex.entity.Region;
import fr.nsurget.nicolasexamspringboot.Citydex.json_views.CityJsonView;
import fr.nsurget.nicolasexamspringboot.Citydex.json_views.DepartmentJsonView;
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
@RequestMapping()
public class CityRestController {

    private CityService cityService;

    @GetMapping(name = "Cities by region", path = ApiUrlRoute.URL_API_REGION + "/{slug}" + "/city")
    @JsonView(CityJsonView.CityEssentialView.class)
    public List<City> list(@PathVariable String slug) {
        return cityService.findAllByRegionSlug(slug);
    }


    @GetMapping(path = ApiUrlRoute.URL_API_CITY)
    @JsonView(CityJsonView.CityEssentialView.class)
    public List<City> list() {
        return this.cityService.findAll();
    }

    @GetMapping(path = ApiUrlRoute.URL_API_CITY + "/search/{search}")
    @JsonView(CityJsonView.CityEssentialView.class)
    public List<City> search(@PathVariable String search) {
        return cityService.findByName(search);
    }



}