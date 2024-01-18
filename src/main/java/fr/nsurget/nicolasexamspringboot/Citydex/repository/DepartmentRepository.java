package fr.nsurget.nicolasexamspringboot.Citydex.repository;

import fr.nsurget.nicolasexamspringboot.Citydex.entity.City;
import fr.nsurget.nicolasexamspringboot.Citydex.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    Optional<Department> findBySlug(String slug);

    List<Department> findByRegionSlug(String slug);

    List<Department> findByNameIgnoreCaseContaining(String search);

    @Query("SELECT SUM(c.population) FROM City c WHERE c.department.slug = :departmentSlug")
    Long populationByDepartmentSlug(@Param("departmentSlug") String slug);

//    Deux écriture possible ? ou @Param
    @Query ("select d.name from Department d WHERE d.slug = ?1")
    String findNameBySlug(String slug);

}