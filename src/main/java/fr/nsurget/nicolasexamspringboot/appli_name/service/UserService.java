package fr.nsurget.nicolasexamspringboot.appli_name.service;

import fr.nsurget.nicolasexamspringboot.appli_name.dto.UserPostDTO;
import fr.nsurget.nicolasexamspringboot.appli_name.entity.User;
import fr.nsurget.nicolasexamspringboot.appli_name.exception.NotFoundException;
import fr.nsurget.nicolasexamspringboot.appli_name.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements DAOServiceInterface<User> {

    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        optionalUser.orElseThrow(() -> new NotFoundException("User", "id", id));
        return optionalUser.get();
    }

    @Override
    public User findBySlug(String slug) {
        return null;
    }

    public User create(UserPostDTO dto){
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail().toLowerCase());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        return userRepository.saveAndFlush(user);

    }
}