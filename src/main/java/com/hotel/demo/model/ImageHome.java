package com.hotel.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "imageHome")
public class ImageHome {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String pathFile;

    @ManyToOne
    @JoinColumn(name = "home_image_id")
    private Home home;

    public ImageHome() {
    }

    public ImageHome(String pathFile, Home home) {
        this.pathFile = pathFile;
        this.home = home;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }
}

