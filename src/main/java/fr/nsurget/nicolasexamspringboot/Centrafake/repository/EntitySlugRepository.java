package fr.nsurget.nicolasexamspringboot.Centrafake.repository;

import java.util.Optional;

public interface EntitySlugRepository<T> {

    Optional<T> findBySlug(String slug);

}