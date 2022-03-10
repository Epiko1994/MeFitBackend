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

    public Integer getAddressId() {
        return addressId;
    }

    public Profile getProfile() {
        return profile;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
