package com.fiap.restaurantesystem.controller;

import com.fiap.restaurantesystem.domain.model.Owner;
import com.fiap.restaurantesystem.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerRepository ownerRepository;

    @GetMapping
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable Long id) {
        Optional<Owner> owner = ownerRepository.findById(id);
        return owner.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Owner createOwner(@RequestBody Owner owner) {
        return ownerRepository.save(owner);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Owner> updateOwner(@PathVariable Long id, @RequestBody Owner ownerDetails) {
        Optional<Owner> optionalOwner = ownerRepository.findById(id);
        if (optionalOwner.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Owner owner = optionalOwner.get();
        owner.setName(ownerDetails.getName());
        owner.setEmail(ownerDetails.getEmail());
        owner.setLogin(ownerDetails.getLogin());
        owner.setPassword(ownerDetails.getPassword());
        owner.setAddress(ownerDetails.getAddress());
        Owner updatedOwner = ownerRepository.save(owner);
        return ResponseEntity.ok(updatedOwner);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable Long id) {
        if (!ownerRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        ownerRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
