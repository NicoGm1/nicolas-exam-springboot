package fr.nsurget.nicolasexamspringboot.Citydex.service;

import fr.nsurget.nicolasexamspringboot.Citydex.entity.City;
import fr.nsurget.nicolasexamspringboot.Citydex.exception.NotFoundException;
import fr.nsurget.nicolasexamspringboot.Citydex.repository.CityRepository;
import fr.nsurget.nicolasexamspringboot.Citydex.repository.PostalCodeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CityService {

    private CityRepository cityRepository;

    private PostalCodeRepository postalCodeRepository;

    public List<City> findAllByRegionSlug(String slug){
        return cityRepository.findCitiesByDepartmentRegionSlug(slug);
    }

    public City findById(int id){
        Optional<City> optionalCity = cityRepository.findById(id);
        optionalCity.orElseThrow(() -> new NotFoundException("City", "id", id));
        return optionalCity.get();
    }

}