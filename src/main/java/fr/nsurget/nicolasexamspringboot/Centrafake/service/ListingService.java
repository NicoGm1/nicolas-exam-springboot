package fr.nsurget.nicolasexamspringboot.Centrafake.service;

import fr.nsurget.nicolasexamspringboot.Centrafake.dto.ListingPostDTO;
import fr.nsurget.nicolasexamspringboot.Centrafake.dto.ListingPutDTO;
import fr.nsurget.nicolasexamspringboot.Centrafake.entity.Listing;
import fr.nsurget.nicolasexamspringboot.Centrafake.entity.Model;
import fr.nsurget.nicolasexamspringboot.Centrafake.entity.User;
import fr.nsurget.nicolasexamspringboot.Centrafake.exception.NotFoundException;
import fr.nsurget.nicolasexamspringboot.Centrafake.repository.ListingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ListingService {

    private ListingRepository listingRepository;

    private UserService userService;

    private ModelService modelService;


    public List<Listing> findAll() {
        return listingRepository.findAll();
    }

    public Listing findById(Long id){
        Optional<Listing> optional = listingRepository.findById(id);
        optional.orElseThrow(() -> new NotFoundException("Listing", "id", id));
        return optional.get();
    }

    public Listing persist(ListingPutDTO dto, Long id) {
        if (id != null && listingRepository.findById(id).isEmpty()) {
            throw new NotFoundException(
                    "Listing", "id", id
            );
        }

        Listing listing = new Listing();
        listing.setId(id);
        listing.setTitle(dto.getTitle());
        listing.setDescription(dto.getDescription());
        listing.setProducedYear(dto.getProducedYear());
        listing.setMileage(dto.getMileage());
        listing.setPrice(dto.getPrice());
        listing.setImage(dto.getImage());
        return getUserAndModelListing(listing, dto.getUser_id(), dto.getModel_id(), dto);
    }

    private Listing getUserAndModelListing(Listing listing, Long userId, Long modelId, Object dto) {
        User user = userService.findById(userId);
        if (user == null) {
            throw new NotFoundException(
                    "User", "id", userId
            );
        }
        listing.setUser(user);
        Model model = modelService.findById(modelId);
        if (model == null) {
            throw new NotFoundException(
                    "Model", "id", modelId
            );
        }
        listing.setModel(model);
        return listingRepository.saveAndFlush(listing);
    }

    public Listing create(ListingPostDTO dto) {
        Listing listing = new Listing();
        listing.setTitle(dto.getTitle());
        listing.setMileage(dto.getMileage());
        listing.setPrice(dto.getPrice());
        return getUserAndModelListing(listing, dto.getUser_id(), dto.getModel_id(), dto);
    }

    public List<Listing> lastReleased() {
        return listingRepository.findTop12ByOrderByCreatedAtDesc();
    }
}