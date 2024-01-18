package fr.nsurget.nicolasexamspringboot.Citydex.service;

import fr.nsurget.nicolasexamspringboot.Citydex.entity.City;
import fr.nsurget.nicolasexamspringboot.Citydex.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityService {

    private CityRepository cityRepository;

    public List<City> findAllByRegionSlug(String slug){
        return cityRepository.findCitiesByDepartmentRegionSlug(slug);
    }

}