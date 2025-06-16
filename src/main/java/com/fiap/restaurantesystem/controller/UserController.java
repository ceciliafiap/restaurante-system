package com.fiap.restaurantesystem.controller;

import com.fiap.restaurantesystem.domain.model.User;
import com.fiap.restaurantesystem.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public User criar(@Valid @RequestBody User user) {
        return repository.save(user);
    }

    @GetMapping
    public List<User> listar() {
        return repository.findAll();
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String login, @RequestParam String senha) {
        return repository.findByLogin(login)
                .filter(u -> u.getSenha().equals(senha))
                .map(u -> ResponseEntity.ok("Login bem-sucedido"))
                .orElse(ResponseEntity.status(401).body("Credenciais inválidas"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> atualizar(@PathVariable Long id, @Valid @RequestBody User userAtualizado) {
        return repository.findById(id)
                .map(user -> {
                    user.setName(userAtualizado.getName());
                    user.setEmail(userAtualizado.getEmail());
                    user.setLogin(userAtualizado.getLogin());
                    user.setSenha(userAtualizado.getSenha());
                    User salvo = repository.save(user);
                    return ResponseEntity.ok(salvo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return repository.findById(id)
                .map(user -> {
                    repository.delete(user);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}