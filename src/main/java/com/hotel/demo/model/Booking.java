package com.hotel.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

import java.util.List;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
    private String checkin;
    @JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
    private String checkout;

    @OneToMany(targetEntity = Home.class)
    private List<Home> homes;

    @ManyToOne
    private User user;

    public Booking() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Booking(String checkin, String checkout, List<Home> homes, User user) {
        this.checkin = checkin;
        this.checkout = checkout;
        this.homes = homes;
        this.user = user;
    }

    public Booking(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public List<Home> getHomes() {
        return homes;
    }

    public void setHomes(List<Home> homes) {
        this.homes = homes;
    }
}
