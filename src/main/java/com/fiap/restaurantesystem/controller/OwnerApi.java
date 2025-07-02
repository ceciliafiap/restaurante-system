package com.fiap.restaurantesystem.controller;

import com.fiap.restaurantesystem.domain.Owner;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface OwnerApi {

    @Operation(summary = "Lista todos os proprietários")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    })
    @GetMapping("/owners")
    List<Owner> getAllOwners();

    @Operation(summary = "Busca um proprietário pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Proprietário encontrado"),
        @ApiResponse(responseCode = "404", description = "Proprietário não encontrado")
    })
    @GetMapping("/owners/{id}")
    ResponseEntity<Owner> getOwnerById(@PathVariable Long id);

    @Operation(summary = "Cria um novo proprietário")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Proprietário criado com sucesso")
    })
    @PostMapping("/owners")
    Owner createOwner(@RequestBody Owner owner);

    @Operation(summary = "Atualiza um proprietário existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Proprietário atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Proprietário não encontrado")
    })
    @PutMapping("/owners/{id}")
    ResponseEntity<Owner> updateOwner(@PathVariable Long id, @RequestBody Owner ownerDetails);

    @Operation(summary = "Remove um proprietário pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Proprietário removido com sucesso"),
        @ApiResponse(responseCode = "404", description = "Proprietário não encontrado")
    })
    @DeleteMapping("/owners/{id}")
    ResponseEntity<Void> deleteOwner(@PathVariable Long id);
}

