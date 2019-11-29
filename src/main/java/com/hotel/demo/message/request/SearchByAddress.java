package com.hotel.demo.message.request;

public class SearchByAddress {
    private String address;
    public SearchByAddress() {
    }

    public SearchByAddress(String address) {
        this.address = address;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
