package fr.nsurget.nicolasexamspringboot.Citydex.controller;

import fr.nsurget.nicolasexamspringboot.Citydex.mapping.WebUrlRoute;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class SitemapController {

    private WebUrlRoute webUrlRoute;

    @GetMapping(WebUrlRoute.URL_SITEMAP)
    public ModelAndView showSitemap(ModelAndView mav) {
        mav.setViewName("utils/sitemap");
        mav.addObject("links", webUrlRoute.getSiteMapLinks());
        return mav;
    }


}
