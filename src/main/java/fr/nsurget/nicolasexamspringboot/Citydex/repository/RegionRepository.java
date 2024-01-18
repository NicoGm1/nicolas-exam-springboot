package fr.nsurget.nicolasexamspringboot.Citydex.repository;

import fr.nsurget.nicolasexamspringboot.Citydex.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {

    Optional<Region> findBySlug(String slug);
}