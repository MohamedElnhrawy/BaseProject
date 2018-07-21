package com.example.mohamedelnhrawy.baseproject.event_bus;

/**
 * Created by cems-it on 3/25/2018.
 */

public class AddressMessageEvent {
    private String Address;
    private double lat,lng;

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
