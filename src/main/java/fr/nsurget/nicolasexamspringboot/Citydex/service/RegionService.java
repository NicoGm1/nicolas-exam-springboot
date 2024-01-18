package fr.nsurget.nicolasexamspringboot.Citydex.service;

import fr.nsurget.nicolasexamspringboot.Citydex.entity.Region;
import fr.nsurget.nicolasexamspringboot.Citydex.entity.User;
import fr.nsurget.nicolasexamspringboot.Citydex.exception.NotFoundException;
import fr.nsurget.nicolasexamspringboot.Citydex.repository.RegionRepository;
import fr.nsurget.nicolasexamspringboot.Citydex.utils.Slugger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RegionService implements DAOServiceInterface<Region>{

    private RegionRepository regionRepository;

    private Slugger slugger;

    @Override
    public List<Region> findAll() {

        return regionRepository.findAll();
    }

    @Override
    public Region findBySlug(String slug) {

        Optional<Region> optionalRegion = regionRepository.findBySlug(slug);
        optionalRegion.orElseThrow(() -> new NotFoundException("Region", "slug", slug));
        return optionalRegion.get();
    }
}