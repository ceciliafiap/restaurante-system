package com.fiap.restaurantesystem.repository;

import com.fiap.restaurantesystem.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    // Métodos específicos para Owner podem ser adicionados aqui
}

