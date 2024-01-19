package fr.nsurget.nicolasexamspringboot.Centrafake.controller;

import fr.nsurget.nicolasexamspringboot.Centrafake.mapping.WebUrlRoute;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
@Controller
@AllArgsConstructor
public class SearchControler {

    RegionRepository regionRepository;

    DepartmentRepository departmentRepository;

    CityRepository cityRepository;

    @GetMapping(WebUrlRoute.URL_SEARCH + "/{searched}")
    public ModelAndView showSitemap(ModelAndView mav, @PathVariable String searched) {
        mav.setViewName("search/search");
        mav.addObject("search", searched);
        mav.addObject("region", regionRepository.findByNameIgnoreCaseContaining(searched));
        mav.addObject("department", departmentRepository.findByNameIgnoreCaseContaining(searched));
        mav.addObject("city", cityRepository.findByNameIgnoreCaseContainingOrderByPopulationDesc(searched));
        return mav;
    }


}