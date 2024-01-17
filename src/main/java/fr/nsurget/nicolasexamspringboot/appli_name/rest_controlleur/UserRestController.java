package fr.nsurget.nicolasexamspringboot.appli_name.rest_controlleur;

import com.fasterxml.jackson.annotation.JsonView;
import fr.nsurget.nicolasexamspringboot.appli_name.dto.UserPostDTO;
import fr.nsurget.nicolasexamspringboot.appli_name.entity.User;
import fr.nsurget.nicolasexamspringboot.appli_name.mapping.ApiUrlRoute;
import fr.nsurget.nicolasexamspringboot.appli_name.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(ApiUrlRoute.URL_API_USER)
public class UserRestController {

    private UserService userService;

    @GetMapping
    public List<User> list() {
        return this.userService.findAll();
    }

    @GetMapping(path = "/{id}")
    User show(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    User create(@Valid @RequestBody UserPostDTO userDTO) {
        return userService.create(userDTO);
    }


}