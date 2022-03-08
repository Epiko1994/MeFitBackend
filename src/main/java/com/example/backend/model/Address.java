package com.example.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @Column(name = "address_id")
    private UUID addressId = UUID.randomUUID();
}
