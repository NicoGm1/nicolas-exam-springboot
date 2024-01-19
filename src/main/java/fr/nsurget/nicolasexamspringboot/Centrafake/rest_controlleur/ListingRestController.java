package fr.nsurget.nicolasexamspringboot.Centrafake.rest_controlleur;

import fr.nsurget.nicolasexamspringboot.Centrafake.entity.Brand;
import fr.nsurget.nicolasexamspringboot.Centrafake.entity.Listing;
import fr.nsurget.nicolasexamspringboot.Centrafake.mapping.ApiUrlRoute;
import fr.nsurget.nicolasexamspringboot.Centrafake.service.BrandService;
import fr.nsurget.nicolasexamspringboot.Centrafake.service.ListingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(ApiUrlRoute.URL_API_LISTING)
public class ListingRestController {

    private ListingService listingService;

    @GetMapping
    public List<Listing> list() {
        return this.listingService.findAll();
    }


}