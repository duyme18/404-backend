package com.hotel.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Lob
    private String comment;
    private Long idHome;
    private String date;
    private Boolean isEdit;

    public Comment(String comment, Long idHome, String date, Boolean isEdit, Home home, User user) {
        this.comment = comment;
        this.idHome = idHome;
        this.date = date;
        this.isEdit = isEdit;
        this.home = home;
        this.user = user;
    }

    public Boolean getEdit() {
        return isEdit;
    }

    public void setEdit(Boolean edit) {
        isEdit = edit;
    }

    public Long getIdHome() {
        return idHome;
    }

    public void setIdHome(Long idHome) {
        this.idHome = idHome;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @ManyToOne
    @JoinColumn(name = "home_comment")
    private Home home;

    @ManyToOne
    @JoinColumn(name = "user_comment")
    private User user;

    public Comment(String comment, Home home, User user) {
        this.comment = comment;
        this.home = home;
        this.user = user;
    }

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
