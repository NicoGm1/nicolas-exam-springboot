package fr.nsurget.nicolasexamspringboot.appli_name.repository;

import fr.nsurget.nicolasexamspringboot.appli_name.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}