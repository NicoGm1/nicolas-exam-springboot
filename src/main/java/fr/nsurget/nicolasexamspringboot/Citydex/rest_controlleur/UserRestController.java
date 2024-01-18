package fr.nsurget.nicolasexamspringboot.Citydex.rest_controlleur;

import fr.nsurget.nicolasexamspringboot.Citydex.dto.UserPostDTO;
import fr.nsurget.nicolasexamspringboot.Citydex.entity.User;
import fr.nsurget.nicolasexamspringboot.Citydex.mapping.ApiUrlRoute;
import fr.nsurget.nicolasexamspringboot.Citydex.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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