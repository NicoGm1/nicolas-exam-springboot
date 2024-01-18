package fr.nsurget.nicolasexamspringboot.Citydex.repository;

import fr.nsurget.nicolasexamspringboot.Citydex.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    List<City> findCitiesByDepartmentId(Integer id);

    List<City> findByNameIgnoreCaseContainingOrderByPopulationDesc(String search);

    @Query(value = "SELECT c.population from City c where c.id = ?1")
    Long populationByCityId (Integer id);

    @Query(value = "select c from City c where c.department.region = ?1")
    List<City> findCitiesByRegionId(Integer id);

}