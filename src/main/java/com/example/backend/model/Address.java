package com.example.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private Profile profile;

    private String addressLine1;

    private String addressLine2;

    private String addressLine3;

    private Integer postalCode;

    private String city;

    private String country;

    public Address() {}

    public Integer getId() {
        return id;
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
