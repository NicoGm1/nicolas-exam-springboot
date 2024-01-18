package fr.nsurget.nicolasexamspringboot.Citydex.repository;

import fr.nsurget.nicolasexamspringboot.Citydex.entity.PostalCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostalCodeRepository extends JpaRepository<PostalCode, Integer> {

    List<PostalCode> findByCity_Id(int id);

}