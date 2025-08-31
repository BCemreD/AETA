package com.aeta.aeta.controller;

import com.aeta.aeta.model.dto.auth.LoginRequestDto;
import com.aeta.aeta.model.dto.auth.UserDto;
import com.aeta.aeta.model.dto.auth.UserRegisterRequestDto;
import com.aeta.aeta.model.entity.User;
import com.aeta.aeta.util.JwtUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.aeta.aeta.model.repository.UserRepository;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final ModelMapper modelMapper;

    @PostMapping("/register")
    public String register(@RequestBody @Valid UserRegisterRequestDto request) {
        // DTO → Entity convert
        User user = modelMapper.map(request, User.class);
        // password encode
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        // default role
        user.setRole("USER");

        userRepository.save(user);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginRequestDto request){
        User existingUser = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), existingUser.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(existingUser.getUsername());
        UserDto userDto = modelMapper.map(existingUser, UserDto.class);

        return Map.of(
                "token", token,
                "user", userDto
        );
    }

    @GetMapping("/me")
    public UserDto getCurrentUser(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(token);

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return modelMapper.map(user, UserDto.class);
    }
}
