package fr.nsurget.nicolasexamspringboot.Citydex.service;

import fr.nsurget.nicolasexamspringboot.Citydex.entity.Department;
import fr.nsurget.nicolasexamspringboot.Citydex.entity.Region;
import fr.nsurget.nicolasexamspringboot.Citydex.exception.NotFoundException;
import fr.nsurget.nicolasexamspringboot.Citydex.repository.DepartmentRepository;
import fr.nsurget.nicolasexamspringboot.Citydex.utils.Slugger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentService implements DAOServiceInterface<Department> {

    private DepartmentRepository departmentRepository;

    private Slugger slugger;

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findBySlug(String slug) {
        Optional<Department> optionalDepartment = departmentRepository.findBySlug(slug);
        optionalDepartment.orElseThrow(() -> new NotFoundException("Department", "slug", slug));
        return optionalDepartment.get();
    }
}