package com.fiap.restaurantesystem.controller;

import com.fiap.restaurantesystem.domain.User;
import com.fiap.restaurantesystem.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateUser() {
        User user = new User();
        when(userRepository.save(any(User.class))).thenReturn(user);
        User result = userController.create(user);
        assertThat(result).isNotNull();
        verify(userRepository).save(user);
    }

    @Test
    void shouldListUsers() {
        List<User> users = Arrays.asList(new User(), new User());
        when(userRepository.findAll()).thenReturn(users);
        List<User> result = userController.list();
        assertThat(result).hasSize(2);
        verify(userRepository).findAll();
    }

    @Test
    void shouldLoginSuccessfully() {
        User user = new User();
        user.setPassword("123");
        when(userRepository.findByLogin("login")).thenReturn(Optional.of(user));
        ResponseEntity<String> response = userController.login("login", "123");
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo("Login successful");
    }

    @Test
    void shouldFailLoginWithInvalidCredentials() {
        when(userRepository.findByLogin("login")).thenReturn(Optional.empty());
        ResponseEntity<String> response = userController.login("login", "wrong");
        assertThat(response.getStatusCodeValue()).isEqualTo(401);
        assertThat(response.getBody()).isEqualTo("Invalid credentials");
    }

    @Test
    void shouldUpdateUser() {
        User existing = new User();
        existing.setId(1L);
        User updated = new User();
        updated.setName("New Name");
        updated.setEmail("new@email.com");
        updated.setLogin("newlogin");
        updated.setPassword("newpass");
        when(userRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(userRepository.save(any(User.class))).thenReturn(existing);
        ResponseEntity<User> response = userController.update(1L, updated);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        verify(userRepository).save(existing);
    }

    @Test
    void shouldReturnNotFoundWhenUpdatingNonexistentUser() {
        User updated = new User();
        when(userRepository.findById(1L)).thenReturn(Optional.empty());
        ResponseEntity<User> response = userController.update(1L, updated);
        assertThat(response.getStatusCodeValue()).isEqualTo(404);
    }

    @Test
    void shouldDeleteUser() {
        User user = new User();
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        ResponseEntity<Void> response = userController.delete(1L);
        assertThat(response.getStatusCodeValue()).isEqualTo(204);
        verify(userRepository).delete(user);
    }

    @Test
    void shouldReturnNotFoundWhenDeletingNonexistentUser() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());
        ResponseEntity<Void> response = userController.delete(1L);
        assertThat(response.getStatusCodeValue()).isEqualTo(404);
    }
}

