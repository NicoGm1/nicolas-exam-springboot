package fr.nsurget.nicolasexamspringboot.Citydex.service;

import java.util.List;

public interface DAOServiceInterface<T> {

    List<T> findAll();

    T findBySlug(String slug);

}