package com.fiap.restaurantesystem.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Client extends User {
    // Add client-specific fields and methods here if needed
}

