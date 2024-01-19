package fr.nsurget.nicolasexamspringboot.Centrafake.service;

import java.util.List;

public interface DAOServiceInterface<T> {

    List<T> findAll();

    T findBySlug(String slug);

    T findById(Long id);

}