package fr.nsurget.nicolasexamspringboot.Citydex.repository;

import fr.nsurget.nicolasexamspringboot.Citydex.entity.Department;
import fr.nsurget.nicolasexamspringboot.Citydex.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {

    Optional<Region> findBySlug(String slug);

    List<Region> findByNameIgnoreCaseContaining(String search);

    @Query("SELECT SUM(c.population) FROM City c WHERE c.department.region.id = :slug")
    Long populationByRegionSlug(@Param("slug") String slug);

    //    Deux écriture possible ? ou @Param
    @Query ("select r.name from Region r WHERE r.slug = ?1")
    String findNameBySlug(String slug);
}