package fr.nsurget.nicolasexamspringboot.Centrafake.repository;

import fr.nsurget.nicolasexamspringboot.Centrafake.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

}