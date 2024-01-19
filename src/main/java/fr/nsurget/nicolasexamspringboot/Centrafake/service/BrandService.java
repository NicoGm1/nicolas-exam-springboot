package fr.nsurget.nicolasexamspringboot.Centrafake.service;

import fr.nsurget.nicolasexamspringboot.Centrafake.dto.BrandDTO;
import fr.nsurget.nicolasexamspringboot.Centrafake.entity.Brand;
import fr.nsurget.nicolasexamspringboot.Centrafake.entity.Listing;
import fr.nsurget.nicolasexamspringboot.Centrafake.exception.NotFoundException;
import fr.nsurget.nicolasexamspringboot.Centrafake.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandService {

    private BrandRepository brandRepository;


    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    public Brand findById(Long id){
        Optional<Brand> optional = brandRepository.findById(id);
        optional.orElseThrow(() -> new NotFoundException("Brand", "id", id));
        return optional.get();
    }

    public Brand persist(BrandDTO dto, Long id) {
        if (id != null && brandRepository.findById(id).isEmpty()) {
            throw new NotFoundException(
                    "Category", "id", id
            );
        }

        Brand brand = new Brand();
        brand.setId(id);
        brand.setName(dto.getName());
        return brandRepository.saveAndFlush(brand);
    }
}