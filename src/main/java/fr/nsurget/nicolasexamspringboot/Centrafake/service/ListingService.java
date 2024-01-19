package fr.nsurget.nicolasexamspringboot.Centrafake.service;

import fr.nsurget.nicolasexamspringboot.Centrafake.entity.Listing;
import fr.nsurget.nicolasexamspringboot.Centrafake.repository.ListingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListingService {

    private ListingRepository listingRepository;


    public List<Listing> findAll() {
        return listingRepository.findAll();
    }
}