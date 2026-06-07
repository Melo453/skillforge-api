package com.skillforge.skillforge_api.auth;

import com.skillforge.skillforge_api.auth.dto.request.RegisterRequestDTO;
import com.skillforge.skillforge_api.auth.dto.response.AuthResponseDTO;
import com.skillforge.skillforge_api.role.Role;
import com.skillforge.skillforge_api.role.RoleName;
import com.skillforge.skillforge_api.role.RoleRepository;
import com.skillforge.skillforge_api.user.User;
import com.skillforge.skillforge_api.user.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthResponseDTO register(RegisterRequestDTO request){


        if (userRepository.existsByEmail(request.email())){
            throw new RuntimeException("Email already registered");
        }
        Set<Role> roles = Collections.singleton(getRoleByName((RoleName.USER)));

        User user = new User();
        user.setName(request.name());
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setRoles(roles);

        userRepository.save(user);

        return new AuthResponseDTO("Usuario registrado correctamente: ", user.getEmail());
    }

    private Role getRoleByName(RoleName name){
        return roleRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Role not found"));
    }


    public AuthService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }
}
