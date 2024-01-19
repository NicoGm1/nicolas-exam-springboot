package fr.nsurget.nicolasexamspringboot.Centrafake.service;

import fr.nsurget.nicolasexamspringboot.Centrafake.dto.UserPutDTO;
import fr.nsurget.nicolasexamspringboot.Centrafake.entity.User;
import fr.nsurget.nicolasexamspringboot.Centrafake.dto.UserPostDTO;
import fr.nsurget.nicolasexamspringboot.Centrafake.exception.NotFoundException;
import fr.nsurget.nicolasexamspringboot.Centrafake.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements DAOServiceInterface<User>, UserDetailsService {

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
        user.setEmail(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        return userRepository.saveAndFlush(user);

    }

    public User edit(Long id, UserPutDTO userPutDTO) {
        Optional<User> optionalUser = userRepository.findById(id);
        optionalUser.orElseThrow(() -> new NotFoundException("User", "id", id));
        User user = optionalUser.get();
        if (!userPutDTO.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(userPutDTO.getPassword()));
        }
        return userRepository.saveAndFlush(user);
    }


    @Override
    public UserDetails loadUserByUsername(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("User not found"));
        User user = optionalUser.get();
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                userGrantedAuthority(user.getRoles())
        );
    }

    private List<GrantedAuthority> userGrantedAuthority(String role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<String> roles = Collections.singletonList(role);
        roles.forEach(r -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            if (r.contains("ADMIN")) {
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }
        });
        return authorities;
    }

    public User findByEmail(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        optionalUser.orElseThrow(() -> new NotFoundException("User","email",email));
        return optionalUser.get();
    }

}