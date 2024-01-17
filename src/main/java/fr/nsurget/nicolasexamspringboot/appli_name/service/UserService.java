package fr.nsurget.nicolasexamspringboot.appli_name.service;

import fr.nsurget.nicolasexamspringboot.appli_name.entity.User;
import fr.nsurget.nicolasexamspringboot.appli_name.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

}