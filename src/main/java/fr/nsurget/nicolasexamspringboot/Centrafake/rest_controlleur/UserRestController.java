package fr.nsurget.nicolasexamspringboot.Centrafake.rest_controlleur;

import com.fasterxml.jackson.annotation.JsonView;
import fr.nsurget.nicolasexamspringboot.Centrafake.dto.UserPostDTO;
import fr.nsurget.nicolasexamspringboot.Centrafake.dto.UserPutDTO;
import fr.nsurget.nicolasexamspringboot.Centrafake.entity.User;
import fr.nsurget.nicolasexamspringboot.Centrafake.json_views.UserJsonView;
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
    @JsonView(UserJsonView.UserDetailedView.class)
    User show(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    @JsonView(UserJsonView.UserDetailedView.class)
        //    @Validated(ValidationGroup.OnPostItem.class)  // à faire
    User create(@Valid @RequestBody UserPostDTO userDTO) {
        return userService.create(userDTO);
    }

    @PutMapping(path = "/{id}")
    @JsonView(UserJsonView.UserDetailedView.class)
        //    @Validated(ValidationGroup.OnPutItem.class) // à faire
    User edit(@Valid @RequestBody UserPutDTO userDTO, @PathVariable Long id) {
        return userService.edit(id, userDTO);
    }

}