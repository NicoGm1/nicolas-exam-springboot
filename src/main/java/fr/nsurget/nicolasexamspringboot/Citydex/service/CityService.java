package fr.nsurget.nicolasexamspringboot.Citydex.service;

import fr.nsurget.nicolasexamspringboot.Citydex.entity.City;
import fr.nsurget.nicolasexamspringboot.Citydex.entity.Region;
import fr.nsurget.nicolasexamspringboot.Citydex.exception.NotFoundException;
import fr.nsurget.nicolasexamspringboot.Citydex.repository.CityRepository;
import fr.nsurget.nicolasexamspringboot.Citydex.repository.DepartmentRepository;
import fr.nsurget.nicolasexamspringboot.Citydex.repository.RegionRepository;
import fr.nsurget.nicolasexamspringboot.Citydex.utils.Slugger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CityService {

    private CityRepository cityRepository;

    private RegionRepository regionRepository;

    private Slugger slugger;

    public List<City> findAllByRegionSlug(String slug){
        return cityRepository.findCitiesByRegionSlug(slug);
    }

    public City findById(int id){
        Optional<City> optionalCity = cityRepository.findById(id);
        optionalCity.orElseThrow(() -> new NotFoundException("City", "id", id));
        return optionalCity.get();
    }

    public List<City> findAll(){
        cityRepository.findAll().forEach(c->
                c.setSlug(slugger.slugify(c.getName())));
        cityRepository.flush();
        return cityRepository.findAll();
    }

    public List<City> findByName(String cityName){

        return cityRepository.findByNameIgnoreCaseContainingOrderByPopulationDesc(cityName);
    }
}