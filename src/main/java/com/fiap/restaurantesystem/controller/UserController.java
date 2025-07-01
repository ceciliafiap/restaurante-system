package com.fiap.restaurantesystem.controller;

import com.fiap.restaurantesystem.domain.User;
import com.fiap.restaurantesystem.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController implements UserApi {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public User create(@Valid @RequestBody User user) {
        return repository.save(user);
    }

    @GetMapping
    public List<User> list() {
        return repository.findAll();
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String login, @RequestParam String password) {
        return repository.findByLogin(login)
                .filter(u -> u.getPassword().equals(password))
                .map(u -> ResponseEntity.ok("Login successful"))
                .orElse(ResponseEntity.status(401).body("Invalid credentials"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @Valid @RequestBody User updatedUser) {
        return repository.findById(id)
                .map(user -> {
                    user.setName(updatedUser.getName());
                    user.setEmail(updatedUser.getEmail());
                    user.setLogin(updatedUser.getLogin());
                    user.setPassword(updatedUser.getPassword());
                    User saved = repository.save(user);
                    return ResponseEntity.ok(saved);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return repository.findById(id)
                .map(user -> {
                    repository.delete(user);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}