package com.hotel.demo.message.request;

public class SearchCategoryHomeByName {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SearchCategoryHomeByName() {
    }

    public SearchCategoryHomeByName(String name) {
        this.name = name;
    }
}
