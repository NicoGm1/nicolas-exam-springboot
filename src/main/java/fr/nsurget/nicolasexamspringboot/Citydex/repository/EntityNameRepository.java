package fr.nsurget.nicolasexamspringboot.Citydex.repository;

import java.util.Optional;

public interface EntityNameRepository<T> {

    Optional<T> findByName(String name);

}