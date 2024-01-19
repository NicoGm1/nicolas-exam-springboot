package fr.nsurget.nicolasexamspringboot.Centrafake.repository;

import java.util.Optional;

public interface EntityNameRepository<T> {

    Optional<T> findByName(String name);

}