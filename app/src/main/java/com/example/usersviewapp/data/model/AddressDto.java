package com.example.usersviewapp.data.model;

public class AddressDto {

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoDto geo;

    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public GeoDto getGeo() {
        return geo;
    }
}
