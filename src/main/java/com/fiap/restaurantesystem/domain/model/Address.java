package com.fiap.restaurantesystem.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Street is required")
    @Size(max = 100)
    private String street;

    @NotBlank(message = "Number is required")
    @Size(max = 10)
    private String number;

    @NotBlank(message = "City is required")
    @Size(max = 50)
    private String city;

    @NotBlank(message = "State is required")
    @Size(max = 30)
    private String state;

    @NotBlank(message = "Zip code is required")
    @Size(max = 20)
    private String zipCode;

    private String complement;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }
    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    public String getZipCode() { return zipCode; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }
    public String getComplement() { return complement; }
    public void setComplement(String complement) { this.complement = complement; }
}

