package fr.nsurget.nicolasexamspringboot.Citydex.rest_controlleur;

import com.fasterxml.jackson.annotation.JsonView;
import fr.nsurget.nicolasexamspringboot.Citydex.custom_response.ResponsePopulation;
import fr.nsurget.nicolasexamspringboot.Citydex.entity.City;
import fr.nsurget.nicolasexamspringboot.Citydex.entity.Department;
import fr.nsurget.nicolasexamspringboot.Citydex.entity.Region;
import fr.nsurget.nicolasexamspringboot.Citydex.json_views.CityJsonView;
import fr.nsurget.nicolasexamspringboot.Citydex.json_views.DepartmentJsonView;
import fr.nsurget.nicolasexamspringboot.Citydex.mapping.ApiUrlRoute;
import fr.nsurget.nicolasexamspringboot.Citydex.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(ApiUrlRoute.URL_API_DEPARTMENT)
public class DepartmentRestController {

    private DepartmentService departmentService;

    @GetMapping
    @JsonView(DepartmentJsonView.DepartmentFullView.class)
    public List<Department> list() {
        return this.departmentService.findAll();
    }


    @GetMapping(path = "/{slug}")
    @JsonView(DepartmentJsonView.DepartmentFullView.class)
    public Department show(@PathVariable String slug) {
        return departmentService.findBySlug(slug);
    }

    @GetMapping(path = "/search/{search}")
    @JsonView(DepartmentJsonView.DepartmentEssentialView.class)
    public List<Department> search(@PathVariable String search) {
        return departmentService.findByName(search);
    }

    @GetMapping(path = "/{id}/population")
    public ResponsePopulation population(@PathVariable int id) {
        return departmentService.populationByDepartmentId(id);
    }

}