package com.fiap.restaurantesystem.repository;

import com.fiap.restaurantesystem.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    // Métodos específicos para Client podem ser adicionados aqui
}

