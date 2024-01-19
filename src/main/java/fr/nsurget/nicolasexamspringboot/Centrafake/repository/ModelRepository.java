package fr.nsurget.nicolasexamspringboot.Centrafake.repository;

import fr.nsurget.nicolasexamspringboot.Centrafake.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {

}