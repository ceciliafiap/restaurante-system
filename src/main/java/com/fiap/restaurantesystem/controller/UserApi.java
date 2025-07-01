package com.fiap.restaurantesystem.controller;

import com.fiap.restaurantesystem.domain.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Users", description = "User management API")
@RequestMapping("/users")
public interface UserApi {

    @Operation(summary = "Create a new user")
    @PostMapping
    User create(@Valid @RequestBody User user);

    @Operation(summary = "List all users")
    @GetMapping
    List<User> list();

    @Operation(summary = "Login with user credentials")
    @PostMapping("/login")
    ResponseEntity<String> login(
            @Parameter(description = "User login") @RequestParam String login,
            @Parameter(description = "User password") @RequestParam String password);

    @Operation(summary = "Update an existing user")
    @PutMapping("/{id}")
    ResponseEntity<User> update(
            @Parameter(description = "User ID") @PathVariable Long id,
            @Valid @RequestBody User updatedUser);

    @Operation(summary = "Delete a user")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@Parameter(description = "User ID") @PathVariable Long id);
}

