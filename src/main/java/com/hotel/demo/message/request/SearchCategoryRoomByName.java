package com.hotel.demo.message.request;

public class SearchCategoryRoomByName {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SearchCategoryRoomByName() {
    }

    public SearchCategoryRoomByName(String name) {
        this.name = name;
    }
}
