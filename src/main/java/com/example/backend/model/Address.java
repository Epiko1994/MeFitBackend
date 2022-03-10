package com.example.backend.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue
    @Column(name = "address_id")
    private Integer addressId;

    @OneToOne
    private Profile profile;

    private String addressLine1;

    private String addressLine2;

    private String addressLine3;

    private Integer postalCode;

    private String city;

    private String country;

    public Address() {}
}
