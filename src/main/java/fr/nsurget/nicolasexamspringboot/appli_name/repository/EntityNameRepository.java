package fr.nsurget.nicolasexamspringboot.appli_name.repository;

import java.util.Optional;

public interface EntityNameRepository<T> {

    Optional<T> findByName(String name);

}