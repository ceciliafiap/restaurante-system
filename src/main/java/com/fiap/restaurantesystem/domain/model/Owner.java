package com.fiap.restaurantesystem.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "owners")
public class Owner extends User {
    // Add owner/admin-specific fields and methods here if needed
}

