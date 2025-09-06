package com.aeta.aeta.controller;

import com.aeta.aeta.business.service.IUserService;
import com.aeta.aeta.model.dto.auth.LoginRequestDto;
import com.aeta.aeta.model.dto.auth.UserDto;
import com.aeta.aeta.model.dto.auth.UserRegisterRequestDto;
import com.aeta.aeta.model.entity.User;
import com.aeta.aeta.util.JwtUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final IUserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final ModelMapper modelMapper;

    @PostMapping("/register")
    public String register(@RequestBody @Valid UserRegisterRequestDto request) {
        userService.createUser(request);
        return "Başarıyla giriş yapıldı";
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginRequestDto request) {
        User user = userService.getUserEntityByUsername(request.getUsername());

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Geçersiz kullanıcı adı veya şifre");
        }

        String token = jwtUtil.generateToken(user.getUsername());
        UserDto userDto = modelMapper.map(user, UserDto.class);

        return Map.of(
                "token", token,
                "user", userDto
        );
    }

    @GetMapping("/me")
    public UserDto getCurrentUser(@RequestHeader("Authorization") String authHeader) {
        try {
            String token = authHeader.replace("Bearer ", "");
            String username = jwtUtil.extractUsername(token);
            return userService.getUserByName(username);
        } catch (Exception e) {
            throw new BadCredentialsException("Geçersiz token");
        }
    }
}
