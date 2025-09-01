package com.aeta.aeta.unit_test;

import com.aeta.aeta.business.impl.UserServiceImpl;
import com.aeta.aeta.model.dto.auth.UserDto;
import com.aeta.aeta.model.dto.auth.UserRegisterRequestDto;
import com.aeta.aeta.model.entity.User;
import com.aeta.aeta.model.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension .class)
class UserServiceRegisterTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void testRegisterCallsSave() {
        // DTO
        UserRegisterRequestDto request = new UserRegisterRequestDto();
        request.setUsername("cemre");
        request.setFirstName("Cemre");
        request.setLastName("D.");
        request.setEmail("cemre@test.com");
        request.setPassword("password123");

        // User entity expected to be saved
        User savedUser = User.builder()
                .id(1L)
                .username(request.getUsername())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password("encodedPassword")
                .build();

        // Mock
        Mockito.when(passwordEncoder.encode(request.getPassword())).thenReturn("encodedPassword");
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(savedUser);

        // Methods
        UserDto created = userService.createUser(request);

        // save call
        Mockito.verify(userRepository).save(Mockito.any(User.class));

        // DTO control
        assertEquals("cemre", created.getUsername());
        assertEquals("Cemre", created.getFirstName());
        assertEquals("D.", created.getLastName());
        assertEquals("cemre@test.com", created.getEmail());
    }
}
