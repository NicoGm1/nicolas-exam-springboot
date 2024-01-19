package fr.nsurget.nicolasexamspringboot.Centrafake.controller;


import fr.nsurget.nicolasexamspringboot.Centrafake.mapping.WebUrlRoute;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(WebUrlRoute.URL_HOME)
@AllArgsConstructor
public class HomeController {

    @GetMapping
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index");
        return mav;
    }

}