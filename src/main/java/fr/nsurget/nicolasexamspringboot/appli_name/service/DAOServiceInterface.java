package fr.nsurget.nicolasexamspringboot.appli_name.service;

import java.util.List;

public interface DAOServiceInterface<T> {

    List<T> findAll();

    T findById(Long id);

    T findBySlug(String slug);

}