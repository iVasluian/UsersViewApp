package com.example.usersviewapp.domain.model;
public class User {

    private final int id;
    private final String name;
    private final String username;
    private final String email;
    private final String street;
    private final String suite;
    private final String city;
    private final String zipcode;
    private final String phone;
    private final String website;
    private final String company;

    public User(
            int id,
            String name,
            String username,
            String email,
            String street,
            String suite,
            String city,
            String zipcode,
            String phone,
            String website,
            String company
    ) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public String getUsername() { return username; }

    public String getEmail() { return email; }

    public String getStreet() { return street; }

    public String getSuite() { return suite; }

    public String getCity() { return city; }

    public String getZipcode() { return zipcode; }

    public String getPhone() { return phone; }

    public String getWebsite() { return website; }

    public String getCompany() { return company; }

    public String getFullAddress() {
        return street + ", " + suite + ", " + city + ", " + zipcode;
    }

    public String getDisplayName() {
        return name;
    }
}