package com.fiap.restaurantesystem.controller.docs;

import com.fiap.restaurantesystem.domain.Client;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ClientApi {

    @Operation(summary = "Lista todos os clientes")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    })
    @GetMapping("/clients")
    List<Client> getAllClients();

    @Operation(summary = "Busca um cliente pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente encontrado"),
        @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    @GetMapping("/clients/{id}")
    ResponseEntity<Client> getClientById(@PathVariable Long id);

    @Operation(summary = "Cria um novo cliente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente criado com sucesso")
    })
    @PostMapping("/clients")
    Client createClient(@RequestBody Client client);

    @Operation(summary = "Atualiza um cliente existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    @PutMapping("/clients/{id}")
    ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client clientDetails);

    @Operation(summary = "Remove um cliente pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Cliente removido com sucesso"),
        @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    @DeleteMapping("/clients/{id}")
    ResponseEntity<Void> deleteClient(@PathVariable Long id);
}

