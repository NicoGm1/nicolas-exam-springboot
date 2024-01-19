package fr.nsurget.nicolasexamspringboot.Centrafake.repository;

import fr.nsurget.nicolasexamspringboot.Centrafake.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, EntitySlugRepository<User> {

    Optional<User> findByEmail(String email);
}