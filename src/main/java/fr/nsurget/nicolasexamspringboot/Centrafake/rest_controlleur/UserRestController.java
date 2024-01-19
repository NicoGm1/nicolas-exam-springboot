package fr.nsurget.nicolasexamspringboot.Centrafake.rest_controlleur;

import fr.nsurget.nicolasexamspringboot.Centrafake.dto.UserPostDTO;
import fr.nsurget.nicolasexamspringboot.Centrafake.entity.User;
import fr.nsurget.nicolasexamspringboot.Centrafake.mapping.ApiUrlRoute;
import fr.nsurget.nicolasexamspringboot.Centrafake.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(ApiUrlRoute.URL_API_USER)
public class UserRestController {

    private UserService userService;


    @GetMapping(path = "/{id}")
    User show(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @PostMapping
    User create(@Valid @RequestBody UserPostDTO userDTO) {
        return userService.create(userDTO);
    }


}