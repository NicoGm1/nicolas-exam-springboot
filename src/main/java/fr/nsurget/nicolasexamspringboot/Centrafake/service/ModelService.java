package fr.nsurget.nicolasexamspringboot.Centrafake.service;

import fr.nsurget.nicolasexamspringboot.Centrafake.entity.Model;
import fr.nsurget.nicolasexamspringboot.Centrafake.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelService {

    private ModelRepository modelRepository;


    public List<Model> findAll() {
        return modelRepository.findAll();
    }
}