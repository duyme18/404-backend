package com.hotel.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "home")
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private int bedroomQuantity;
    private int bathroomQuantity;
    private Double price;
    private String file;
    private String description;
    private String latitude;
    private String longitude;

    @ManyToOne
    @JoinColumn(name = "category_home_id")
    private CategoryHome categoryHome;
    @ManyToOne
    @JoinColumn(name = "category_room_id")
    private CategoryRoom categoryRoom;
    @ManyToOne
    @JoinColumn(name = "status_home_id")
    private StatusHome statusHome;
    @ManyToOne
    @JoinColumn(name = "booking_home_id")
    private Booking booking;

    public Home(String name, String address, int bedroomQuantity, int bathroomQuantity, Double price, String file, String description, String latitude, String longitude) {
        this.name = name;
        this.address = address;
        this.bedroomQuantity = bedroomQuantity;
        this.bathroomQuantity = bathroomQuantity;
        this.price = price;
        this.file = file;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBedroomQuantity() {
        return bedroomQuantity;
    }

    public void setBedroomQuantity(int bedroomQuantity) {
        this.bedroomQuantity = bedroomQuantity;
    }

    public int getBathroomQuantity() {
        return bathroomQuantity;
    }

    public void setBathroomQuantity(int bathroomQuantity) {
        this.bathroomQuantity = bathroomQuantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public CategoryHome getCategoryHome() {
        return categoryHome;
    }

    public void setCategoryHome(CategoryHome categoryHome) {
        this.categoryHome = categoryHome;
    }

    public CategoryRoom getCategoryRoom() {
        return categoryRoom;
    }

    public void setCategoryRoom(CategoryRoom categoryRoom) {
        this.categoryRoom = categoryRoom;
    }

    public StatusHome getStatusHome() {
        return statusHome;
    }

    public void setStatusHome(StatusHome statusHome) {
        this.statusHome = statusHome;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Home() {
    }
}
