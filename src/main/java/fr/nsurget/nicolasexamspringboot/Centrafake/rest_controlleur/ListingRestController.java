package fr.nsurget.nicolasexamspringboot.Centrafake.rest_controlleur;

import com.fasterxml.jackson.annotation.JsonView;
import fr.nsurget.nicolasexamspringboot.Centrafake.dto.ListingPostDTO;
import fr.nsurget.nicolasexamspringboot.Centrafake.dto.ListingPutDTO;
import fr.nsurget.nicolasexamspringboot.Centrafake.entity.Listing;
import fr.nsurget.nicolasexamspringboot.Centrafake.json_views.ListingJsonView;
import fr.nsurget.nicolasexamspringboot.Centrafake.mapping.ApiUrlRoute;
import fr.nsurget.nicolasexamspringboot.Centrafake.service.ListingService;
import fr.nsurget.nicolasexamspringboot.Centrafake.validator.group.ValidationGroup;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(ApiUrlRoute.URL_API_LISTING)
public class ListingRestController {

    private ListingService listingService;

    @GetMapping
    @JsonView(ListingJsonView.ListingEssentialView.class)
    public List<Listing> list() {
        return this.listingService.findAll();
    }

    @GetMapping(path = "/{id}")
    @JsonView(ListingJsonView.ListingDetailedView.class)
    Listing show(@PathVariable Long id) {
        return listingService.findById(id);
    }

    @PostMapping
    @JsonView(ListingJsonView.ListingDetailedView.class)
    //    @Validated(ValidationGroup.OnPostItem.class)  // à faire
    public Listing persist(@Valid @RequestBody ListingPostDTO dto) {
        return listingService.create(dto);
    }

    @PutMapping("/{id}")
    @JsonView(ListingJsonView.ListingDetailedView.class)
    //    @Validated(ValidationGroup.OnPutItem.class) // à faire
    public Listing persist(@Valid @RequestBody ListingPutDTO dto, @PathVariable Long id) {
        return listingService.persist(dto, id);
    }

}