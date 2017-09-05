package com.agromarket.model.additional;

public class Address {
    private String city;
    private String region;
    private String location;

    protected Address() {
    }

    public Address(String region, String city, String location) {
        this.city = city;
        this.region = region;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
