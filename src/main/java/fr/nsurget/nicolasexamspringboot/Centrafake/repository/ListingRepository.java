package fr.nsurget.nicolasexamspringboot.Centrafake.repository;

import fr.nsurget.nicolasexamspringboot.Centrafake.entity.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long>,EntitySlugRepository<Listing> {


    List<Listing> findTop12ByOrderByCreatedAtDesc();
}