package fr.nsurget.nicolasexamspringboot.appli_name.rest_controlleur;

import fr.nsurget.nicolasexamspringboot.appli_name.entity.User;
import fr.nsurget.nicolasexamspringboot.appli_name.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/instant_faking/user")
public class UserRestController {

    private UserService userService;

    @GetMapping
    public List<User> list() {
        return this.userService.findAll();
    }


}