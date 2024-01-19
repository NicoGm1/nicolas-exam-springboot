package fr.nsurget.nicolasexamspringboot.Centrafake.service;

import fr.nsurget.nicolasexamspringboot.Centrafake.dto.BrandDTO;
import fr.nsurget.nicolasexamspringboot.Centrafake.dto.ModelDTO;
import fr.nsurget.nicolasexamspringboot.Centrafake.entity.Brand;
import fr.nsurget.nicolasexamspringboot.Centrafake.entity.Model;
import fr.nsurget.nicolasexamspringboot.Centrafake.entity.User;
import fr.nsurget.nicolasexamspringboot.Centrafake.exception.NotFoundException;
import fr.nsurget.nicolasexamspringboot.Centrafake.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ModelService {

    private ModelRepository modelRepository;


    public List<Model> findAll() {
        return modelRepository.findAll();
    }

    public Model findById(Long id){
        Optional<Model> optional = modelRepository.findById(id);
        optional.orElseThrow(() -> new NotFoundException("Model", "id", id));
        return optional.get();
    }

    public Model persist(ModelDTO dto, Long id) {
        if (id != null && modelRepository.findById(id).isEmpty()) {
            throw new NotFoundException(
                    "Model", "id", id
            );
        }

        Model model = new Model();
        model.setId(id);
        model.setName(dto.getName());
        return modelRepository.saveAndFlush(model);
    }
}