package com.rocketstudio.qr.rocketStudio.service;

import com.rocketstudio.qr.rocketStudio.entity.User;
import com.rocketstudio.qr.rocketStudio.dto.UserDTO;
import com.rocketstudio.qr.rocketStudio.entity.House;
import com.rocketstudio.qr.rocketStudio.repository.HouseRepository;
import com.rocketstudio.qr.rocketStudio.repository.RoleRepository;
import com.rocketstudio.qr.rocketStudio.repository.UserRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final HouseRepository houseRepository;
    private final RoleRepository roleRepository;
    private final ObjectProvider<PasswordEncoder> passwordEncoderProvider;

    @Autowired
    public UserService(UserRepository userRepository, HouseRepository houseRepository, RoleRepository roleRepository, ObjectProvider<PasswordEncoder> passwordEncoderProvider) {
        this.userRepository = userRepository;
        this.houseRepository = houseRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoderProvider = passwordEncoderProvider;
    }

    public User authenticate(String email, String password) {
        User user = userRepository.findByEmail(email);
        PasswordEncoder passwordEncoder = passwordEncoderProvider.getIfAvailable();
        if (user != null && passwordEncoder != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        return userRepository.save(user);
    }

    private User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setLastname(userDTO.getLastname());
        user.setDui(userDTO.getDui());
        user.setPhone(userDTO.getPhone());
        user.setGoogleUser(userDTO.getGoogleUser());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setState(userDTO.getState());

        if (userDTO.getHouseId() != null) {
            Optional<House> houseOptional = houseRepository.findById(userDTO.getHouseId());
            houseOptional.ifPresent(user::setHouse);
        }

        return user;
    }

    public boolean deleteUserById(UUID id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }
}