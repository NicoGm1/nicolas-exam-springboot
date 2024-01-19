package fr.nsurget.nicolasexamspringboot.Centrafake.service;

import fr.nsurget.nicolasexamspringboot.Centrafake.entity.Brand;
import fr.nsurget.nicolasexamspringboot.Centrafake.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandService {

    private BrandRepository brandRepository;


    public List<Brand> findAll() {
        return brandRepository.findAll();
    }
}