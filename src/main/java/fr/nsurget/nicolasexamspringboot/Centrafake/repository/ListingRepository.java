package fr.nsurget.nicolasexamspringboot.Centrafake.repository;

import fr.nsurget.nicolasexamspringboot.Centrafake.entity.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long> {

}